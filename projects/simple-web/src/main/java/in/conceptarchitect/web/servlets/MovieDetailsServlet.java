package in.conceptarchitect.web.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import in.conceptarchitect.movieservice.Movie;
import in.conceptarchitect.movieservice.MovieService;
import in.conceptarchitect.movieservice.repository.hibernate.MovieHibernateRepository;


//when user types /movies
public class MovieDetailsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//resp.getWriter().println("<h1>Popular Movies</h1>");
		
		//Task 1 ---> fetch the list of movies from the service
		// Step 1.1 ---> Create Repository
		MovieHibernateRepository repository=new MovieHibernateRepository();
		
		// Step 1.2 ---> Create the Service and inject the repository
		MovieService service=new MovieService(repository);
		
		// Step 1.3 ---> Find out movie id
		String imdbId=req.getParameter("imdbId");
		// Step 1.4 ---> Find movie by id
		Movie movie= service.getMovieByid(imdbId);
		
		
		
		//Task 2 ---> pass the list of movies to the JSP file to create HTML
		//Task 2.1 ---> attach the model (Movies) to request so that it can be passed to JSP
		req.setAttribute("movie", movie);
		
		
		//Task 2.2 ---> forward the request (with Movies) and response to a JSP of your choice
		req
			.getRequestDispatcher("/moviedetails.jsp")  //use this jsp file
			.forward(req, resp);                       //forward request and response
		
		
		//Task 3 ---> IN JSP File. Display the Movie Info
		// the sub steps are in JSP file
	}
	
	

}
