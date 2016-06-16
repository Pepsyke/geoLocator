package service;

import beans.IPv4;
import beans.Location;

public interface MainService {
	public long getIPinNumbers(IPv4 IP);
	public Location getLocationByIPAddress(IPv4 IP);
	public boolean locationEmpty(Location location);
}
