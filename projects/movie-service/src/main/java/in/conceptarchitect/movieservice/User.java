package in.conceptarchitect.movieservice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User implements Serializable	{
	
	
	String name;
	@Id
	@Column(unique = true, 
	nullable = false, 
	name = "email", 
	columnDefinition = "VARCHAR(16)")
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
		this.email = email.toLowerCase();
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
