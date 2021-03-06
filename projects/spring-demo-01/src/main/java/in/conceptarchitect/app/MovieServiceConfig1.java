package in.conceptarchitect.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.conceptarchitect.movies.repository.flatfile.FlatFileMovieRepository;
import in.conceptarchitect.movies.repository.flatfile.MovieStore;
import in.conceptarchitect.movieservice.Movie;
import in.conceptarchitect.movieservice.MovieService;
import in.conceptarchitect.movieservice.Repository;

@Configuration //--> another alias for @Component
public class MovieServiceConfig1 {
	
	@Bean
	public MovieStore store() {
		MovieStore _store=MovieStore.load("c:/temp/movies.db");
		return _store;
	}	
	@Bean
	public Repository<Movie,String> repository(MovieStore store) {
		FlatFileMovieRepository rep=new FlatFileMovieRepository();
		rep.setStore(store); 
		return rep;
	}
	
	@Bean
	public MovieService movieService(Repository<Movie,String> repository) {
		return new MovieService(repository);
	}
	
}

