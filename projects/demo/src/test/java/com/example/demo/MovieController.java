package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

	@RequestMapping("/movies")
	//@ResponseBody
	public String hello() {
		return "Hello World Spring";
	}
	
	
	
}
