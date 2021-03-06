package com.biketrade.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biketrade.model.Bike;
import com.biketrade.model.BikeStatus;

@Repository
public interface BTBikeRepository  extends JpaRepository<Bike, Integer>{
	
	@Modifying
	@Query("update Bike b set b.status = :status where b.id = :bid")
	public int updateBike(@Param(value = "bid") int bid, @Param(value = "status") BikeStatus status);
	
}
