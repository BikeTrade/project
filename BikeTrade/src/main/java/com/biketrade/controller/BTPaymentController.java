package com.biketrade.controller;

import java.util.Date;

import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biketrade.dao.BTAddressRepository;
import com.biketrade.dao.BTPaymentFailureRepository;
import com.biketrade.dao.BTSolrRepository;
import com.biketrade.form.PaymentAuth;
import com.biketrade.form.PaymentForm;
import com.biketrade.model.Address;
import com.biketrade.model.Bike;
import com.biketrade.model.BikeState;
import com.biketrade.model.BikeStatus;
import com.biketrade.model.Payment;
import com.biketrade.model.PaymentFailure;
import com.biketrade.model.PaymentMode;
import com.biketrade.model.User;
import com.biketrade.service.BTPaymentService;
import com.biketrade.service.IBTBikeDetailsService;
import com.biketrade.service.IBTUserDetailsService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

@Controller
public class BTPaymentController {

	private String keyId = "rzp_test_DcEDnr3raOg6jQ";

	private String secretKey = "3RtbtKtFclJeGlmGZiqwv2nD";

	@Autowired
	BTPaymentService payService;

	@Autowired
	IBTBikeDetailsService ibTBikeDetailsService;

	@Autowired
	private IBTUserDetailsService userService;

	@Autowired
	private BTAddressRepository addressService;
	
	@Autowired
	private BTPaymentFailureRepository paymentFailure;
	
	@Autowired
	BTSolrRepository btSolrRepository;

	@RequestMapping(value = "/paymentmode", method = RequestMethod.GET)
	public ModelAndView selectPayMode(ModelAndView modelAndView, @RequestParam Long bikeid,
			@RequestParam Integer receiptId) {
		Bike bike = ibTBikeDetailsService.findAllById(bikeid);
		try {
			RazorpayClient client = new RazorpayClient(this.keyId, this.secretKey);
			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount", bike.getPrice() * 100); // amount in the smallest currency unit
			orderRequest.put("currency", "INR");
			orderRequest.put("receipt", "receipt_" + receiptId);

			Order order = client.Orders.create(orderRequest);

			modelAndView.addObject("price", bike.getPrice() * 100);
			modelAndView.addObject("orderId", order.get("id"));
			modelAndView.addObject("secretKey", this.keyId);
			modelAndView.addObject("bike", bike);
			modelAndView.addObject("user", userService.getCurrentUser());
			modelAndView.addObject("receipt", "receipt_" + receiptId);
		} catch (RazorpayException e) {
			System.out.println(e.getMessage());
		}

		modelAndView.setViewName("paymentmodeselection");
		modelAndView.addObject("bikeid", bikeid);
		return modelAndView;
	}

	@RequestMapping(value = "/payment/success", method = RequestMethod.POST)
	public ModelAndView payment(ModelAndView mv, PaymentAuth auth) {

		try {
			JSONObject options = new JSONObject();
			options.put("razorpay_payment_id", auth.getRazorpay_payment_id());
			options.put("razorpay_order_id", auth.getRazorpay_order_id());
			options.put("razorpay_signature", auth.getRazorpay_signature());
			boolean isEqual = Utils.verifyPaymentSignature(options, this.secretKey);
			if (isEqual) {
				System.out.println("paymentAuthentication successfull");
				copyPaymentForm(auth, mv);
			}else {
				mv.setViewName("paymenterror");
			}

		} catch (RazorpayException e) {
			mv.setViewName("paymenterror");
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(value = "/payment/failure", method = RequestMethod.POST)
	public ModelAndView paymentFailure(ModelAndView mv, PaymentFailure failure) {		 
			paymentFailure.save(failure);
			mv.setViewName("paymenterror");
		return mv;
	}

	void copyPaymentForm(PaymentAuth paymentForm, ModelAndView mv) {
		Bike bike = ibTBikeDetailsService.findAllById(paymentForm.getBikeId());
		User buyer = userService.getCurrentUser();
		Address address = new Address();
		Payment payment = new Payment();

		BeanUtils.copyProperties(paymentForm, payment);
		BeanUtils.copyProperties(paymentForm, address);
		addressService.save(address);
		payment.setAddress(address);
		payment.setBuyer(buyer);
		payment.setBike(bike);
		payment.setAmount(bike.getPrice());
		payment.setPayeeName(buyer.getName() + " " + buyer.getLastName());
		payment.setMode(PaymentMode.RAZORPAY);
		payment.setPurchaseDate(new Date());
		
		payService.savePayment(payment);
		bike.setSoldDate(new Date());
		bike.setState(BikeState.SOLD);
		bike.setStatus(BikeStatus.SOLD);
		ibTBikeDetailsService.saveBike(bike);
		mv.addObject("paid", "Transaction Succesfull");
		mv.addObject("payment", payment);
		mv.setViewName("receipt");

	}

}


