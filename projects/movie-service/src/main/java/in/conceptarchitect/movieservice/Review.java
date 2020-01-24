package in.conceptarchitect.movieservice;

public class Review {
	
	int reviewId; //unqiue identifier
	int rating; //1-10
	String description;
	
	//about which movie?
	//String imbdId; //optional
	Movie movie;   //review is about a movie
	
	//who reviewed it?	
	User user;

	public Review(int reviewId, int rating, String description, Movie movie, User user) {
		super();
		this.reviewId = reviewId;
		this.rating = rating;
		this.description = description;
		this.movie = movie;
		this.user = user;
	}

	public Review() {
		super();
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", rating=" + rating + ", description=" + description + ", movie="
				+ movie + ", user=" + user + "]";
	} 
	
}
