package Assignments.assignment4.ships;

import Assignments.assignment4.Ocean;

public abstract class Ship {
	private int bowRow; //the row (0 to 19) which contains the bow (front) of the ship.
	private int bowColumn; //the column which contains the bow (front) of the ship.    
	private int length; //the number of squares occupied by the ship. An ”empty sea” location has length 1. 
	private boolean horizontal; //true if the ship occupies a single row, false otherwise. Ships will either be placed vertically or horizontally in the ocean.
	private boolean[] hit; //this is a boolean array of size 8 that record hits. Only battleships use all the locations. The others will use fewer.
	
	abstract String getShipType();
	
	/* Returns true if it is okay to put a ship of this length with its bow in this location, with the given orientation, and returns false otherwise. */
	boolean okToPlaceShip(int row, int column, boolean horizontal, Ocean ocean){
		//TODO
		return false;
	}
	
	/* ”Puts” the ship in the ocean. */
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean){
		//TODO
		return;
	}
	
	/* If a part of the ship occupies the given row and column, and the ship hasn’t been sunk,
	 * mark that part of the ship as ”hit” and return true, otherwise return false. */
	boolean shootAt(int row, int column){
		//TODO
		return false;
	}
	
	/* Return true if every part of the ship has been hit, false otherwise.*/
	boolean isSunk(){
		//TODO
		return false;
	}
	
	/* Override the toString() method */
	@Override
	public String toString(){
		//TODO
		return "";
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
