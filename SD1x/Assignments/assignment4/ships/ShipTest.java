package Assignments.assignment4.ships;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Assignments.assignment4.*;

public class ShipTest {
	Ocean ocean;
	Ship battleShip;
	Ship cruiser;
	Ship submarine;
	
	@Before
	public void setUp() throws Exception {
		ocean = new Ocean();
		battleShip = new BattleShip(); //8 squares
		cruiser = new Cruiser();       //6 squares
		submarine = new Submarine();   //3 squares
	}

	@Test
	public void testOkToPlaceShip() {
		assertFalse(battleShip.okToPlaceShip(19, 19, true, ocean)); //falls off right of ocean
		assertFalse(battleShip.okToPlaceShip(19, 19, false, ocean)); //falls off botton of ocean
		//TODO
	}

	@Test
	public void testPlaceShipAt() {
		fail("Not yet implemented");
	}

	@Test
	public void testShootAt() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsSunk() {
		fail("Not yet implemented");
	}

}
