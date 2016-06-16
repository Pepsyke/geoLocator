package dao;

import java.util.List;

import beans.IPRange;
import beans.Location;

public interface MainDAO {

	public List<IPRange> getAllRanges();
	
	public List<Location> getLocations();
}
