package Examples;

import java.util.*;

public class Prime {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int myNumber = 1;
		while(myNumber != -999){ // Allow the program to be closed
			System.out.println("Enter a number: ");
			myNumber = scanner.nextInt();
			
			/* Search for a prime */
			int potentialFactor = 2;
			while(myNumber % potentialFactor != 0){
				potentialFactor++;
			}
			if(potentialFactor == myNumber){
				System.out.println("The number " + myNumber + " is prime.");
			} else{
				System.out.println("The number " + myNumber + " is not prime.\n Factor is " + potentialFactor);
			}
		}
		
		/* Close the scanner before exiting */
		scanner.close();
		System.out.println("Goodbye.");
	}

}
