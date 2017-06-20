package Assignments.assignment3;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MovieDatabaseTest {
	MovieDatabase thisDatabase;
	Movie movieA; 
	Movie movieB;
	Actor actorA;
	Actor actorB;
	ArrayList<Actor> actorListExpected;
	ArrayList<Movie> movieListExpected;


	@Before
	public void setUp() throws Exception {
		thisDatabase = new MovieDatabase();
		
		movieA = new Movie("movieA", new ArrayList<Actor>(), 1.0); 
		movieB = new Movie("movieB", new ArrayList<Actor>(), 2.0);
		actorA = new Actor("actorA", new ArrayList<Movie>());
		actorB = new Actor("actorB", new ArrayList<Movie>());
		actorListExpected = new ArrayList<Actor>();
		actorListExpected.add(actorA);
		actorListExpected.add(actorB);
		movieListExpected = new ArrayList<Movie>();
		movieListExpected.add(movieA);
		movieListExpected.add(movieB);
		
		actorA.setMovies(movieListExpected);
		actorB.setMovies(movieListExpected);
		movieA.setActors(actorListExpected);
		movieB.setActors(actorListExpected);
	}

	@Test
	public void testAddMovie() {
		//add the test movies via the methods
		String movieTitle = "movieA";
		String[] actors = {"actorA", "actorB"};
		thisDatabase.addMovie(movieTitle, actors);
		movieTitle = "movieB";
		thisDatabase.addMovie(movieTitle, actors);
		//get the results and compare
		ArrayList<Actor> actorListActual = thisDatabase.getActorList();
		ArrayList<Movie> movieListActual = thisDatabase.getMovieList();
		assertEquals(actorListActual.size(), actorListExpected.size());
		assertEquals(movieListActual.size(), movieListExpected.size());
	}


	@Test
	public void testUpdateRating()  {
		String movieTitle = "movieA";
		String[] actors = {"actorA", "actorB"};
		thisDatabase.addMovie(movieTitle, actors);
		
		movieTitle = "movieB";
		thisDatabase.addMovie(movieTitle, actors);
		
		ArrayList<Movie> movieListActual = thisDatabase.getMovieList();
		String movieA = "movieA";
		String movieB = "movieB";
		//test that the rating was added
		thisDatabase.addRating(movieA, 2.3);
		for(Movie m : movieListActual){
			if(m.getName().equals(movieA)){
				assertTrue(m.getRating() == 2.3); 
			}
		}
		
		//test that the rating was changed
		thisDatabase.updateRating(movieA, 3.6);
		for(Movie m : movieListActual){
			if(m.getName().equals(movieA)){
				assertTrue(m.getRating() == 3.6);
			}
		}
		
		//add movieB rating
		thisDatabase.addRating(movieB, 5.0);
		for(Movie m : movieListActual){
			if(m.getName().equals(movieB)){
				assertTrue(m.getRating() == 5.0); 
			}
		}
	}

	@Test
	public void testGetBestActor() {
		String movieTitle = "movieA";
		String[] actors = {"actorA", "actorB"};
		thisDatabase.addMovie(movieTitle, actors);
		
		movieTitle = "movieB";
		thisDatabase.addMovie(movieTitle, actors);
		
		//test that the rating was added
		thisDatabase.addRating("movieA", 2.3);
		thisDatabase.addRating("movieB", 10.0);
		
		//add a new, highly acclaimed movie
		
		String[] movieCActors = {"actorC"};
		thisDatabase.addMovie("movieC", movieCActors);
		thisDatabase.addRating("movieC", 10.0);
		//find the highest rated actor
		assertTrue(thisDatabase.getBestActor().equals("actorC")); 
	}

	@Test
	public void testGetBestMovie() {
		String movieTitle = "movieA";
		String[] actors = {"actorA", "actorB"};
		thisDatabase.addMovie(movieTitle, actors);
		
		movieTitle = "movieB";
		thisDatabase.addMovie(movieTitle, actors);
		
		thisDatabase.addRating("movieA", 2.3);
		thisDatabase.addRating("movieB", 5.0);
		
		//add a new, highly acclaimed movie
		String[] movieCActors = {"actorC"};
		thisDatabase.addMovie("movieC", movieCActors);
		thisDatabase.addRating("movieC", 10.0);
		//find the highest rated movie
		assertTrue(thisDatabase.getBestMovie().equals("movieC")); 
		
		//rest a tie
		thisDatabase.updateRating("movieB", 10.0);
		assertTrue(thisDatabase.getBestMovie().equals("movieB")); 
	}
}
