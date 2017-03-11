package com.shipeng.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.shipeng.customer.model.Pubmatic;

public class FileUtil {
	
	public List<Pubmatic> readInputCSV(String fileName) {
		
		List<Pubmatic> result = new ArrayList<Pubmatic>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
			while ((line = br.readLine()) != null) {
				if (!line.contains("Pubmatic siteId, bidId")) {
					continue;
				}
				String[] wordArray = line.split("=")[1].trim().split(",");
				long bidId    = Long.parseLong(wordArray[1].trim());
				String siteId = wordArray[0].trim();
				result.add(new Pubmatic(bidId, siteId));
				
			} //end while

		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
