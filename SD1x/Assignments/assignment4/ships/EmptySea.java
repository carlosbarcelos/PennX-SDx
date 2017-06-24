package Assignments.assignment4.ships;

public class EmptySea extends Ship {

	public EmptySea(){
		this.setLength(1);
	}
	
	@Override
	public boolean shootAt(int row, int column){
		return false;
	}
	
	@Override 
	public boolean isSunk(){
		return false;
	}
	
	@Override
	public String toString(){
		return "~"; //show that this is opensea (water)
	}
	
	@Override
	public String getShipType() {
		return "empty";
	}

}