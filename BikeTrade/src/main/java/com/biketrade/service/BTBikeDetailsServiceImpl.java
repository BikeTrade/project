package com.biketrade.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biketrade.dao.BTBikeRepository;
import com.biketrade.model.Bike;
import com.biketrade.model.BikeState;
import com.biketrade.model.BikeStatus;
import com.biketrade.model.BrandName;
import com.biketrade.model.User;

@Service
@Transactional
public class BTBikeDetailsServiceImpl implements IBTBikeDetailsService {

	@Autowired
	public BTBikeRepository bikeRepository;

 

	@Override
	public Bike saveBike(Bike bike) {
		return bikeRepository.saveAndFlush(bike);
	}

	@Override
	public List<Bike> findByStatus( BikeStatus status) {
		return bikeRepository.findByStatus(status);
	}

	@Override
	public int updateBike(Long bid, BikeStatus status) {
		return bikeRepository.updateBike(bid, status);
	}

	@Override
	public List<Bike> findByUser(User user) {		
		return bikeRepository.findByUser(user);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return bikeRepository.count();
	}


	@Override
	public int countByStatus(BikeStatus status) {
		
		return bikeRepository.countByStatus(status);
	}


	@Override
	public int countByState(BikeState state) {
		
		return bikeRepository.countByState(state);
	}

	@Override
	public List<Bike> findById(long bikeid) {
		
		return bikeRepository.findById(bikeid);
	}

	@Override
	public Bike findAllById(long bikeid) {
		// TODO Auto-generated method stub
		return bikeRepository.findAllById(bikeid);
	}

	@Override
	public int countByBrandAndStateAndStatus(BrandName brand, BikeState state , BikeStatus status) {
		// TODO Auto-generated method stub
		return bikeRepository.countByBrandAndStateAndStatus(brand, state,status);
	}

	@Override
	public int countByStateAndSoldDate(BikeState state, String soldDate) {
		
		return bikeRepository.countByStateAndSoldDate(state, soldDate);
	}
	
	@Override
	public List<Bike> findByIdIn( List<Long> user){
		return bikeRepository.findByIdIn(user);
	}

 
	
	
	
	
}
