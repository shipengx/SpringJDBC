package com.shipeng.SpringJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shipeng.customer.geo.Geo;


public class PropertyTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-Module.xml");
		Geo geo = (Geo) context.getBean("Geo");
		System.out.println(geo);
		
	} //end main
	
} //end PropertyTest
