package com.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Location {
	
	@NotNull
	@Min(1)
	@Max(99)
	private int id;
	@NotNull
	@Min(1)
	@Max(99)
	private int ipRangeId;
	@Size(min=1, max=50)
	private String Country;
	@Size(min=1, max=50)
	private String City;
	
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIpRangeId() {
		return ipRangeId;
	}
	public void setIpRangeId(int ipRangeId) {
		this.ipRangeId = ipRangeId;
	}
	
	@Override
	public String toString() {
		return "Country = " + Country + ", City = " + City;
	}
	
	
}
