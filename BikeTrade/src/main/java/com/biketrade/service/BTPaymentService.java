package com.biketrade.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biketrade.dao.BTPaymentRepositroy;
import com.biketrade.model.Payment;

@Service
@Transactional
public class BTPaymentService {

	@Autowired
	BTPaymentRepositroy  payrepo;
	
	public Payment savePayment (Payment payment) {
		return payrepo.save(payment);
	}
}
