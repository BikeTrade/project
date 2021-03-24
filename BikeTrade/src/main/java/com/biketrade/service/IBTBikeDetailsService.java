package com.biketrade.service;

import java.util.Date;
import java.util.List;

import com.biketrade.model.Bike;
import com.biketrade.model.BikeState;
import com.biketrade.model.BikeStatus;
import com.biketrade.model.BrandName;
import com.biketrade.model.User;

public interface IBTBikeDetailsService {
	public Bike saveBike(Bike bike );
	public List<Bike> findByStatus( BikeStatus status);
	public int updateBike(Long bid,BikeStatus status);
	public List<Bike> findByUser( User user);
	public List<Bike> findById(long bikeid);
	public long count();
	public int countByStatus(BikeStatus status);
	public int countByState(BikeState state);
	public Bike findAllById(long bikeid);
	
	
	  public int countByBrandAndStateAndStatus(BrandName brand,BikeState state,BikeStatus status);
	  public int countByStateAndSoldDate(BikeState state, String soldDate);
}
