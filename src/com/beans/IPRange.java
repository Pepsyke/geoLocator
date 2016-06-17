package com.beans;

public class IPRange {
	private int id;
	private IPv4 bottom;
	private IPv4 top;
	
	public IPv4 getBottom() {
		return bottom;
	}
	public void setBottom(IPv4 bottom) {
		this.bottom = bottom;
	}
	public IPv4 getTop() {
		return top;
	}
	public void setTop(IPv4 top) {
		this.top = top;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
