package in.conceptarchitect.movies.services;

import java.util.List;

import in.conceptarchitect.movies.entities.Movie;
import in.conceptarchitect.utils.Input;

public class MovieApp {

	MovieRepository movieRepository;
	
	
	public MovieApp(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}


	public void addMovie() {
		String dontAdd="EXIT WITHOUT ADDING A MOVIE";
		String title=Input.readString("Title",dontAdd);
		if(title.contentEquals(dontAdd))
			return;
		Movie movie=new Movie(Input.readString("imdbId"), title, Input.readInt("imdbRating"), Input.readString("details"));
		movieRepository.addMovie(movie);
	}
	
	
	public List<Movie> getMovies() {
		return movieRepository.getMovies();
	}
	
	
}
