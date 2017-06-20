package Assignments.assignment4;

import Assignments.assignment4.ships.*;

public class Ocean {

	Ship[][] ships = new Ship[20][20]; //Used to quickly determine which ship is in any given location.
	int shotsFired; // The total number of shots fired by the user.
	int hitCount; // The number of times a shot hit a ship. If the user shoots the same part of a ship more than once, every hit is counted, even though the additional ”hits” don’t do the user any good.
	int shipsSunk; // The number of ships sunk. Remember that you have a total of 13 ships. 
	
	public Ocean(){
		//create an empty ocean
		for(int i = 0 ; i < ships.length; i++){
			for(int j = 0; j < ships.length; j++){
				ships[i][j] = new EmptySea();
			}
		}
		//initalize game variables
		this.shotsFired = 0;
		this.hitCount = 0;
		this.shipsSunk = 0;
	}
	
	/* Place all randomly on the (initially empty) ocean. */
	void placeAllShipsRandomly(){
		//TODO
		return;
	}

	/* Returns true if the given location contains a ship, false if it does not. */
	boolean isOccupied(int row, int column){
		//TODO
		return false;
	}

	/* Returns true if the given location contains a ”real” ship, still afloat, (not an EmptySea), false if it does not. */
	boolean shootAt(int row, int column){
		//TODO
		return false;
	}

	/* Returns the number of shots fired (in this game). */
	int getShotsFired(){
		return this.shotsFired;
	}

	/* Returns the number of hits recorded (in this game). */
	int getHitCount(){
		return this.hitCount;
	}

	/* Returns the number of ships sunk (in this game). */
	int getShipsSunk(){
		return this.shipsSunk;
	}

	/* Returns true if all ships have been sunk, otherwise false. */
	boolean isGameOver(){
		if(this.shipsSunk == 13){
			return true;
		}else{
			return false;
		}
	}

	/* Returns the 20x20 array of ships. */
	Ship[][] getShipArray(){
		return this.ships;
	}

	/* Prints the ocean. */
	void print(){
		//TODO
		return;
	}

	
}
