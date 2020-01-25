package in.conceptarchitect.moviesservice;

import static org.junit.Assert.*;


import java.io.File;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import in.conceptarchitect.movies.repository.flatfile.FlatFileMovieRepository;
import in.conceptarchitect.movies.repository.flatfile.MovieStore;
import in.conceptarchitect.movieservice.Movie;
import in.conceptarchitect.movieservice.MovieService;

public class MovieServiceTests {

	MovieService service;
	FlatFileMovieRepository rep;
	String validId="tt12345";
	String invalidId1="tt12345678";
	String invalidId2="xy12345";
	String invalidId3="tt1";
	String repositoryPath="c:/temp/movie-repository-test-file.dat";
	File repositoryFile;
	int initMovieCount=0;
	MovieStore store;
	
	@Before
	public void setUp() throws Exception {
		
		repositoryFile=new File(repositoryPath);
		if(repositoryFile.exists())
			repositoryFile.delete();
		
		// you need to create repository first
		rep= new FlatFileMovieRepository(); //internally needs a store
		// you need to have a store first
			store=MovieStore.load(repositoryPath);
		
			
		rep.setStore(store);  //<--- required dependency but will not give compile time errro
		
		

		
		service=new MovieService(rep); //now service object is not null
		//service depends on repository and repository is not provided
		
		
		
	}

	void assertCanNotAddMovie(Movie movie, String reason) {
		boolean result= service.addMovie(movie);
		
		assertFalse(reason,result);
		//we need to do more assertions later
		assertEquals(initMovieCount, rep.getStore().getMovieCount());
		
	}
	
	@Test
	public void cantAddNullMovie() {
		
		//assertFalse(result);
		// is it sufficient?
		assertCanNotAddMovie(null, "Null Movie cant be added");
		
	}
	
	@Test
	public void cantAddMovieWithoutName() {
		Movie movie=new Movie();
		movie.setImdbId(validId);
//		boolean result=service.addMovie(movie);
//		assertFalse(result);
		assertCanNotAddMovie(movie, "Cant Add movie with No Name");
	}
	
	 @Test
	public void cantAddMovieWithoutImdbId() {
		Movie movie=new Movie();
		movie.setImdbId(null);
		movie.setName("Some Title");
		assertCanNotAddMovie(movie, "Cant Add movie without valid imdbId");
	}
	
	@Test
	public void cantAddMovieWithInvalidImdbId() {
		String [] invalidIds= {invalidId1,invalidId2,invalidId3};
		String [] reasons= {"Id is too long","Id doesnt start with tt","id is too short"};
		
		for(int i=0;i<invalidIds.length;i++) {
			Movie movie=new Movie(invalidIds[i], "Some Name", null, null, 9, null, null);
			assertCanNotAddMovie(movie, reasons[i]);
		}
	}
	
	@Ignore @Test
	public void cantAddMovieWithDuplicateImdbId() {
		fail("Not yet implemented");
	}
	
	@Ignore @Test
	public void canAddMovieValidMovieWithUnqiueImdbId() {
		fail("Not yet implemented");
	}
	
	@Ignore @Test
	public void getAllReturnsAllMovies() {
		fail("Not yet implemented");
	}

	@Ignore @Test
	public void searchCanSearchTextInPlot() {
		fail("Not yet implemented");
	}
	
	@Ignore @Test
	public void updateFailsIfImdbIdDoesNotMatch() {
		fail("Not yet implemented");
	}
	
	@Ignore @Test
	public void cantUpdateMovieName() {
		fail("Not yet implemented");
	}
	
	@Ignore @Test
	public void cantUpdateImdbId() {
		fail("Not yet implemented");
	}




	
}
