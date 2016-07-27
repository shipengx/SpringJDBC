package com.shipeng.SpringJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shipeng.customer.dao.CustomerDao;
import com.shipeng.customer.model.Customer;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-Module.xml");

		CustomerDao customerDAO = (CustomerDao) context.getBean("customerDAO");
		Customer customer = new Customer(1, "Shipeng", 28);
		customerDAO.insert(customer);

		Customer customer1 = customerDAO.findByCustomerId(1);
		System.out.println(customer1);

	} // end main
} // end Test
