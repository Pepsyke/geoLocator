package beans;

public class Location {

	private int id;
	private int ipRangeId;
	private String Country;
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
