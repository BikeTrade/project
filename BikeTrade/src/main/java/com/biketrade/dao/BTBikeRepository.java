package com.biketrade.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biketrade.model.Bike;
import com.biketrade.model.BikeStatus;
import com.biketrade.model.User;

@Repository
public interface BTBikeRepository  extends JpaRepository<Bike, Integer>{
	
	@Modifying
	@Query("update Bike b set b.status = :status where b.id = :bid")
	public int updateBike(@Param(value = "bid") Long bid, @Param(value = "status") BikeStatus status);
	
	public List<Bike> findByStatus(BikeStatus status);
	
	public List<Bike> findByUser(User user);
}
