package com.bank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public interface BankInterface {
	public String createAccountInBank(String name, String dob, String addes, String pan, String adhar, int money)
			throws IOException;

	public Customer[] getAllCustomersInBank();

	public Customer updateAccountFromAccountNo(String acno, String name, String addes, String dob, String pan,
			String adhar);

	public Customer[] deleteAccount(String delCust);

	public Customer depositMoney(int amount, String accountNumber);

	public Customer withdrawMoney(int amount, String accountNumber);

	public Customer getAccountFromAccountNumber(String AccountNo1);

	public void printAll();

	public void writeFile() throws IOException;

	public void printOneAcc(String oneCustomer);

	public void readFile() throws IOException;

	public void readFile_Version1() throws IOException;

	public void createHaandle() throws IOException;

	public void updateHandle();

	public void deleteHandle(String accountNumber);

	public void printOneHandle();

	public void depositHandle();

	public void withdrawHandle();

	public String getAcccountNumber(Scanner sc);
}
