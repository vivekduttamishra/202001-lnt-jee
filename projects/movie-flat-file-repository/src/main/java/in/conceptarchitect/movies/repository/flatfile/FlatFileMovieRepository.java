package in.conceptarchitect.movies.repository.flatfile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;


public class FlatFileMovieRepository implements Repository<Movie,String>{
	
	MovieStore store;

	public String add(Movie entity) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		try {
			ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream(store.path));
			writer.writeObject(store);
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage(),e);
		}
	}	
	public static FlatFileMovieRepository load(String path) {
		
		FlatFileMovieRepository repository=new FlatFileMovieRepository();
		
		try {
			ObjectInputStream reader=new ObjectInputStream(new FileInputStream(path));
			repository.store=(MovieStore) reader.readObject();
			
		}catch(Exception ex) {
			//the file may not exist. It is ok. we may want to start from scratch
			repository.store=new MovieStore();
		}
		repository.store.path=path;
		return repository;
		
	}

}
