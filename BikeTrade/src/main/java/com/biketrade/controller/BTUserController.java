package com.biketrade.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biketrade.dao.BTInterestedBikeRepository;
import com.biketrade.model.User;
import com.biketrade.service.IBTUserDetailsService;

@Controller
public class BTUserController {

	@Autowired
	private IBTUserDetailsService userService;
	
	@Autowired
	BTInterestedBikeRepository btInterestedBikeRepository;

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
