package in.conceptarchitect.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.conceptarchitect.movies.entities.Movie;
import in.conceptarchitect.movies.entities.Review;
import in.conceptarchitect.utils.HibernateUtils;
import in.conceptarchitect.utils.HibernateUtilsV1;
import in.conceptarchitect.utils.Input;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=HibernateUtils.getSessionFactory();
		
		createMovie(factory);
		createReview(factory);
		listMovies(factory);
	}


	private static void createMovie(SessionFactory factory) {
		// TODO Auto-generated method stub
		String dontAdd="EXIT WITHOUT ADDING A MOVIE";
		String title=Input.readString("Title",dontAdd);
		if(title.contentEquals(dontAdd))
			return;
		Movie movie=new Movie(Input.readString("imdbId"), title, Input.readInt("imdbRating"), Input.readString("details"));
		
		Transaction tr=null;
		Session session=null;
		try{
			
		session=factory.openSession();
		tr=session.beginTransaction();
		session.save(movie);
		tr.commit();
		System.out.println("Movie Added");
			
		} catch(Exception ex) {
			if(tr!=null)
				tr.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	private static void listMovies(SessionFactory factory) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			session=factory.openSession();
			List<Movie> movies=session.createQuery("from Movie",Movie.class).list();
			
			//movies.forEach(System.out::println);
			
			for(Movie movie : movies) {
				System.out.println(movie.getTitle());
				for(Review review: movie.getReviews())
					System.out.println("\t"+review.getRating()+"\t"+review.getDescription());
				System.out.println();
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			session.close();
			
		}
		
	}

	private static void createReview(SessionFactory factory) {
		String noReview="Hit Enter to Exit";
		String imdbId=Input.readString("Movie to Revie", noReview);
		if(imdbId.contentEquals(noReview))
			return;
		
		
		Session session=factory.openSession();
		
		Movie movie =session.get(Movie.class, imdbId);
		if(movie==null) {
			System.out.println("No such Movie");
			return;
		}
		
		System.out.println("What is your review about "+movie.getTitle());
		int rating=Input.readInt("rating 1-10",5);
		String description=Input.readString("review");
		
		Review review=new Review(0, rating, description, movie);
		movie.getReviews().add(review);
		session.persist(review);
		session.persist(movie);
	}
	

}
