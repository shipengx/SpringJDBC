package com.shipeng.customer.dao;

import com.shipeng.customer.model.Customer;

public interface CustomerDao {
	public void insert(Customer customer);
	public void deleteCustomerById(int customerId);
	public void update(Customer customer);
	public Customer findByCustomerId(int custId);
}
