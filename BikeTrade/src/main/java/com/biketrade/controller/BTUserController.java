package com.biketrade.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.hamcrest.collection.IsEmptyCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biketrade.dao.BTBikeRepository;
import com.biketrade.model.Bike;
import com.biketrade.model.BikeStatus;
import com.biketrade.model.User;
import com.biketrade.service.IBTBikeDetailsService;
import com.biketrade.service.IBTUserDetailsService;

@Controller
public class BTUserController {

	@Autowired
	private IBTUserDetailsService userService;
	
	@Autowired
	private IBTBikeDetailsService bikeService;

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
			modelAndView.setViewName("userregistration");
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
	
 
	
 
}
