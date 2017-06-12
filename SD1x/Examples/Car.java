package Examples;

import java.util.Calendar;

public class Car {
	//instance variables
	String make;
	String model;
	int year;
	boolean isNew;
	double miles; //miles the car has traveled
	String owner;

	public Car(String make, String model, int year, boolean isNew, double miles, String owner){
		this.make = make;
		this.model = model;
		this.year = year;
		this.isNew = isNew;
		this.miles = miles;
		this.owner = owner;
	}
	
	/* Sell the car to newOwner */
	public void sell(String newOwner){
		this.owner = newOwner;
		if(isNew){
			this.isNew = false;
		}
	}
	
	/* Is the car older than 10 years?*/
	public boolean isOld(){
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		if(thisYear - this.year > 10){
			return true;
		}
		return false;
	}
}
