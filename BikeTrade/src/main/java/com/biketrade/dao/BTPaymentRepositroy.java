package com.biketrade.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biketrade.model.Payment;
import com.biketrade.model.User;

@Repository
public interface BTPaymentRepositroy  extends JpaRepository<Payment ,Integer>{

	List<Payment> findByBuyer(User buyer);
	
}
