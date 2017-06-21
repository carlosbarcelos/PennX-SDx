package Assignments.assignment4.ships;

import Assignments.assignment4.Ocean;

public abstract class Ship {
	private int bowRow; //the row (0 to 19) which contains the bow (front) of the ship.
	private int bowColumn; //the column which contains the bow (front) of the ship.    
	private int length; //the number of squares occupied by the ship. An ”empty sea” location has length 1. 
	private boolean horizontal; //true if the ship occupies a single row, false otherwise. Ships will either be placed vertically or horizontally in the ocean.
	private boolean[] hit; //this is a boolean array of size 8 that record hits. Only battleships use all the locations. The others will use fewer.

	public abstract String getShipType();

	/* Returns true if it is okay to put a ship of this length with its bow in this location, with the given orientation, and returns false otherwise. */
	boolean okToPlaceShip(int row, int column, boolean horizontal, Ocean ocean){	
		if(horizontal){
			if(column+length > ocean.BOARD_SIZE){ //ensure ship is not out of bounds
				return false;
			}
			for(int i = 0; i < ocean.BOARD_SIZE; i++){ 
				if(ocean.isOccupied(row + i, column)){ //ensure ship does not overlap with other ship
					return false;
				}
			}
		} else{
			if(row+length > ocean.BOARD_SIZE){ //ensure ship is not out of bounds
				return false;
			}
			for(int j = 0; j < ocean.BOARD_SIZE; j++){ 
				if(ocean.isOccupied(row, column + j)){ //ensure ship does not overlap with other ship
					return false;
				}
			}
		}
		return true;
	}

	/* ”Puts” the ship in the ocean. */
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean){
		//make sure this placement is legal
		if(!okToPlaceShip(row, column, horizontal, ocean)){
			return;
		}

		//set the ocean ship[][] array
		Ship[][] shipArray = ocean.getShipArray();
		if(horizontal){
			for(int i = 0; i < this.length; i++){ 
				shipArray[row + i][column] = this;
			}
		} else{
			for(int j = 0; j < this.length; j++){ 
				shipArray[row][column + j] = this;
			}
		}
		ocean.setShipArray(shipArray);

		//set the local variables
		this.bowRow = row;
		this.bowColumn = column;
		this.horizontal = horizontal;
	}

	/* If a part of the ship occupies the given row and column, and the ship hasn’t been sunk,
	 * mark that part of the ship as ”hit” and return true, otherwise return false. */
	boolean shootAt(int row, int column){
		if(horizontal){
			for(int i = 0; i < this.length; i++){ 
				if(bowRow == row && (bowColumn + i) == column){
					hit[i] = true;
					return true;
				}
			}
		} else{
			for(int j = 0; j < this.length; j++){ 
				if((bowRow + j) == row && bowColumn == column){
					hit[j] = true;
					return true;
				}
			}
		}
		return false;
	}

	/* Return true if every part of the ship has been hit, false otherwise.*/
	boolean isSunk(){
		for(int i = 0; i < hit.length; i++){
			if(hit[i] == false){
				return false;
			}
		}
		return true;
	}

	/* Override the toString() method */
	@Override
	public String toString(){
		if(isSunk()){
			return "x";
		} else{
			return "S";
		}
	}

	//====== Getters and Setters =====\\
	public int getBowRow() {
		return bowRow;
	}
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}
	public int getBowColumn() {
		return bowColumn;
	}
	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public boolean isHorizontal() {
		return horizontal;
	}
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	public boolean[] getHit() {
		return hit;
	}
	public void setHit(boolean[] hit) {
		this.hit = hit;
	}
}
