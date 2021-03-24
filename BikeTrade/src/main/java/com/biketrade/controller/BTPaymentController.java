package com.biketrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biketrade.model.Payment;
import com.biketrade.service.BTPaymentService;

@Controller
public class BTPaymentController {

	@Autowired
	BTPaymentService payService;

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public ModelAndView payment(ModelAndView mv, @RequestParam("paymentmode") String mode) {

		if (mode.equals("1")) {
		
			mv.addObject("payment", new Payment());
			mv.setViewName("debitcard");
			
		} else if(mode.equals("2")) {
			mv.addObject("payment", new Payment());
			mv.setViewName("netbanking");
		} else {
			mv.addObject("payment", new Payment());
			mv.setViewName("upi");
		}

		return mv;
	}

	@RequestMapping(value = "/netbank", method = RequestMethod.POST)
	public ModelAndView netbank(Payment payment, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		if (bindingResult.hasErrors());
		{
			mv.setViewName("netbanking");
		}
		payService.savePayment(payment);
		mv.addObject("transaction",payment.getId());
		mv.addObject("amount",payment.getAmount());
		mv.addObject("payeeName",payment.getPayeeName());
		mv.addObject("paymode",payment.getMode());
		mv.addObject("paid", "Transaction Succesfull");
		mv.addObject("payment", new Payment());
		mv.setViewName("receipt");
		return mv;
	}

	@RequestMapping(value = "/debit", method = RequestMethod.POST)
	public ModelAndView cardPay(Payment payment, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
	
		if (bindingResult.hasErrors());
		{
			mv.setViewName("debitcard");
		}
		payService.savePayment(payment);
		mv.addObject("transaction",payment.getId());
		mv.addObject("amount",payment.getAmount());
		mv.addObject("payeeName",payment.getPayeeName());
		mv.addObject("paymode",payment.getMode());
		mv.addObject("paid", "Transaction Succesfull");
		mv.addObject("payment", new Payment());
		mv.setViewName("receipt");
		return mv;
	}
	@RequestMapping(value = "/upi", method = RequestMethod.POST)
	public ModelAndView upiPay(Payment payment, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		if (bindingResult.hasErrors());
		{
			mv.setViewName("debitcard");
	}
		payService.savePayment(payment);
		mv.addObject("transaction",payment.getId());
		mv.addObject("amount",payment.getAmount());
		mv.addObject("payeeName",payment.getPayeeName());
		mv.addObject("paymode",payment.getMode());
		mv.addObject("paid", "Transaction Succesfull");
		mv.addObject("payment", new Payment());
		mv.setViewName("receipt");
		return mv;
	}
	
	
}
