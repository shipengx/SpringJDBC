package com.shipeng.customer.geo;

public class Geo {

	private String geoFlag;
	
	public String getGeoFlag() {
		return this.geoFlag;
	}
	
	public void setGeoFlag(String flag) {
		this.geoFlag = flag;
	}
	
	@Override
	public String toString() {
		return "the geo flag is: " + geoFlag;
	}
	
} //end Geo
