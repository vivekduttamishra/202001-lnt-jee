package in.conceptarchitect.movieservice.repository.hibernate;

import in.conceptarchitect.movieservice.Movie;
import in.conceptarchitect.movieservice.Review;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieHibernateRepository rep = new MovieHibernateRepository();
		// MovieService service=new MovieService(rep);

		// addMovie(rep);
		addDummyRecords(rep);
		listAllMovies(rep);

	}

	private static void addDummyRecords(MovieHibernateRepository rep) {
		// TODO Auto-generated method stub
		if (!Input.readString("ADD DUMMY RECORDS?").equals("y"))
			return;

		HibernateUtils.transact(session -> {

			Movie gandhi = new Movie("tt1234", "Gandhi", "Movie", "gandhi.jpg", 9.5, "Autobiography of Mahatma Gandhi",
					"History, Autobiorgraphy");
			Movie flash = new Movie("tt2222", "Flash", "TV Show", "flash.png", 7.8, "TV Show about DC superhero Flash",
					"superhero");

			Review review1 = new Review(0, 8, "Great Biopic. Historic!", gandhi);
			Review review2 = new Review(0, 7, "Each season taking story down", flash);
			Review review3 = new Review(0, 9, "Depiction of characters are excellent", gandhi);
			Review review4 = new Review(0, 5, "Slow!", flash);

			session.save(gandhi);
			session.save(flash);
			session.save(review1);
			session.save(review2);
			session.save(review3);
			session.save(review4);

		});
	}

	private static void listAllMovies(MovieHibernateRepository service) {
		// TODO Auto-generated method stub
		for (Movie movie : service.getAll()) {
			System.out.println(movie.getImdbId() + "\t\t" + movie.getName());
			for(Review review : movie.getReviews())
				System.out.println("\t"+review.getRating()+"\t"+review.getDescription());
			System.out.println();
		}
	}

	private static void addMovie(MovieHibernateRepository service) {
		// TODO Auto-generated method stub

		String name = Input.readString("Movie Name?");
		if (name == null || name.isEmpty())
			return;
		Movie movie = new Movie();
		movie.setName(name);
		movie.setImdbId(Input.readString("imdbId"));
		movie.setType("Movie");
		movie.setImdbRating(8);
		System.out.println("adding movie" + movie);
		service.add(movie);
		System.out.println("Movie Added");

		System.out.println();
	}

}
