package com.biketrade.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biketrade.model.Payment;
import com.biketrade.model.PaymentFailure;

@Repository
public interface BTPaymentFailureRepository extends JpaRepository<PaymentFailure ,Integer> {
	
}
