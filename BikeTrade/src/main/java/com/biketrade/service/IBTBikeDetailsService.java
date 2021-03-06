package com.biketrade.service;

import java.util.List;

import com.biketrade.model.Bike;
import com.biketrade.model.BikeStatus;

public interface IBTBikeDetailsService {
	public Bike saveBike(Bike bike );
	public List<Bike> findByBikeStatus();
	public int updateBike(int bid,BikeStatus status);

	
}
