package com.biketrade.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biketrade.model.Bike;
import com.biketrade.model.BikeStatus;


@Repository
public class BTStatusDao {
	@Autowired // byType
	// OR JPA specific anno : @PersistenceContext
	private EntityManager mgr;
	
	public List<Bike> findByBikeStatus() {
		
		String Jpql = "select b from Bike b where b.status=:st";
		
		
		return mgr.createQuery(Jpql,Bike.class).setParameter("st", BikeStatus.NOTAPPROVED).getResultList();
	}
}
