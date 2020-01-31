package in.conceptarchitect.movieservice.repository.hibernate;

import in.conceptarchitect.movieservice.Movie;
import in.conceptarchitect.movieservice.MovieService;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieHibernateRepository rep=new MovieHibernateRepository();
		MovieService service=new MovieService(rep);
		
		addMovie(service);
		listAllMovies(service);
		

	}
	
	private static void listAllMovies(MovieService service) {
		// TODO Auto-generated method stub
		for(Movie movie : service.getAllMovies())
			System.out.println(movie.getImdbId()+"\t\t"+movie.getName());
		
		System.out.println();
	}

	private static void addMovie(MovieService service) {
		// TODO Auto-generated method stub
		
		String name=Input.readString("Movie Name?");
		if(name==null|| name.isEmpty())
			return;
		Movie movie=new Movie();
		movie.setName(name);
		movie.setImdbId(Input.readString("imdbId"));
		movie.setType("Movie");
		movie.setImdbRating(8);
				
		if(service.addMovie(movie))
			System.out.println("Movie Added");
		else
			System.out.println("Movie Add Failed");
				
		System.out.println();
	}


}
