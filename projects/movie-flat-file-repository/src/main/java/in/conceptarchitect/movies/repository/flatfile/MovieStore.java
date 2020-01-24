package in.conceptarchitect.movies.repository.flatfile;

import java.util.HashMap;

//import in.conceptarchitect.movieservice.Movie;

public class MovieStore {

	HashMap<String, Movie> movies;
	String path;
	
	public void add(Movie movie) {
		movies.put(movie.getImdbId().toLowerCase(), movie);
	}
}
