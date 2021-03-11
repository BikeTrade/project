package com.biketrade.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biketrade.dao.BTBikeRepository;
import com.biketrade.model.Bike;
import com.biketrade.model.BikeStatus;
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

}
