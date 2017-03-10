package com.shipeng.customer.model;

public class Pubmatic {

	private long bidId;
	private String siteId;
	
	public Pubmatic() {
	}
	
	public Pubmatic(long bidId, String siteId) {
		this.bidId = bidId;
		this.siteId = siteId;
	}
	
	public long getBidId() {
		return this.bidId;
	}
	
	public void setBidId(long bidId) {
		this.bidId = bidId;
	}
	
	public String getSiteId() {
		return this.siteId;
	}
	
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	
} //end class Pubmatic
