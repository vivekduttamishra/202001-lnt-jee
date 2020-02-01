package in.conceptarchitect.movieservice;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import javax.persistence.ManyToOne;



@Entity
@Table(name="Reviews")
public class Review implements Serializable{
	
	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	int reviewId; //unqiue identifier
	
	@Column(name="rating")
	int rating; //1-10
	
	@Column(name="details")
	String description;
	
	//about which movie?
	//String imbdId; //optional
	
	@ManyToOne
	@JoinColumn(name="imdbId")
	Movie movie;   //review is about a movie
	
	//who reviewed it?	
	//User user;

	public Review(int reviewId, int rating, String description, Movie movie) {
		super();
		this.reviewId = reviewId;
		this.rating = rating;
		this.description = description;
		this.movie = movie;
		//this.user = user;
	}

	public Review() {
		super();
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", rating=" + rating + ", description=" + description + ", movie="
				+ movie  + "]";
	} 
	
}
