package in.conceptarchitect.web.controllers;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;


@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@RequestMapping(path = "list")
	public String list() {
		
		//return "/WEB-INF/views/movielist.jsp";  //req.getRequestDispatcher("movielist").forward(re,resp)
		
		return "movielist";
	}
	
	@RequestMapping(path="info")
	public String info(HashMap<String,Object> model) {
		
		//model will be available to view
		model.put("heading", "Movie Details"); 
		
		return "movieinfo"; //return "/WEB-INF/views/movieinfo.jsp";
	}
	
	@RequestMapping(path="count")
	@ResponseBody  //<--- what I return is the entire respnonse. not a jsp forwar
	public String count() {
		
		//Here 30 is what I want to display. Not forward a request to some jsp
		//request.getRequestDispatcher("/WEB-INF/views/30.jsp").forward(req,res)
		return "30"; 
	}
	

}
