package com.shipeng.customer.model;

public class Customer {

	private int custId;
	private String name;
	private int age;
	
	public Customer(int custId, String name, int age) {
		this.custId = custId;
		this.name = name;
		this.age = age;
	}

	public int getCustId() {
		return this.custId;
	}

	public void setCustId(int value) {
		this.custId = value;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int value) {
		this.age = value;
	}
	
	@Override
	public String toString() {
		return "Customer id: " + this.custId + ", name: " + this.name + ", age: " + this.age;
	}
} // end class Customer
