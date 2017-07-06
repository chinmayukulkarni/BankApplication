package com.bank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BankController {
	ArrayList<Customer> myCustomerArrayList = new ArrayList<Customer>();
	int customerCounter = 0;
	Scanner sc1 = new Scanner(System.in);
	public void readFile_version2() throws IOException {

		FileReader myReader = new FileReader("temp3.txt");
		BufferedReader in = new BufferedReader(myReader);

		String line;

		while ((line = in.readLine()) != null) {
			// System.out.println(line);

			Customer cust = new Customer();
			StringTokenizer st = new StringTokenizer(line, "|");
			while (st.hasMoreTokens()) {

				cust.setCustomerName(st.nextToken());
				cust.setCustomerAccno(st.nextToken());
				cust.setCustomerDOB(st.nextToken());
				cust.setCustomerAddress(st.nextToken());
				cust.setCustomerPAN(st.nextToken());
				cust.setCustomerAdhar(st.nextToken().trim());
				cust.setMoney(st.nextToken().trim());
				cust.setMobNo(st.nextToken().trim());
			}
			myCustomerArrayList.add(cust);

			// myCustomerArraylist.add(customerCounter) = cust;
			customerCounter++;

		}

		in.close();
		// System.out.println(customerCounter);
	}
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

	@GetMapping
	public String getUser(@RequestParam(value = "name") String name, @RequestParam(value = "dob") String dob,
			@RequestParam(value = "address") String address, @RequestParam(value = "adhar") String adhar,
			@RequestParam(value = "money") String money, @RequestParam(value = "mobno") String mobno) {// Welcome
		// page,
		// non-rest

		String accountNumner = createAccount(name, dob, address, adhar, money, mobno);
		if (!name.equalsIgnoreCase("kulkarni"))
			throw new RuntimeException("You are not Kulkarni");
		return "Get user executed, with user: " + name + " ";
	}

	@PostMapping
	public String createAccount(@RequestParam(value = "name") String name, @RequestParam(value = "dob") String dob,
			@RequestParam(value = "address") String address, @RequestParam(value = "adhar") String adhar,
			@RequestParam(value = "money") String money, @RequestParam(value = "mobNo") String mobNo) {
		String customerAccountNumber = "SNGURB-" + (customerCounter);

		try {
			Customer cs = new Customer();
			cs.setCustomerName(name);
			cs.setCustomerAccno(customerAccountNumber);
			cs.setCustomerDOB(dob);
			cs.setCustomerAddress(address);
			// cs.setCustomerPAN(pan);
			cs.setCustomerAdhar(adhar);
			cs.setMoney(money);
			cs.setFlag(true);
			cs.setMobNo(mobNo);
			myCustomerArrayList.add(cs);

			customerCounter++;

			return customerAccountNumber;

		} catch (ArithmeticException e) {
			System.out.println("Warning: ArithmeticException");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Warning: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			System.out.println("Warning: Some Other exception");
		}
		System.out.println("Out of try-catch block...");
		return customerAccountNumber;
		// return "Post account executed";
	}

	@PutMapping

	public Customer updateAccount(@RequestParam(value = "acno") String acno, @RequestParam(value = "name") String name,
			@RequestParam(value = "dob") String dob, @RequestParam(value = "address") String addes,
			@RequestParam(value = "adhar") String adhar, @RequestParam(value = "mobNo") String mobNo) {
		try {
			for (int i = 0; i < myCustomerArrayList.size(); i++) {

				Customer cust = myCustomerArrayList.get(i);

				if (cust.getCustomerAccno().equals(acno)) {
					cust.setCustomerAccno(acno);
					cust.setCustomerName(name);
					cust.setCustomerDOB(dob);
					cust.setCustomerAddress(addes);
					// cust.setCustomerPAN(pan);
					cust.setCustomerAdhar(adhar);
					cust.setMobNo(mobNo);
					return cust;

				}

			}
		} catch (Exception e) {

			System.out.println("Error" + e);
		}

		return null;
	}

	@DeleteMapping
	public ArrayList<Customer> deleteAccount(@RequestParam(value = "delcust") String delcust) {
		try {
			for (int i = 0; i < myCustomerArrayList.size(); i++) {
				if (myCustomerArrayList.get(i).isFlag()) {
					while (delcust.equals(myCustomerArrayList.get(i).getCustomerAccno())) {

						if (myCustomerArrayList.get(i).getCustomerAccno().equals(delcust)) {

							myCustomerArrayList.get(i).setFlag(false);
							System.out.println("Account Deleted Successfully");
							return myCustomerArrayList;
						}
					}
				}
			}
			System.out.println("Account Not Present in Database");

		} catch (Exception e) {
			System.out.println("Enter Correct Account number");

		}
		return null;
	}

}
