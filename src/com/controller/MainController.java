package com.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.beans.*;
import com.service.MainServiceImpl;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	private MainServiceImpl service;
	
	@RequestMapping("/search")
	protected ModelAndView search() {
		ModelAndView model = new ModelAndView("search");

		return model;
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	protected ModelAndView result(@Valid@ModelAttribute("IP") IPv4 IP) {
		
		ModelAndView model = new ModelAndView("result");
		Location location = service.getLocationByIPAddress(IP);
		if(service.locationEmpty(location)) {
			String info = "The IPv4 range you entered is not in our database.";
			model = new ModelAndView("search");
			model.addObject("info", info);
			return model;
		}
		
		model.addObject("city", location.getCity());
		model.addObject("country", location.getCountry());
		
		return model;
	}
}
