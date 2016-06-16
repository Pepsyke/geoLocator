package beans;

public class IPv4 {

	private int first;
	private int second;
	private int third;
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
