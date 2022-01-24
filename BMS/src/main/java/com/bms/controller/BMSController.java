package com.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.bms.entity.DAOService;


@RestController
public class BMSController {
	
	@Autowired
	private DAOService serviceObj;
	
	@GetMapping("/bms")
	public ModelAndView welcome() {		
		
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("index.html");
		 return modelAndView;
	}
	
	@GetMapping("/locations")
	public List<String> locations() {		
		
		return serviceObj.findAllLocations();
		
	}

}
