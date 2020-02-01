package in.conceptarchitect.movieservice.repository.hibernate;

import java.util.Collection;

import org.hibernate.Session;

import in.conceptarchitect.movieservice.Movie;
import in.conceptarchitect.movieservice.Repository;

public class MovieHibernateRepository implements Repository<Movie, String> {
	
	

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
		Session session=HibernateUtils.getSessionFactory().openSession();
		
		Movie movie= session.get(Movie.class, id);
		
		return movie;
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
