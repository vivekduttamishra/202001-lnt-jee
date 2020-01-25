package in.conceptarchitect.movies.repository.flatfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import in.conceptarchitect.movieservice.Movie;



public class FlatFileMovieRepositoryTests {
	
	String path="c:/temp/repository-test-file.db";
	File file;
	FlatFileMovieRepository rep;
	int initMovieCount=0;
	String existingId="tt000001";
	String uniqueId="tt999999";
	MovieStore store;
	
	@Before  //every test run this function
	public void initTests() {
		file=new File(path);
		if(file.exists())
			file.delete();
		//rep=FlatFileMovieRepository.load(path);
		store=MovieStore.load(path);
		rep=new FlatFileMovieRepository();
		rep.setStore(store);
				
		
		
		
		//now I am sure the file doesn't exist when test runs
	}
	
	void addDummyMovies() {
		rep.add(new Movie(existingId,"Existing Movie",null,null,8,null,null));
		initMovieCount= rep.store.movies.size();		
	}
	

	@Test
	public void canLoadNonExistantRepository() {
		assertNotNull(rep);
			
	}
	
	@Test
	public void aRepositoryStoreKnowsTheLoadPath() {
		assertEquals(path, rep.store.path);
	}
	
	@Test
	public void canSaveAnEmptyRepository() {
		rep.save();
	}
	
	@Test
	public void saveCreatesTheRepositoryOnGivenPath() {
		rep.save();
		assertTrue(file.exists());
	}
	
	 @Test
	public void movieAddFailsForMovieWithNoImdbId() {
		Movie movie=new Movie(); //no information present
		movie.setName("Movie without ImdbId");
		rep.add(movie);
		assertEquals(initMovieCount, rep.store.movies.size());
	}
	
	@Test
	public void movieAddFailsForDuplicateImdbId() {
		addDummyMovies();
		String result=rep.add(new Movie(existingId, "New Movie with existing Id", null, null, 8, null, null));
		assertNull(result);
		
		assertEquals(initMovieCount, rep.store.movies.size());
		
	}
	
	@Test
	public void canAddMovieWithUniqueImdbId() {
		
		addDummyMovies();
		
		Movie movie=new Movie(); //no information present
		movie.setName("Movie without ImdbId");
		movie.setImdbId(uniqueId);
		String result=rep.add(movie);
		assertEquals(uniqueId,result);
		assertEquals(initMovieCount+1, rep.store.movies.size());
	}
	
	@Ignore @Test
	public void getByIdReturnsMovieObjectForValidImdbId() {
		fail("Not yet implemented!");
	}
	
	@Ignore @Test
	public void getByIdReturnsNullForInvalidImdbId() {
		fail("Not yet implemented!");
	}
	
	@Ignore @Test
	public void canSaveNonEmptyRepository() {
		fail("Not yet implemented!");
	}
	
	@Ignore @Test
	public void getAllReturnsAllMovies() {
		fail("Not yet implemented!");
	}
	
	@Ignore @Test
	public void removeRemovesTheMovieWithValidImdbId() {
		fail("Not yet implemented!");
	}
	
	
	
	
	
	
	
	
	
	
	
}
