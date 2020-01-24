package in.conceptarchitect.movies.repository.flatfile;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlatFileMovieRepositoryTests {

	@Test
	public void canLoadNonExistantRepository() {
		String path="c:/temp/store-that-doesnot-exist.db";
		FlatFileMovieRepository rep=FlatFileMovieRepository.load(path);
		assertNotNull(rep);
			
	}
	
	@Test
	public void aRepositoryStoreKnowsTheLoadPath() {
		String path="c:/temp/store-that-doesnot-exist.db";
		FlatFileMovieRepository rep=FlatFileMovieRepository.load(path);
		assertEquals(path, rep.store.path);
	}
	
	@Test
	public void canSaveAnEmptyRepository() {
		fail("Not yet implemented!");
	}
	
	@Test
	public void saveCreatesTheRepositoryOnGivenPath() {
		fail("Not yet implemented!");
	}
	
	@Test
	public void movieAddFailsForMovieWithNoImdbId() {
		fail("Not yet implemented!");
	}
	
	@Test
	public void movieAddFailsForDuplicateImdbId() {
		fail("Not yet implemented!");
	}
	
	@Test
	public void canAddMovieWithUniqueImdbId() {
		fail("Not yet implemented!");
	}
	
	@Test
	public void getByIdReturnsMovieObjectForValidImdbId() {
		fail("Not yet implemented!");
	}
	
	@Test
	public void getByIdReturnsNullForInvalidImdbId() {
		fail("Not yet implemented!");
	}
	
	@Test
	public void canSaveNonEmptyRepository() {
		fail("Not yet implemented!");
	}
	
	@Test
	public void getAllReturnsAllMovies() {
		fail("Not yet implemented!");
	}
	
	@Test
	public void removeRemovesTheMovieWithValidImdbId() {
		fail("Not yet implemented!");
	}
	
	
	
	
	
	
	
	
	
	
	
}
