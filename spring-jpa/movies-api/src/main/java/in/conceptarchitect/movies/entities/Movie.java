package in.conceptarchitect.movies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Movies")
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
