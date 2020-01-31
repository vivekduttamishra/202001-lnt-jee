package in.conceptarchitect.movieservice;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MOVIE_TABLE")
public class Movie implements Serializable{

	
	@Id
	@Column(unique = true, nullable = false, name = "IMDB_ID")
	String imdbId; //unique identifier

	@Column(name="MOVIE_TITLE")
	String name; //name of movie/tv shows/games
	
	String type;
	String poster;
	double imdbRating;
	String plot;
	String genre;
	
	Collection<Review> reviews; //reviews done for current movie
	
	public Movie(String imdbId, String name, String type, String poster, double imdbRating, String plot, String genre) {
		super();
		this.imdbId = imdbId;
		this.name = name;
		this.type = type;
		this.poster = poster;
		this.imdbRating = imdbRating;
		this.plot = plot;
		this.genre = genre;
	}
	public Movie() {
		super();
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Movie [imdbId=" + imdbId + ", name=" + name + ", type=" + type + ", poster=" + poster + ", imdbRating="
				+ imdbRating + ", plot=" + plot + ", genre=" + genre + "]";
	}
	
	public void addReview(Review review) {
		reviews.add(review);
	}
	
	

}
