package com.biketrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biketrade.model.BikeStatus;
import com.biketrade.service.IBTBikeDetailsService;

@Controller
public class BTAdminController {

	@Autowired
	private IBTBikeDetailsService bikeService ;
	
	@RequestMapping(value = "/approve", method = RequestMethod.GET)
	public ModelAndView approve(ModelAndView modelAndView , @RequestParam int bid) {
		bikeService.updateBike(bid, BikeStatus.APPROVED);
		modelAndView.addObject("message", "Bike data approved with id " + bid);
		modelAndView.setViewName("adminpage");
		return modelAndView;
	}
	

	@RequestMapping(value = "/reject", method = RequestMethod.GET)
	public ModelAndView reject(ModelAndView modelAndView , @RequestParam int bid) {
		bikeService.updateBike(bid, BikeStatus.REJECTED);
		modelAndView.addObject("message", "Bike data Rejected with id " + bid);
		modelAndView.setViewName("adminpage");
		return modelAndView;
	}
}
