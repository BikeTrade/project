package com.biketrade.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biketrade.dao.BTBikeRepository;
import com.biketrade.dao.BTStatusDao;
import com.biketrade.model.Bike;
import com.biketrade.model.BikeStatus;

@Service
@Transactional
public class BTBikeDetailsServiceImpl implements IBTBikeDetailsService{

	@Autowired
	public BTBikeRepository bikeRepository;
	
	@Autowired
	public BTStatusDao statusdao;
	
	
	
	@Override
	public Bike saveBike(Bike bike )  {     
		return bikeRepository.saveAndFlush(bike);
	}


	@Override
	public List<Bike> findByBikeStatus() {
		// TODO Auto-generated method stub
		return statusdao.findByBikeStatus();
		}


	@Override
	public int updateBike(int bid, BikeStatus status) {
		
		return bikeRepository.updateBike(bid, status);
	}


	




	


	





	



	
	
}
