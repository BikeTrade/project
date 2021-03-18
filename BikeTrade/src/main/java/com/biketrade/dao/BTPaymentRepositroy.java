package com.biketrade.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biketrade.model.Payment;

@Repository
public interface BTPaymentRepositroy  extends JpaRepository<Payment ,Integer>{

	
	
}
