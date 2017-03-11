package com.shipeng.SpringJDBC;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shipeng.customer.dao.CustomerDao;
import com.shipeng.customer.dao.impl.PubmaticDaoImpl;
import com.shipeng.customer.model.Customer;
import com.shipeng.customer.model.Pubmatic;

public class Test {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-Module.xml");
		
		/*
		CustomerDao customerDAO = (CustomerDao) context.getBean("customerDAO");
		Customer customer = new Customer("Shipeng", 28);
		customerDAO.insert(customer);

		Customer customer1 = customerDAO.findByCustomerId(1);
		System.out.println(customer1);
		
		
		PubmaticDaoImpl pubmaticDaoImpl = (PubmaticDaoImpl) context.getBean("pubmaticDao");
		Pubmatic pubmatic = new Pubmatic(2,"2");
		pubmaticDaoImpl.insert(pubmatic);
		*/
		
		PubmaticDaoImpl pubmaticDaoImpl = (PubmaticDaoImpl) context.getBean("pubmaticDao");
		List<Pubmatic> pubmaticList = pubmaticDaoImpl.getPubmaticList();
		System.out.println(pubmaticList);
		
		
	} // end main
	
} // end Test

	
	
	
