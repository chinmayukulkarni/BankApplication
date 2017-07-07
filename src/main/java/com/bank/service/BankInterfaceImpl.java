package com.bank.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.bank.Customer;

@Service
public class BankInterfaceImpl implements BankInterface {

	/**
	 * 
	 * This methods is responsible for returning customer details.
	 * It takes 'account number' and 'all customer' list as input.
	 * It returns only one customer from the array list.
	 * 
	 */
	@Override
	public ArrayList<Customer> getCustomerDetails(String accountNumber, ArrayList<Customer> myCustomerArrayList) {
		try {
			for (int i = 0; i < myCustomerArrayList.size(); i++) {
				if (myCustomerArrayList.get(i).getCustomerAccno().equals(accountNumber)) {
					ArrayList<Customer> returnList = new ArrayList<>();
					returnList.add(myCustomerArrayList.get(i));
					return returnList;
				}

			}
		} catch (Exception e) {
			throw new RuntimeException("Account Not Present in Database or deleted from database");
		}

		return null;
	}
public Customer deleteAccount(String accountnumber,ArrayList<Customer> myCustomerArrayList)
{try {
	for (int i = 0; i < myCustomerArrayList.size(); i++) {
		if (myCustomerArrayList.get(i).isFlag()) {
			while (accountnumber.equals(myCustomerArrayList.get(i).getCustomerAccno())) {

				if (myCustomerArrayList.get(i).getCustomerAccno().equals(accountnumber)) {

					myCustomerArrayList.get(i).setFlag(false);

					return myCustomerArrayList.get(i);
				}
			}
		}
	}
	throw new RuntimeException("Account Not Present in Database or deleted from database");

} catch (Exception e) {
	throw new RuntimeException("Account Not Present in Database or deleted from database");
}
}
}
