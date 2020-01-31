package in.conceptarchitect.movies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REVIEWS")
public class Review {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="RATING")
	int rating;
	
	@Column(name="review")
	String description;
	
	Movie movie;

	public Review(int id, int rating, String description, Movie movie) {
		super();
		this.id = id;
		this.rating = rating;
		this.description = description;
		this.movie = movie;
	}

	public Review() {
		super();
	}
	
	

}
