package com.bank.service;

import java.util.ArrayList;

import com.bank.Customer;

public interface BankInterface {

	public ArrayList<Customer> getCustomerDetails(String accountNumber, ArrayList<Customer> myCustomerArrayList);
	public Customer deleteAccount(String accountnumber,ArrayList<Customer> myCustomerArrayList);
}
