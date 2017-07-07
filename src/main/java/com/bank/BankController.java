package com.bank;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.service.BankInterface;

@RestController
@RequestMapping("/")
public class BankController {
	ArrayList<Customer> myCustomerArrayList = new ArrayList<Customer>();
	int customerCounter = 0;
	// Things to learn
	// Dependency Injection -- Spring StereoTypes
	// rewrite the code for PUT and POST
	// Create another class called as Database.
	// Migrate the array handling in Database class
	// Logic: 
	// write the methods to read and write from text file
	// Call the methods of Database class from Service class for all 4 methods (PUT, POST, DELETE, GET) where reading and writing is necessary
	
	// Call
	// Old way
	//BankInterfaceImpl bnkImpl = new BankInterfaceImpl();
	// New way
	@Autowired
	BankInterface bnkImpl;
	
	
	// Scanner sc1 = new Scanner(System.in);

	// public void readFile_version2() throws IOException {
	//
	// FileReader myReader = new FileReader("temp3.txt");
	// BufferedReader in = new BufferedReader(myReader);
	//
	// String line;
	//
	// while ((line = in.readLine()) != null) {
	// // System.out.println(line);
	//
	// Customer cust = new Customer();
	// StringTokenizer st = new StringTokenizer(line, "|");
	// while (st.hasMoreTokens()) {
	//
	// cust.setCustomerName(st.nextToken());
	// cust.setCustomerAccno(st.nextToken());
	// cust.setCustomerDOB(st.nextToken());
	// cust.setCustomerAddress(st.nextToken());
	// cust.setCustomerPAN(st.nextToken());
	// cust.setCustomerAdhar(st.nextToken().trim());
	// cust.setMoney(st.nextToken().trim());
	// cust.setMobNo(st.nextToken().trim());
	// }
	// myCustomerArrayList.add(cust);
	//
	// // myCustomerArraylist.add(customerCounter) = cust;
	// customerCounter++;
	//
	// }
	//
	// in.close();
	// // System.out.println(customerCounter);
	// }
	/*
	 * 
	 * REST - Representational State transfer Client - Server architecture
	 * 
	 * CRUD - Create Read Update Delete
	 * 
	 * User - Account
	 * 
	 * HTTP
	 * 
	 * GET - Read POST- Create PUT - Update DELETE - Delete
	 * 
	 * https://spring.io/guides/gs/rest-service/
	 */

	/**
	 * 
	 * REST- Controller --> Service --> Database Layer (Outside call)
	 * 
	 * Controller = Input, validate input, parse input, exception and error
	 * handling, Http response. Service = Business logic DAL (Database Access
	 * Layer) = Database connectivity (connection and datasource), database
	 * calls
	 * 
	 */
	// TODO: Method getUser javadoc is missing
	@GetMapping
	public ArrayList<Customer> getUser(@RequestParam(value = "acno", required = false) String acno) {// Welcome

		if (acno == null)
			return myCustomerArrayList;

		String leftTrimedacno = validateGetUser(acno);

		if (leftTrimedacno == null)
			throw new RuntimeException("Account number received is not valid. Please provide correct account number");

		// Call service, pass account number and get customer list.

		ArrayList<Customer> returnList = bnkImpl.getCustomerDetails(leftTrimedacno, myCustomerArrayList);
		return returnList;

	}

	// TODO: Method validateGetUser javadoc is missing
	private String validateGetUser(String acno) {
		String rightTrimedacno = acno.trim();
		String leftTrimedacno = rightTrimedacno.replaceAll("^\\s+", "");

		if (!leftTrimedacno.startsWith("SNGURB"))
			return null;

		// check if the account number is present in database return the account
		// number if present return null otherwise
		String validatedAcno = checkIfAccountNumberIsPresent(leftTrimedacno);
		return validatedAcno;
	}

	/**
	 * This method takes the account number String It checks if the account
	 * number exists in database or not It also checks if the boolean flag for
	 * account number is true or not. (It should be true for valid account)
	 * Returns null otherwise
	 * 
	 * @param acno
	 * @return
	 */
	private String checkIfAccountNumberIsPresent(String acno) {
		for (int i = 0; i < myCustomerArrayList.size(); i++) {

			// Check if the account number is valid and matches with the
			// customer Number
			if ((myCustomerArrayList.get(i).isFlag()) && (acno.equals(myCustomerArrayList.get(i).getCustomerAccno())))
				return acno;
		}
		return null;
	}

	@PostMapping
	// TODO: Method createAccount javadoc is missing
	public Customer createAccount(@RequestParam(value = "name") String name, @RequestParam(value = "dob") String dob,
			@RequestParam(value = "address") String address, @RequestParam(value = "adhar") String adhar,
			@RequestParam(value = "money") String money, @RequestParam(value = "mobNo") String mobNo) {
		String customerAccountNumber = "SNGURB-" + (customerCounter);

		try {
			Customer cs = new Customer();
			cs.setCustomerName(name);
			cs.setCustomerAccno(customerAccountNumber);
			cs.setCustomerDOB(dob);
			cs.setCustomerAddress(address);
			cs.setCustomerAdhar(adhar);
			cs.setMoney(money);
			cs.setFlag(true);
			cs.setMobNo(mobNo);
			myCustomerArrayList.add(cs);

			customerCounter++;

			return cs;

		} catch (ArithmeticException e) {
			System.out.println("Warning: ArithmeticException");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Warning: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			System.out.println("Warning: Some Other exception");
		}
		System.out.println("Out of try-catch block...");
		return null;
	}

	@PutMapping
	// TODO: Method updateAccount javadoc is missing
	public Customer updateAccount(@RequestParam(value = "acno") String acno, @RequestParam(value = "name") String name,
			@RequestParam(value = "dob") String dob, @RequestParam(value = "address") String address,
			@RequestParam(value = "adhar") String adhar, @RequestParam(value = "mobNo") String mobNo) {
		try {
			for (int i = 0; i < myCustomerArrayList.size(); i++) {
				if (myCustomerArrayList.get(i).isFlag()
						&& (acno.equals(myCustomerArrayList.get(i).getCustomerAccno()))) {
					Customer cust = myCustomerArrayList.get(i);

					if (cust.getCustomerAccno().equals(acno)) {
						cust.setCustomerAccno(acno);
						cust.setCustomerName(name);
						cust.setCustomerDOB(dob);
						cust.setCustomerAddress(address);
						cust.setCustomerAdhar(adhar);
						cust.setMobNo(mobNo);
						return myCustomerArrayList.get(i);
					}
				}
			}
			throw new RuntimeException("Account Not Present in Database or deleted from database");
		} catch (Exception e) {
			throw new RuntimeException("Account Not Present in Database or deleted from database");
		}
	}

	// TODO: Method deleteAccount javadoc is missing
	@DeleteMapping
	public Customer deleteAccount(@RequestParam(value = "delcust") String delcust) {
		Customer deleteAccount= bnkImpl.deleteAccount(delcust, myCustomerArrayList);
		return deleteAccount;
	}

}
