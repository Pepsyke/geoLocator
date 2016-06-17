package com.dao;

import java.util.List;

import com.beans.IPRange;
import com.beans.Location;

public interface MainDAO {

	public List<IPRange> getAllRanges();
	
	public List<Location> getLocations();
}
