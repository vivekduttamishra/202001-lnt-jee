package in.conceptarchitect.movies.repository.flatfile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import in.conceptarchitect.movieservice.Movie;

//import in.conceptarchitect.movieservice.Movie;

@Component
public class MovieStore implements Serializable{

	HashMap<String, Movie> movies=new HashMap<String,Movie>();
	String path;
	
	public void add(Movie movie) {
		movies.put(movie.getImdbId().toLowerCase(), movie);
	}

	public int getMovieCount() {
		// TODO Auto-generated method stub
		return movies.size();
	}
	
	public void save() {
		// TODO Auto-generated method stub
		try {
			ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream(path));
			writer.writeObject(this);
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage(),e);
		}
	}	
	public static MovieStore load(String path) {
		
		//FlatFileMovieRepository repository=new FlatFileMovieRepository();
		MovieStore store=null;
		System.out.println("MovieStore Load called");
		try {
			ObjectInputStream reader=new ObjectInputStream(new FileInputStream(path));
			store=(MovieStore) reader.readObject();
			
		}catch(Exception ex) {
			//the file may not exist. It is ok. we may want to start from scratch
			store=new MovieStore();
		}
		store.path=path;
		return store;
		
	}

}
