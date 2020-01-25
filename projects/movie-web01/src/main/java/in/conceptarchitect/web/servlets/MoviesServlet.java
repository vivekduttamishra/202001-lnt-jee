package in.conceptarchitect.web.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.conceptarchitect.movieservice.Movie;

/**
 * Servlet implementation class MoviesServlet
 */
public class MoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoviesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Movie> movies=Arrays.asList(
					new Movie("tt112233", "The Count of Monte Cristo", "Movie", "", 7.5, "The story of admon dantes", "history, fiction"),
					new Movie("tt112255", "Harry Potter 1", "Movie", "", 7.5, "The story of admon dantes", "history, fiction"),
					new Movie("tt112266", "Harry Potter 2", "Movie", "", 7.5, "The story of admon dantes", "history, fiction"),
					new Movie("tt112277", "Half Blood Prince", "Movie", "", 7.5, "The story of admon dantes", "history, fiction"),
					new Movie("tt112222", "Spiderman - Far from home", "Movie", "", 7.5, "The story of admon dantes", "history, fiction")
				);
		
		request.setAttribute("movies", movies);
		request
			.getRequestDispatcher("/WEB-INF/list.jsp")
			.forward(request, response);
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
