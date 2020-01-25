package in.conceptarchitect.movies.repository.flatfile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

import in.conceptarchitect.movieservice.Movie;
import in.conceptarchitect.movieservice.Repository;


public class FlatFileMovieRepository implements Repository<Movie,String>{
	
	MovieStore store;

	public MovieStore getStore() {
		return store;
	}

	public void setStore(MovieStore store) {
		this.store = store;
	}

	public String add(Movie entity) {
		// TODO Auto-generated method stub
		if(entity==null || entity.getImdbId()==null)
			return null;
		
		Movie current=getById(entity.getImdbId());
		
		if(current!=null) //if a movie with same id exists		
			return null;
		
		store.add(entity);
		
		return entity.getImdbId();
		
	}

	public Collection<Movie> getAll() {
		// TODO Auto-generated method stub
		return store.movies.values();
	}

	public Movie getById(String id) {
		// TODO Auto-generated method stub
		if(id==null)
			return null;
		return store.movies.get(id.toLowerCase());
	}

	public void remove(String id) {
		// TODO Auto-generated method stub
		store.movies.remove(id.toLowerCase());
	}

	public void update(String id, Movie newEntity) {
		// TODO Auto-generated method stub
		if(id.equalsIgnoreCase(newEntity.getImdbId()))
			store.movies.put(id.toLowerCase(), newEntity);
	}

	public void save() {
		store.save();
	}
}
