package com.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class IPv4 {
	@NotNull
	@Min(0)
	@Max(255)
	private int first;
	@NotNull
	@Min(0)
	@Max(255)
	private int second;
	@NotNull
	@Min(0)
	@Max(255)
	private int third;
	@NotNull
	@Min(0)
	@Max(255)
	private int fourth;

	
	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getThird() {
		return third;
	}

	public void setThird(int third) {
		this.third = third;
	}

	public int getFourth() {
		return fourth;
	}

	public void setFourth(int fourth) {
		this.fourth = fourth;
	}

	@Override
	public String toString() {
		return first + "." + second + "." + third + "." + third + "." + fourth;
	}
	
	
}
