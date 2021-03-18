package com.biketrade.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biketrade.dao.BTSolrRepository;
import com.biketrade.dao.ImageRepository;
import com.biketrade.form.BikeForm;
import com.biketrade.model.Bike;
import com.biketrade.model.BikeState;
import com.biketrade.model.BikeStatus;
import com.biketrade.model.BrandName;
import com.biketrade.model.ImageModel;
import com.biketrade.model.User;
import com.biketrade.service.IBTBikeDetailsService;
import com.biketrade.service.IBTUserDetailsService;

@Controller
public class BTBikeController {

	@Autowired
	private IBTBikeDetailsService bikeService;

	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	private IBTUserDetailsService userService;
	
	@Autowired
	private BTSolrRepository solarRepository;

	@RequestMapping(value = "/registrationbike", method = RequestMethod.GET) // to get the form
	public ModelAndView model(Model model) {
		ModelAndView modelAndView = new ModelAndView();
			BikeForm bikeform = new BikeForm();
			modelAndView.addObject("bikeform", bikeform);
			model.addAttribute("bikeform", new BikeForm());
			model.addAttribute("brand_names", BrandName.values());
			modelAndView.setViewName("bikeregistration"); 
		return modelAndView;
	}

	@RequestMapping(value = "/registrationbike", method = RequestMethod.POST) // to show the form
	public ModelAndView registerNewBike(@Valid @ModelAttribute("bikeform") BikeForm bikeform,
			BindingResult bindingResult, Model model) throws IOException {
		ModelAndView modelAndView = new ModelAndView();	
		if (bindingResult.hasErrors()) {
			model.addAttribute("brand_names", BrandName.values());
			modelAndView.setViewName("bikeregistration"); // return to bike registration (this)page
			return modelAndView;
		}
		User user =userService.getCurrentUser();
		Bike savebike = new Bike();
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

		modelAndView.addObject("successMessageB", "Your bike details has been saved successfully");
		imageRepository.saveAll(images);
		savebike.setBikeImages(images);
		bikeService.saveBike(savebike);
		modelAndView.addObject("bikeform", new BikeForm());
		model.addAttribute("bikeform", new BikeForm());
		modelAndView.setViewName("bikeregistration");
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/bike/cancel", method = RequestMethod.GET)
	public ModelAndView cancelBike(ModelAndView modelAndView, @RequestParam Long bikeid) {
		bikeService.updateBike(bikeid, BikeStatus.CANCELLED);
		solarRepository.deleteById(bikeid);
		modelAndView.addObject("message", "Successfully Cancelled Bike data with id " + bikeid);
		modelAndView.setViewName("useraccount");
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
