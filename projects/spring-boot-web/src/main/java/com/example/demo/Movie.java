package com.example.demo;

import java.io.Serializable;

public class Movie implements Serializable{
	
	
	String name;
	String imdbId;
	double imdbRating;
	
	
	@Override
	public String toString() {
		return "Movie [name=" + name + ", imdbId=" + imdbId + ", imdbRating=" + imdbRating + "]";
	}
	public Movie() {
		super();
	}
	public Movie(String imdbId, String name, double imdbRating) {
		super();
		this.imdbId = imdbId;
		this.name = name;
		this.imdbRating = imdbRating;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	
	
}
