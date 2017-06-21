package Assignments.assignment4.ships;

public class LightCruiser extends Ship {

	public LightCruiser(){
		this.setLength(5);
		this.setHit(new boolean[5]);
	}
	
	@Override
	public String getShipType() {
		return "lightcruiser";
	}

}
