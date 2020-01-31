package in.conceptarchitect.movies.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.conceptarchitect.movies.services.MovieApp;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		MovieApp app=context.getBean(MovieApp.class);
		
		app.addMovie();
		app.getMovies().forEach(System.out::println);
		
	}

}
