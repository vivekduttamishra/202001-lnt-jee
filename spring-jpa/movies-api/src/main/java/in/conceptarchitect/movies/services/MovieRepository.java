package in.conceptarchitect.movies.services;

import java.util.List;

import in.conceptarchitect.movies.entities.Movie;

public interface MovieRepository {

	void addMovie(Movie movie);
	List<Movie> getMovies();
	
}
