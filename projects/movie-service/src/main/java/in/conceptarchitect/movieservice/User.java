package in.conceptarchitect.movieservice;

import java.util.ArrayList;
import java.util.Collection;

public class User {
	
	String name;
	String email; //user id
	String password; 
	String photoUrl;
	
	Collection<Review> reviews; //reviews done by current user

	public User() {
		super();
		reviews=new ArrayList<Review>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Collection<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Collection<Review> reviews) {
		this.reviews = reviews;
	}

	public User(String name, String email, String password, String photoUrl) {
		this();
		this.name = name;
		this.email = email;
		this.password = password;
		this.photoUrl = photoUrl;
	}
	
	public void addReview(Review review) {
		reviews.add(review);
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", photoUrl=" + photoUrl + "]";
	}
	

}
