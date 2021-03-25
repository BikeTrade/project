package com.biketrade.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biketrade.dao.BTInterestedBikeRepository;
import com.biketrade.form.ImageForm;
import com.biketrade.model.Bike;
import com.biketrade.model.BikeInterestedUser;
import com.biketrade.model.BikeState;
import com.biketrade.model.BikeStatus;
import com.biketrade.model.ImageModel;
import com.biketrade.model.User;
import com.biketrade.service.IBTBikeDetailsService;
import com.biketrade.service.IBTUserDetailsService;


@Controller
public class BTInterestedBikeController {
	
	@Autowired
	BTInterestedBikeRepository btInterestedBikeRepository;
	
	@Autowired
	private IBTUserDetailsService userService;
	
	
	@Autowired
	private IBTBikeDetailsService bikeDetailService;
	
	@RequestMapping(value = "/interested", method = RequestMethod.GET)
	public ModelAndView viewBike(ModelAndView modelAndView,@RequestParam Long bikeId) {	
		Bike bike=	bikeDetailService.findAllById(bikeId);
		addModelAttributes(modelAndView,bike);
 		modelAndView.setViewName("viewbikedetail");
		return modelAndView;
	}
	
	@RequestMapping(value = "/bike/interested", method = RequestMethod.POST)
	public ModelAndView interestBike(ModelAndView modelAndView,Long bikeId) {
		Bike bike=	bikeDetailService.findAllById(bikeId);
		User interestedUser = userService.getCurrentUser();
		
 
		BikeInterestedUser interestedInfo = new BikeInterestedUser();
		interestedInfo.setBike(bike);
		interestedInfo.setInterestedUser(interestedUser);
		interestedInfo.setStatus(BikeStatus.INTERESTED);
		bike.getInterestedUsers().add(interestedInfo);
		try {
			btInterestedBikeRepository.save(interestedInfo);
			bikeDetailService.saveBike(bike);
			modelAndView.addObject("successMessage", "Your Request has been sent to Seller Please Wait For Approval");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		addModelAttributes(modelAndView, bike);
		 
		modelAndView.setViewName("viewbikedetail");
		return modelAndView;
	}
	
	
	void addModelAttributes(ModelAndView modelAndView,Bike bike) {
		 Long bikeId = bike.getId();
			
			if (!BikeState.SOLD.equals(bike.getState())) {
				User interestedUser = userService.getCurrentUser();
  
				BikeInterestedUser userInterest = btInterestedBikeRepository.findByInterestedUserAndBike(interestedUser,bike);
				if (null != userInterest) {
					modelAndView.addObject("status", userInterest.getStatus());
					modelAndView.addObject("userInterest", userInterest);
				}
				modelAndView.addObject("bike", bike);

				List<ImageModel> lImages = bike.getBikeImages();
				List<ImageForm> desktopImages = new ArrayList<>();
				for (ImageModel image : lImages) {
					ImageForm i = new ImageForm();
					try {

						byte[] frontImg = Base64.encodeBase64(image.getPicByte());
						i.setSrc(new String(frontImg, "UTF-8"));
						i.setType(image.getType());
						desktopImages.add(i);

					} catch (UnsupportedEncodingException e) { // TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				modelAndView.addObject("desktopImages", desktopImages);
			} else {
				modelAndView.addObject("infoMessage", "Bike is Sold");
			}
			 
	}
	
	

}
