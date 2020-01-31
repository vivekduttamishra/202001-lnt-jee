package in.conceptarchitect.movies.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MOVIES")
public class Movie {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//	double id;
	
	@Column(name="imdbId",nullable = false,unique=true,columnDefinition="VARCHAR(64)")
	@Id
	String imdbId;
	@Column(name="movieTitle")
	String title;
	@Column(name="imdbRating")
	double imdbRating;
	@Column(name="movieDetails")
	String details;
	
	@OneToMany(cascade=CascadeType.ALL)
    //@JoinColumn(name="imdbId")
	Set<Review> reviews;
	
	
	
	public Set<Review> getReviews() {
		return reviews;
	}
	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Movie(String imdbId, String title, double imdbRating, String details) {
		super();
		this.imdbId = imdbId;
		this.title = title;
		this.imdbRating = imdbRating;
		this.details = details;
	}
	public Movie() {
		super();
	}
	
	
	
	
	@Override
	public String toString() {
		return "Movie [imdbId=" + imdbId + ", title=" + title + ", imdbRating=" + imdbRating + ", details=" + details
				+ "]";
	}
	
	
}
