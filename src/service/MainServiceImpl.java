package service;

import java.util.List;

import beans.IPRange;
import beans.IPv4;
import beans.Location;
import dao.MainDAOImpl;

public class MainServiceImpl implements MainService {

	private MainDAOImpl dao = new MainDAOImpl();

	public Location getLocationByIPAddress(IPv4 IP) {

		IPRange correctRange = getCorrectRange(IP);
		Location correctLocation = getCorrectLocation(correctRange);

		return correctLocation;
	}

	private IPRange getCorrectRange(IPv4 IP) {

		List<IPRange> ranges = dao.getAllRanges();
		IPRange correctRange = null;
		long bottom, top, input;

		for (IPRange range : ranges) {
			bottom = getIPinNumbers(range.getBottom());
			top = getIPinNumbers(range.getTop());
			input = getIPinNumbers(IP);

			if (input <= top && input >= bottom) {
				correctRange = range;
				break;
			}
		}

		return correctRange != null ? correctRange : new IPRange();
	}

	private Location getCorrectLocation(IPRange range) {

		List<Location> locations = dao.getLocations();
		Location correctLocation = null;

		for (Location location : locations) {
			if (range.getId() == location.getIpRangeId()) {
				correctLocation = location;
			}
		}

		return correctLocation != null ? correctLocation : new Location();
	}

	public long getIPinNumbers(IPv4 IP) {
		return (IP.getFirst() << 24) + (IP.getSecond() << 16) + (IP.getThird() << 8) + IP.getFourth();
	}

	public boolean locationEmpty(Location location) {
		if (location.getCity() == null || location.getCity().equals("")) {

			return true;
		} else {
			return false;
		}
	}
}
