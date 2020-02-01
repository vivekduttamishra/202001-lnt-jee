package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

	@GetMapping("movies")
	public List<Movie> list() {
		return Arrays.asList(
					new Movie("tt1234", "Superman Returns", 8.9),
					new Movie("tt1235", "Gandhi", 9),
					new Movie("tt1235", "Spiderman Homecoming", 8.9)
				);
				
	}
	
}
