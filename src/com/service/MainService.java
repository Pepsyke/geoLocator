package com.service;

import com.beans.IPv4;
import com.beans.Location;

public interface MainService {
	public long getIPinNumbers(IPv4 IP);
	public Location getLocationByIPAddress(IPv4 IP);
	public boolean locationEmpty(Location location);
}
