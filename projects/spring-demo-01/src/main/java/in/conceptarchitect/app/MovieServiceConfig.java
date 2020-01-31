package in.conceptarchitect.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import in.conceptarchitect.movies.repository.flatfile.MovieStore;

@Configuration //--> another alias for @Component
@ComponentScan("in.conceptarchitect")

public class MovieServiceConfig {
	
	
	@Bean
	public MovieStore store() {
		MovieStore _store=MovieStore.load("c:/temp/movies.db");
		return _store;
	}	
	
	
}

