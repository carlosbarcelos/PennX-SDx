package Assignments.assignment4;

import java.util.Random;

import Assignments.assignment4.ships.*;

public class Ocean {

	public final int BOARD_SIZE = 20;
	public final int NUM_SHIPS = 13;

	Ship[][] ships = new Ship[BOARD_SIZE][BOARD_SIZE]; //Used to quickly determine which ship is in any given location.
	int shotsFired; // The total number of shots fired by the user.
	int hitCount; // The number of times a shot hit a ship. If the user shoots the same part of a ship more than once, every hit is counted, even though the additional ”hits” don’t do the user any good.
	int shipsSunk; // The number of ships sunk. Remember that you have a total of 13 ships. 
	boolean shotHistory[][] = new boolean[BOARD_SIZE][BOARD_SIZE]; // A history of all shots fired
	
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
		//create all of the ships to place
		boolean[] placedShips = new boolean[13]; //keep track of placed ships
		Ship[] ships = new Ship[13];
		Ship battleShip = new BattleShip();      //8 squares x1
		ships[0] = battleShip;
		Ship battleCruiser = new BattleCruiser();//7 squares x1
		ships[1] = battleCruiser;
		Ship cruiser1 = new Cruiser();           //6 squares x2
		ships[2] = cruiser1;
		Ship cruiser2 = new Cruiser(); 
		ships[3] = cruiser2;
		Ship lightCruiser1 = new LightCruiser(); //5 squares x2
		ships[4] = lightCruiser1;
		Ship lightCruiser2 = new LightCruiser();
		ships[5] = lightCruiser2;
		Ship destroyer1 = new Destroyer();       //4 squares x3
		ships[6] = destroyer1;
		Ship destroyer2 = new Destroyer();
		ships[7] = destroyer2;
		Ship destroyer3 = new Destroyer();
		ships[8] = destroyer3;
		Ship submarine1 = new Submarine();       //3 squares x4
		ships[9] = submarine1;
		Ship submarine2 = new Submarine();
		ships[10] = submarine2;
		Ship submarine3 = new Submarine();
		ships[11] = submarine3;
		Ship submarine4 = new Submarine();
		ships[12] = submarine4;

		//create random location at which to place the ship
		Random r = new Random();
		int thisRow;
		int thisColumn;
		boolean thisHorizontal;
		for(int i = 0; i < 13; i++){
			while(!placedShips[i]){ //try to place the ship until it is placed
				//get row,column,horizontal values
				thisRow = r.nextInt(20);
				thisColumn = r.nextInt(20);
				if(thisRow+thisColumn%2==0){
					thisHorizontal = true;
				} else{
					thisHorizontal = false;
				}
				//attempt to place the ship
				placedShips[i] = ships[i].okToPlaceShipAt(thisRow, thisColumn, thisHorizontal, this);
				if(placedShips[i]){
					ships[i].placeShipAt(thisRow, thisColumn, thisHorizontal, this);
				}
			}
		}
		return;
	}

	/* Returns true if the given location contains a ship, false if it does not. */
	public boolean isOccupied(int row, int column){
		if(this.ships[row][column].getShipType().equals("empty")){ //if the location is water, it is not a ship
			return false;
		} else{
			return true;
		}
	}

	/* Returns true if the given location contains a ”real” ship, still afloat, (not an EmptySea), false if it does not. */
	public boolean shootAt(int row, int column){
		//does location contain real ship?
		if(!ships[row][column].getShipType().equals("empty")){
			//is real ship afloat?
			if(!ships[row][column].isSunk()){
				ships[row][column].shootAt(row, column);
				//did this shot sink the ship
				if(ships[row][column].isSunk()){
					shipsSunk++;
				}
				hitCount++;
				shotsFired++;
				shotHistory[row][column] = true;
				return true;
			}
		} 
		shotsFired++;
		shotHistory[row][column] = true;
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
		//print the top grid row
		System.out.println("      00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19\n");

		//print the body of the grid
		String buffer;
		String c;
		for(int i = 0; i < ships.length; i++){
			if(i < 10){
				buffer = "0" + Integer.toString(i) + "   ";
			} else{
				buffer = Integer.toString(i) + "   ";
			}
			for(int j = 0; j < ships.length; j++){
				if(shotHistory[i][j]){ //this location was fired upon
					if(ships[i][j].getShipType().equals("empty")){
						c = "-"; //’-’ to indicate a location that you have fired upon and found nothing there
					} else if(ships[i][j].isSunk()){
						c = "x"; //’x’ to indicate a location containing a sunken ship
					} else {
						c = "S"; //’S’ to indicate a location that you have fired upon and hit a (real) ship
					}	
				} else{
					c = "."; //’.’ to indicate a location that you have never fired upon

				}
				buffer = buffer.concat("  " + c);
			}
			System.out.println(buffer);
		}
		return;
	}
}
