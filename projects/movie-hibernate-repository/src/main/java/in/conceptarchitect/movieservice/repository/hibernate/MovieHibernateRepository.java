package in.conceptarchitect.movieservice.repository.hibernate;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.conceptarchitect.movieservice.Movie;

public class MovieHibernateRepository //implements Repository<Movie, String> {
	{
	

	public String add(final Movie entity) {
		// TODO Auto-generated method stub
		//Driver
		//getSession().persist(entity); //auto generate insert query
		HibernateUtils.transact(session->session.save(entity));
		
		return entity.getImdbId();
	}

	public Collection<Movie> getAll() {
		// TODO Auto-generated method stub
		return HibernateUtils.query("from Movie", Movie.class);
	}

	public Movie getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(String id) {
		// TODO Auto-generated method stub
		
	}

	public void update(String id, Movie newEntity) {
		// TODO Auto-generated method stub
		
	}

	public void save() {
		// TODO Auto-generated method stub
		
	}

}
