package Assignments.assignment4.ships;

public class Destroyer extends Ship {

	public Destroyer(){
		this.setLength(4);
		this.setHit(new boolean[4]);
	}
	
	@Override
	public String getShipType() {
		return "destroyer";
	}

}
