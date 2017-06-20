package Assignments.assignment3;

import java.util.ArrayList;

public class Movie {

	private String name; //the name of the movie
	private ArrayList<Actor> actors; //the actors in the movie
	private double rating; //a freshness rating from rotten tomatoes (www.rottentomatoes.com)
	
	public Movie(){}
	
	public Movie(String name, ArrayList<Actor> actors, double rating){
		this.name = name;
		this.actors = actors;
		this.rating = rating;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Actor> getActors() {
		return actors;
	}
	public void setActors(ArrayList<Actor> actors) {
		this.actors = actors;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
}
