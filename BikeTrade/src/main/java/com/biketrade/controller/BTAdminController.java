package com.biketrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biketrade.model.Bike;
import com.biketrade.model.BikeState;
import com.biketrade.model.BikeStatus;
import com.biketrade.service.IBTBikeDetailsService;

@Controller
public class BTAdminController {

	@Autowired
	private IBTBikeDetailsService bikeService;
	
	@RequestMapping(value = "/admin/show", method = RequestMethod.GET)
	public ModelAndView viewAdmin(ModelAndView modelAndView) {		
		List<Bike> lists = bikeService.findByStatus(BikeStatus.NOTAPPROVED);
		// boolean ans = lists.isEmpty();
			if(lists.isEmpty() == true) {
				modelAndView.addObject("message", "Every Bike is Approved" );		
			}else {
				modelAndView.addObject("NA_list", lists );
				modelAndView.setViewName("adminpage");	
			}
			modelAndView.setViewName("adminpage");	
		return modelAndView;
	}

	@RequestMapping(value = "/approve", method = RequestMethod.GET)
	public ModelAndView approve(ModelAndView modelAndView, @RequestParam Long bid) {
		bikeService.updateBike(bid, BikeStatus.APPROVED);
		showBikeDetails(modelAndView);
		modelAndView.addObject("message", "Bike data approved with id " + bid);
		modelAndView.setViewName("adminpage");
		return modelAndView;
	}

	@RequestMapping(value = "/reject", method = RequestMethod.GET)
	public ModelAndView reject(ModelAndView modelAndView, @RequestParam Long bid) {
		bikeService.updateBike(bid, BikeStatus.REJECTED);
		showBikeDetails(modelAndView);
		modelAndView.addObject("message", "Bike data Rejected with id " + bid);
		modelAndView.setViewName("adminpage");
		return modelAndView;
	}
	
	
	private void showBikeDetails(ModelAndView modelAndView) {
		List<Bike> lists = bikeService.findByStatus(BikeStatus.NOTAPPROVED);
		if (lists != null) {
			modelAndView.addObject("NA_list", lists);
		} else {
			modelAndView.addObject("message", "Every Bike is Approved");
		}
	}
	
	@RequestMapping(value = "/getcount", method = RequestMethod.GET)
	public ModelAndView summary(ModelAndView modelAndView ) {
		
		modelAndView.addObject("totalcount" , bikeService.count());
	modelAndView.addObject("aprovedcount" ,bikeService.countByStatus(BikeStatus.APPROVED));
	modelAndView.addObject("notaprovedcount" ,bikeService.countByStatus(BikeStatus.NOTAPPROVED));
		modelAndView.addObject("rejectedcount" ,bikeService.countByStatus(BikeStatus.REJECTED));
		modelAndView.addObject("cancelledcount" ,bikeService.countByStatus(BikeStatus.CANCELLED));
		modelAndView.addObject("soldcount" ,bikeService.countByState(BikeState.SOLD));
		modelAndView.addObject("unsoldcount" ,bikeService.countByState(BikeState.UNSOLD));
		modelAndView.setViewName("AdminDashboard");
		
		
		return modelAndView;
	}
	
	
	
}
