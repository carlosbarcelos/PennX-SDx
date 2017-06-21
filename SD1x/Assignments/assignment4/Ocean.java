package Assignments.assignment4;

import Assignments.assignment4.ships.*;

public class Ocean {
	
	public final int BOARD_SIZE = 20;
	public final int NUM_SHIPS = 13;

	Ship[][] ships = new Ship[BOARD_SIZE][BOARD_SIZE]; //Used to quickly determine which ship is in any given location.
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
	public void placeAllShipsRandomly(){
		//TODO
		return;
	}

	/* Returns true if the given location contains a ship, false if it does not. */
	public boolean isOccupied(int row, int column){
		if(this.ships[row][column].toString().equals("~")){ //if the location is water, it is not a ship
			return false;
		} else{
			return true;
		}
	}

	/* Returns true if the given location contains a ”real” ship, still afloat, (not an EmptySea), false if it does not. */
	public boolean shootAt(int row, int column){
		//TODO
		return false;
	}

	/* Returns the number of shots fired (in this game). */
	public int getShotsFired(){
		return this.shotsFired;
	}

	/* Returns the number of hits recorded (in this game). */
	public int getHitCount(){
		return this.hitCount;
	}

	/* Returns the number of ships sunk (in this game). */
	public int getShipsSunk(){
		return this.shipsSunk;
	}

	/* Returns true if all ships have been sunk, otherwise false. */
	public boolean isGameOver(){
		if(this.shipsSunk == 13){
			return true;
		}else{
			return false;
		}
	}

	/* Returns the 20x20 array of ships. */
	public Ship[][] getShipArray(){
		return this.ships;
	}
	
	/* Sets the 20x20 array of ships. */
	public void setShipArray(Ship[][] shipArray){
		this.ships = shipArray;
	}

	/* Prints the ocean. */
	public void print(){
//		Ship[][] shipArray = getShipArray();
//		//print the top grid row
//		System.out.print("      00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19");
//		
//		System.out.print("00    00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19");
//		System.out.print("00    00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19");
//		System.out.print("00    00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19");
//
//
//		//print the body of the grid
//		String buffer;
//		String c;
//		for(int i = 0; i < shipArray.length; i++){
//			buffer = "00   ";
//			for(int j = 0; j < shipArray.length; j++){
//				if(shipArray[i][j].{
//					
//				} else(){
//					
//				}
//				buffer.concat("  " + c);
//			}
//		}
		return;
	}

	
}
