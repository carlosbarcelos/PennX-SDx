package Assignments.assignment3;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MovieDatabase {

	ArrayList<Movie> movieList; //list of movies
	ArrayList<Actor> actorList;//list of actors

	public MovieDatabase(){
		this.movieList = new ArrayList<Movie>();
		this.actorList = new ArrayList<Actor>();
	}

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public ArrayList<Actor> getActorList() {
		return actorList;
	}

	/* Takes in the name of a movie that is not currently in the database along with a list of actors for that movie. */
	public void addMovie(String name, String[] actors){
		Actor currentActor;
		//update movies already in database
		for(int i = 0; i < movieList.size(); i++){
			Movie m = movieList.get(i);
			if(m.getName().equals(name)){
				return;
			}
		}

		//create the actor list (without adding the movie to their list)
		ArrayList<Actor> movieActorList = new ArrayList<Actor>();
		for(String s : actors){
			currentActor = isExistingActor(s);
			if(currentActor != null){ //add returning actor to movieActorList
				movieActorList.add(currentActor); 
			} else{ //else create the new actor
				Actor newActor = new Actor(s, new ArrayList<Movie>());
				actorList.add(newActor); //add new actor to actorList database
				movieActorList.add(newActor); //add new actor to movieActorList
			}
		}

		//create the new movie and add to database
		Movie newMovie = new Movie(name, movieActorList, 0.0);
		movieList.add(newMovie);

		//add the movie to each actors list
		for(String s : actors){
			for(Actor a : actorList){
				if(a.getName().equals(s)){
					ArrayList<Movie> actorMovieList = a.getMovies();
					actorMovieList.add(newMovie);
					a.setMovies(actorMovieList);
				}
			}
		}
	}

	private Actor isExistingActor(String actorName){
		for(Actor a : actorList){
			if(a.getName().equals(actorName)){
				return a;

			}
		}
		return null;
	}

	/* Add a rating for this movie. Assumes movie already exists. */
	public void addRating(String name, double rating){
		for(Movie m : movieList){
			if(m.getName().equals(name)){
				m.setRating(rating);
			}
		}
	}

	/* Update a rating for this movie. Assumes movie already exists. */
	public void updateRating(String name, double newRating){
		for(Movie m : movieList){
			if(m.getName().equals(name)){
				m.setRating(newRating);
			}
		}
	}

	/* Returns the name of the actor that has the best average rating for their movies. */
	public String getBestActor(){
		Actor bestActor = null;
		double bestAverage = 0.0;
		for(Actor a : actorList){
			double currentAverage = 0.0;
			for(Movie m : a.getMovies()){
				currentAverage += m.getRating();
			}
			currentAverage /= a.getMovies().size();
			if(currentAverage > bestAverage){
				bestActor = a;
				bestAverage = currentAverage;
			}
		}

		return bestActor.getName();
	}

	/* Returns the name of the movie that has the best rating. */
	public String getBestMovie(){
		Movie bestMovie = null;
		double bestRating = 0.0;
		for(Movie m : movieList){
			if(m.getRating() > bestRating){
				bestMovie = m;
				bestRating = m.getRating();
			}
		}
		return bestMovie.getName();
	}

	private void readMovieList(String f){
		File movieFile = new File(f);
		Scanner scnr; //file scanner
		Scanner scnrLine; //line scanner
		HashMap<String, ArrayList<String>> dbMap = new HashMap<String, ArrayList<String>>();
		try {
			scnr = new Scanner(movieFile);
			while(scnr.hasNextLine()){
				//get ready to parse
				String line = scnr.nextLine();
				scnrLine = new Scanner(line).useDelimiter(",");
				//get the key, value pair
				String actor = scnrLine.next().trim();
				ArrayList<String> movies = new ArrayList<String>();
				while(scnrLine.hasNextLine()){
					movies.add(scnrLine.next().trim());
				}
				//add the actor to each movie list
				for(String m : movies){
					boolean movieExists = dbMap.containsKey(m);
					if(movieExists){ //add to an existing movie
						ArrayList<String> tempActorList = dbMap.get(m);
						tempActorList.add(actor);
						dbMap.put(m, tempActorList);
					} else{ //add to a new movie
						ArrayList<String> tempActorList = new ArrayList<String>();
						tempActorList.add(actor);
						dbMap.put(m, tempActorList);
					}
				}
			}
			//add the movie/actor entry to the movie database
			for (Map.Entry<String,ArrayList<String>> entry : dbMap.entrySet()) {
				String key = entry.getKey();
				String[] value = entry.getValue().toArray(new String[entry.getValue().size()]);
				System.out.println(key);
				System.out.println(value.length);
				addMovie(key, value);
			}
			scnr.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	private void readRatingList(String f){
		File movieFile = new File(f);
		Scanner scnr; //file scanner
		Scanner scnrLine; //line scanner
		try {
			scnr = new Scanner(movieFile);
			scnr.nextLine(); //skip the first, instructional line
			while(scnr.hasNextLine()){
				String[] linePair = scnr.nextLine().split("\t");
				String movie = linePair[0];
				double rating = Double.parseDouble(linePair[1]);
				addRating(movie, rating);
			}
			scnr.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args){
		//		1) You create a new instance of a movieDatabase.
		MovieDatabase mainDatabase = new MovieDatabase();

		//		2) Add all the movies in the file movies.txt.
		mainDatabase.readMovieList("movies.txt");

		//		3) Go through the ratings of the movies in the file ratings.txt and add the ratings for the movies.
		mainDatabase.readRatingList("ratings.txt");
		
		//		4) Now call the methods that you created and print out the name of the best actor and the name of the highest rated movie.
		String bestActor = mainDatabase.getBestActor();
		String bestMovie = mainDatabase.getBestMovie();
		System.out.println("The best actor is " + bestActor);
		System.out.println("The best movie is " + bestMovie);
	}
}
