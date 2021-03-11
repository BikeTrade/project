package com.biketrade.service;

import java.util.List;

import com.biketrade.model.Bike;
import com.biketrade.model.BikeStatus;
import com.biketrade.model.User;

public interface IBTBikeDetailsService {
	public Bike saveBike(Bike bike );
	public List<Bike> findByStatus( BikeStatus status);
	public int updateBike(Long bid,BikeStatus status);
	public List<Bike> findByUser( User user);
	
}
