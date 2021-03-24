package com.biketrade.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
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
public class BTUserController {

	@Autowired
	private IBTUserDetailsService userService;
	
	@Autowired
	private IBTBikeDetailsService bikeService;
	

	@Autowired
	private ImageRepository imageRepository;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(required=false,name="error") String error) {
		ModelAndView modelAndView = new ModelAndView();
		if (StringUtils.isNotBlank(error) && error.equals("true")) {
			modelAndView.addObject("message", "UserName or Password is wrong");
		}
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView model(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("userregistration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByUserName(user.getUserName());
		if (userExists != null) {
			bindingResult.rejectValue("userName", "error.user",
					"There is already a user registered with the user name provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("userregistration");
		} else {
			userService.saveUser(user);

			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/myaccount", method = RequestMethod.GET)
	public ModelAndView showMyAccount(ModelAndView modelAndView) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());		
		List<Bike> bikes =bikeService.findByUser(user);
		if(bikes!=null) {
			modelAndView.addObject("bikes", bikes);
			modelAndView.addObject("user",user);
			modelAndView.setViewName("useraccount");
			return modelAndView;
		}else
			modelAndView.addObject("user",user);
			modelAndView.addObject("message", "No Bike Resistered from Your Account");
			return modelAndView;
	}
	
	@GetMapping(value = "/updatebike") 
	public ModelAndView updateform(@RequestParam long bikeid) {
		ModelAndView modelAndView = new ModelAndView();
	
		BikeForm bikeform = new BikeForm();
		List<Bike> bikes =bikeService.findById(bikeid);
		System.out.println("get"+ bikeid);
		System.out.println(bikes +"get of update");
			modelAndView.addObject("dataforupdate" ,bikes);
			modelAndView.addObject("bikeform", bikeform);
			
			modelAndView.addObject("brand_names", BrandName.values());
			modelAndView.setViewName("update_bikeregistration"); 
		return modelAndView;
	}
	@RequestMapping(value = "/updatebike", method = RequestMethod.POST) // to show the form
	public ModelAndView editBike(@Valid @ModelAttribute("bikeform") BikeForm bikeform,
			BindingResult bindingResult,@RequestParam long bikeid) throws IOException {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("post id"+bikeid);
		
		Bike savebike= bikeService.findAllById(bikeid);
		System.out.println("post bike object"+savebike);
		if (bindingResult.hasErrors()) {
		
			modelAndView.setViewName("update_bikeregistration"); 
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
