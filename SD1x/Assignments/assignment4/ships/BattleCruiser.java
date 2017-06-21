package Assignments.assignment4.ships;

public class BattleCruiser extends Ship {

	public BattleCruiser(){
		this.setLength(7);
		this.setHit(new boolean[7]);
	}
	
	@Override
	public String getShipType() {
		return "battlecruiser";
	}

}
