package com.biketrade.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biketrade.model.Bike;
import com.biketrade.model.BikeInterestedUser;
import com.biketrade.model.User;
@Transactional
public interface BTInterestedBikeRepository extends JpaRepository<BikeInterestedUser ,Integer> {
	
		 BikeInterestedUser    findByInterestedUserAndBike(User user,Bike bike);	
    List<BikeInterestedUser>   findByInterestedUser(User user);
    List<BikeInterestedUser>   findByBike(Bike bike);	


}
