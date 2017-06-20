package Assignments.assignment3;

import java.util.ArrayList;

public class Actor {

	private String name; //the full name of the actor/actress
	private ArrayList<Movie> movies; //the movies this actor has acted in
	
	public Actor(){}
	
	public Actor(String name, ArrayList<Movie> movies){
		this.name = name;
		this.movies = movies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Movie> getMovies() {
		return movies;
	}

	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}
}
