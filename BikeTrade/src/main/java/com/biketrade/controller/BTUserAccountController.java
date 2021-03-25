package com.biketrade.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biketrade.dao.BTInterestedBikeRepository;
import com.biketrade.dao.ImageRepository;
import com.biketrade.form.BikeForm;
import com.biketrade.form.InterestedUsersInBikeForm;
import com.biketrade.model.Bike;
import com.biketrade.model.BikeInterestedUser;
import com.biketrade.model.BikeState;
import com.biketrade.model.BikeStatus;
import com.biketrade.model.BrandName;
import com.biketrade.model.ImageModel;
import com.biketrade.model.User;
import com.biketrade.service.IBTBikeDetailsService;
import com.biketrade.service.IBTUserDetailsService;

@Controller
public class BTUserAccountController {

	@Autowired
	private IBTUserDetailsService userService;
	
	@Autowired
	private IBTBikeDetailsService bikeService;
	
	@Autowired
	BTInterestedBikeRepository btInterestedBikeRepository;
	

	@Autowired
	private ImageRepository imageRepository;
	
	@RequestMapping(value = "/myaccount", method = RequestMethod.GET)
	public ModelAndView showMyAccount(ModelAndView modelAndView) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());		
		modelAndView.addObject("user",user);
		modelAndView.setViewName("useraccount");
		return modelAndView;
	}
	
	@RequestMapping(value = "/mybikedetails", method = RequestMethod.GET)
	public ModelAndView myBikeDetails(ModelAndView modelAndView) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());		
		List<Bike> bikes =bikeService.findByUser(user);
		if(bikes!=null) {
			modelAndView.addObject("bikes", bikes);
			modelAndView.setViewName("userbikeregistrationdetails");
			return modelAndView;
		}else
			modelAndView.addObject("message", "No Bike Resistered from Your Account");
		return modelAndView;
	}
	
	@RequestMapping(value = "/requestformybike", method = RequestMethod.GET)
	public ModelAndView requestForBike(ModelAndView modelAndView) {
		 

		addReqestForMyBike(modelAndView);
		return modelAndView;
	}
	
	private void addReqestForMyBike(ModelAndView modelAndView) {
		User user = userService.getCurrentUser();
		List<Bike> bikes = bikeService.findByUser(user);
		if (bikes != null) {
			modelAndView.addObject("bikes", bikes);
					
		} else
			modelAndView.addObject("message", "No Pending Request for your Bike");
		
		modelAndView.setViewName("requestformybike");	
	}
	
	@RequestMapping(value="/interestRequest", method=RequestMethod.GET)
	public ModelAndView getInterest(ModelAndView modelAndView,@RequestParam Long bikeid, @RequestParam int userid ) {		
		Bike bike =bikeService.findAllById(bikeid);		
		List<BikeInterestedUser>  interestedBikes=	btInterestedBikeRepository.findByBike(bike);
		interestedBikes.forEach(iBike -> {
			if (iBike.getInterestedUser().getId() == userid) {
				iBike.setStatus(BikeStatus.APPROVED);
			} else {
				iBike.setStatus(BikeStatus.REJECTED);
			}
			btInterestedBikeRepository.save(iBike);
		});
		addReqestForMyBike(modelAndView);
		return modelAndView;	
	}
	
	@RequestMapping(value = "/mywishlist", method = RequestMethod.GET)
	public ModelAndView myWishList(ModelAndView modelAndView ) {
		List<BikeInterestedUser> interestedBikeReferences = btInterestedBikeRepository.findByInterestedUser(userService.getCurrentUser());
		modelAndView.addObject("interestedBikes", interestedBikeReferences);
		modelAndView.setViewName("mywishlist");
		return modelAndView;
	}
	
	@RequestMapping(value = "/orderhistory", method = RequestMethod.GET)
	public ModelAndView model(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("orderhistory");
		return modelAndView;
	}
	
	@GetMapping(value = "/updatebike") // to get the form
	public ModelAndView updateform(@RequestParam long bikeid) {
		ModelAndView modelAndView = new ModelAndView();
	
		BikeForm bikeform = new BikeForm();
		List<Bike> bikes =bikeService.findById(bikeid);
			modelAndView.addObject("dataforupdate" ,bikes);
			modelAndView.addObject("bikeform", bikeform);
			
			modelAndView.addObject("brand_names", BrandName.values());
			modelAndView.setViewName("update_bikeregistration"); 
		return modelAndView;
	}
	
	@RequestMapping(value = "/updatebike", method = RequestMethod.POST) // to show the form
	public ModelAndView registerNewBike(@Valid @ModelAttribute("bikeform") BikeForm bikeform,
			BindingResult bindingResult,@RequestParam long bikeid) throws IOException {
		ModelAndView modelAndView = new ModelAndView();
		Bike savebike= bikeService.findAllById(bikeid);
		if (bindingResult.hasErrors()) {
			//model.addAttribute("brand_names", BrandName.values());
			modelAndView.setViewName("bikeregistration"); // return to bike registration (this)page
			return modelAndView;
		}
		
		User user =userService.getCurrentUser();
	
		savebike.setBrand(bikeform.getBrand());
		savebike.setAddress(bikeform.getAddress());
		savebike.setbLocation(bikeform.getbLocation());
		savebike.setContactName(bikeform.getContactName());
		savebike.setContactNo(bikeform.getContactNo());
		savebike.setiExpDate(bikeform.getiExpDate());
		savebike.setModelName(bikeform.getModelName());
		savebike.setNoOfOwner(bikeform.getNoOfOwner());
		savebike.setPrice(bikeform.getPrice());
		savebike.setRegDate(bikeform.getRegDate());
		savebike.setRunning(bikeform.getRunning());
		savebike.setInsurance(true);
		savebike.setStatus(BikeStatus.NOTAPPROVED);
		savebike.setState(BikeState.UNSOLD);
		savebike.setUser(user);
		
		ImageModel leftImage = new ImageModel(bikeform.getLeftImage().getName(),
				bikeform.getLeftImage().getContentType(), bikeform.getLeftImage().getBytes(), savebike);
		ImageModel rightImage = new ImageModel(bikeform.getRightImage().getName(),
				bikeform.getRightImage().getContentType(), bikeform.getRightImage().getBytes(), savebike);
		ImageModel frontImage = new ImageModel(bikeform.getFrontImage().getName(),
				bikeform.getFrontImage().getContentType(), bikeform.getFrontImage().getBytes(), savebike);
		ImageModel backImage = new ImageModel(bikeform.getBackImage().getName(),
				bikeform.getBackImage().getContentType(), bikeform.getBackImage().getBytes(), savebike);

		List<ImageModel> images = new ArrayList<>();
		images.add(leftImage);
		images.add(rightImage);
		images.add(frontImage);
		images.add(backImage);
		bikeService.saveBike(savebike);

		modelAndView.addObject("successMessageB", "Your bike details has been updated successfully");
		imageRepository.saveAll(images);
		savebike.setBikeImages(images);
		bikeService.saveBike(savebike);
		modelAndView.addObject("bikeform", new BikeForm());
		
		modelAndView.setViewName("update_bikeregistration");
		return modelAndView;
		
	}
	
	@ModelAttribute("cities")
	public List<String> selectCity(){
		List<String> cities = new ArrayList<String>();
		cities.add("Mumbai");
		cities.add("Pune");
		cities.add("Satara");
		cities.add("Bangalore");
		cities.add("Dehli");
		cities.add("Chennai");
		cities.add("Ahmadabad");
		cities.add("Chandigarh");
		cities.add("Patana");
		return cities;
	}
 
}
