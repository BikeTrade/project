package com.biketrade.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biketrade.model.Bike;
import com.biketrade.model.BikeState;
import com.biketrade.model.BikeStatus;
import com.biketrade.model.BrandName;
import com.biketrade.model.User;

@Repository
public interface BTBikeRepository extends JpaRepository<Bike, Integer>{
	
	@Modifying
	@Query("update Bike b set b.status = :status where b.id = :bid")
	public int updateBike(@Param(value = "bid") Long bid, @Param(value = "status") BikeStatus status);
	
	public List<Bike> findByStatus(BikeStatus status);
	
	public List<Bike> findByUser(User user);
	

	//to show on useraccount
	public List<Bike> findById(long bikeid);
	
	//to edit/update bikedetails
	public Bike findAllById(long bikeid);
	
	//get all count
	public long count();
	
	
	public int countByStatus(BikeStatus status);
	
	public int countByState(BikeState state);
	
	public int countByBrandAndStateAndStatus(BrandName brand,BikeState state,BikeStatus status);
	
	
	@Query("select count(*) from Bike b where monthname(b.soldDate)=:soldDate and b.state= :state")
	public int countByStateAndSoldDate(@Param(value = "state") BikeState state,@Param(value = "soldDate") String soldDate);
}
