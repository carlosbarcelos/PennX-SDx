package Assignments.assignment4.ships;

public class BattleCruiser extends Ship {

	public BattleCruiser(){
		this.setLength(7);
		this.setHit(new boolean[7]);
	}
	
	@Override
	String getShipType() {
		return "battlecruiser";
	}

}
