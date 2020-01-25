package in.conceptarchitect.movieservice;

import java.util.ArrayList;
import java.util.Collection;



public class MovieService {

	//I will not create the repository myself
	// because its not my choice where user want to save the data
	// DEPENDENCY INVERSION a.k.a DEPENCNECY ABSTRACTION
	Repository<Movie, String> movieRepository;
	

	

	public Repository<Movie, String> getMovieRepository() {
		return movieRepository;
	}

	// you have to give me the repository <---- DEPENDENCY INJECTION <--- SETTER BASED
//	public void setMovieRepository(Repository<Movie, String> movieRepository) {
//		this.movieRepository = movieRepository;
//	}

	// you have to give me the repository <---- DEPENDENCY INJECTION <--- CONSTRUCTOR BASED
	public MovieService(Repository<Movie, String> repository) {
		movieRepository=repository;
	}
	

	public boolean addMovie(Movie movie) {
		// step 1: is movie object valid?
		// is required field supplied
		// is imdb id format valid
		// TODO
		boolean valid = validate(movie);

		if (valid) {
			// TODO: step 2: if it is valid add to repository
			String id = movieRepository.add(movie);
			return id != null; // movie was added properly
		} else {
			return false;
		}
	}

	private boolean validate(Movie movie) {
		// TODO Auto-generated method stub
		if(movie==null)
			return false;
		String imdbId = movie.getImdbId();
		if (imdbId == null)
			return false;
		if (imdbId.length() < 6 || imdbId.length() > 8)
			return false;
		if (!imdbId.startsWith("tt"))
			return false;

		if (movie.getName() == null)
			return false;
		return true;
	}

	public Collection<Movie> getAllMovies() {

		return movieRepository.getAll();
	}

	public Collection<Movie> search(String text) {
		text = text.toLowerCase();
		ArrayList<Movie> result = new ArrayList<Movie>();
		// from repository
		for (Movie movie : movieRepository.getAll()) {
			if (movie.getName().toLowerCase().contains(text) 
					|| movie.getGenre().toLowerCase().contains(text)
					|| movie.getPlot().toLowerCase().contains(text))
				result.add(movie);
		}

		return result;
	}

	public void deleteMovie(String imdbId) {
		movieRepository.remove(imdbId);
	}

	public void updateMovie(String imdbId, Movie movie) {
		
		Movie oldMovie=movieRepository.getById(imdbId);
		if (oldMovie==null)
			return;
		//update doesn't allow change of imdbid or the movie name
		oldMovie.genre=movie.genre;
		oldMovie.imdbRating=movie.imdbRating;
		oldMovie.plot=movie.plot;
		oldMovie.plot=movie.poster;
		
		movieRepository.update(imdbId, oldMovie);
	}

}
