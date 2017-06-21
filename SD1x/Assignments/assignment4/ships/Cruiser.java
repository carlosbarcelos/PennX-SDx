package Assignments.assignment4.ships;

public class Cruiser extends Ship {
	
	public Cruiser(){
		this.setLength(6);
		this.setHit(new boolean[6]);
	}
	
	@Override
	public String getShipType() {
		return "cruiser";
	}

}
