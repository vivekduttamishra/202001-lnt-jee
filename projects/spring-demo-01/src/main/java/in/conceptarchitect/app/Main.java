package in.conceptarchitect.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.conceptarchitect.movies.repository.flatfile.FlatFileMovieRepository;
import in.conceptarchitect.movies.repository.flatfile.MovieStore;
import in.conceptarchitect.movieservice.Movie;
import in.conceptarchitect.movieservice.MovieService;

public class Main {

	
	MovieService service;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		MovieService service=getMovieService();
		
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

	private static MovieService getMovieService() {
		System.out.println("creating the context...");
		ApplicationContext context=new AnnotationConfigApplicationContext(MovieServiceConfig.class);
		return context.getBean(MovieService.class);
	}

	
	private static MovieService getMovieServiceXmlConfig() {
		System.out.println("creating the context...");
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath:/movie-service-config.xml");
		return context.getBean(MovieService.class);
	}

	private static MovieService getMovieServiceTest() {
		System.out.println("creating the context...");
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath:/movie-service-config.xml");
		System.out.println("context created...");
		
		System.out.println("testing UserRepositories");
		
		requestUserRepository(context,"singletonUserRepository");
		requestUserRepository(context,"singletonUserRepository");
		requestUserRepository(context,"singletonUserRepository");
		
		requestUserRepository(context, "lazyUserRepository"); //object is created here
		requestUserRepository(context, "lazyUserRepository"); //reused here
		requestUserRepository(context, "lazyUserRepository"); //reused here
		
		requestUserRepository(context, "prototypeUserRepository"); //new object
		requestUserRepository(context, "prototypeUserRepository"); //another new object
		requestUserRepository(context, "prototypeUserRepository"); //yet anohter new object
		
		
		System.out.println("test ends...");
		
		
		System.out.println("requesting for MovieService...");
		return context.getBean(MovieService.class);
	}
	
	private static void requestUserRepository(ClassPathXmlApplicationContext context, String beanId) {
		// TODO Auto-generated method stub
		System.out.println("requesting for "+beanId);
		Object o= context.getBean(beanId);
		System.out.println("Got object "+o.hashCode());
		System.out.println("\n");
	}

	private static MovieService _getMovieService() {
		MovieStore store=MovieStore.load("c:/temp/movies.db"); //Factory Method
		FlatFileMovieRepository rep=new FlatFileMovieRepository();
		rep.setStore(store);
		return new MovieService(rep);
	}
	
	private static MovieService __getMovieService() {
		// TODO Auto-generated method stub
		System.out.println("creating context");
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath:/movie-service-config.xml");
		System.out.println("context is created");
		//Get me an object of MovieService class
		System.out.println("requesting for MovieService");
		return context.getBean(MovieService.class);
	}

}
