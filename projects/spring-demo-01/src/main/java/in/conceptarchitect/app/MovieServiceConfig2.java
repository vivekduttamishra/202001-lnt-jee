package in.conceptarchitect.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import in.conceptarchitect.movies.repository.flatfile.MovieStore;
import in.conceptarchitect.movieservice.Movie;
import in.conceptarchitect.movieservice.MovieService;
import in.conceptarchitect.movieservice.Repository;

@Configuration //--> another alias for @Component
@ComponentScan("in.conceptarchitect")
public class MovieServiceConfig2 {
	
	@Autowired
	Repository<Movie, String> repository;
	
	@Bean
	public MovieStore store() {
		MovieStore _store=MovieStore.load("c:/temp/movies.db");
		return _store;
	}	
	
	
	@Bean
	public MovieService movieService() {
		return new MovieService(repository);
	}
	
}

