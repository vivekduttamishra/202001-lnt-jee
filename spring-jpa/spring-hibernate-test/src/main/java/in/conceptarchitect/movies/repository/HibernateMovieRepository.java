package in.conceptarchitect.movies.repository;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.conceptarchitect.movies.entities.Movie;
import in.conceptarchitect.movies.services.MovieRepository;


@Repository
public class HibernateMovieRepository implements MovieRepository{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(movie);
		
		
	}

	@Transactional(readOnly = true)
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Movie",Movie.class).list();
	}

}
