package com.bank;

public class Customer {
	String customerName;
	String customerAccno;
	String customerDOB;
	String customerAddress;
	String customerPAN;
	String customerAdhar;
	String money;
	String mobNo;
	boolean flag;

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAccno() {
		return customerAccno;
	}

	public void setCustomerAccno(String customerAccno) {
		this.customerAccno = customerAccno;
	}

	public String getCustomerDOB() {
		return customerDOB;
	}

	public void setCustomerDOB(String customerDOB) {
		this.customerDOB = customerDOB;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPAN() {
		return customerPAN;
	}

	public void setCustomerPAN(String customerPAN) {
		this.customerPAN = customerPAN;
	}

	public String getCustomerAdhar() {
		return customerAdhar;
	}

	public void setCustomerAdhar(String customerAdhar) {
		this.customerAdhar = customerAdhar;
	}

	@Override
	public String toString() {
		return customerName + "|" + customerAccno + "|" + customerDOB + "|" + customerAddress + "|" + customerPAN + "|"
				+ customerAdhar + "|" + money + "|" + flag + "|" + mobNo;
	}

}
