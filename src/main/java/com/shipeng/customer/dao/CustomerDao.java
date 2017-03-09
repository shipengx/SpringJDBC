package com.shipeng.customer.dao;

import com.shipeng.customer.model.Customer;

public interface CustomerDao {
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
}
