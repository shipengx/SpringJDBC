package com.shipeng.SpringJDBC;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shipeng.customer.dao.impl.PubmaticDaoImpl;
import com.shipeng.customer.model.Pubmatic;
import com.shipeng.util.FileUtil;

public class Ingest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-Module.xml");
		
		
		FileUtil fileUtil = new FileUtil();
		List<Pubmatic> pubmaticList = fileUtil.readInputCSV("/Users/sxu/Desktop/input.txt");
		//System.out.println(pubmaticList);
	
		PubmaticDaoImpl pubmaticDaoImpl = (PubmaticDaoImpl) context.getBean("pubmaticDao");
		pubmaticDaoImpl.ingestLogs(pubmaticList);
		
	} // end main
	
}
