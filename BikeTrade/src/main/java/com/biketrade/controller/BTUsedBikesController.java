package com.biketrade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BTUsedBikesController {
	
	@RequestMapping(value = {"/used/bikes"}, method = RequestMethod.GET)
	public ModelAndView provideUsedBikes(Model model) {
		ModelAndView view = new ModelAndView();
		view.setViewName("usedbikes");
		return view; 
	}
}
