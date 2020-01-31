package in.conceptarchitect.movieservice.repository.hibernate;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import in.conceptarchitect.movieservice.Movie;
import in.conceptarchitect.movieservice.Repository;

public class MovieHibernateRepository implements Repository<Movie, String> {
	
	SessionFactory factory;
	
	public MovieHibernateRepository() {
		
		 // loads configuration and mappings
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry
            = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();         
        // builds a session factory from the service registry
        factory = configuration.buildSessionFactory(serviceRegistry);                
        
         
	}
	
	
	

	public String add(Movie entity) {
		// TODO Auto-generated method stub
		//Driver
		factory.openSession().persist(entity); //auto generate insert query
		return entity.getImdbId();
	}

	public Collection<Movie> getAll() {
		// TODO Auto-generated method stub
		return factory.openSession()
				.createQuery("from Movie", Movie.class) //auto generate select 
				.list();   //map the results to a List of Movie
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
