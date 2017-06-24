package Assignments.assignment4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Assignments.assignment4.ships.*;

public class OceanTest {
	Ocean ocean;

	@Before
	public void setUp() throws Exception {
		ocean = new Ocean();
	}
	
	@Test
	public void testPlaceAllShipsRandomly() {
		ocean.placeAllShipsRandomly();
		ocean.print();
	}

	@Test
	public void testIsOccupied() {
		Ship battleShip = new BattleShip();
		battleShip.placeShipAt(0, 0, true, ocean);
		assertTrue(ocean.isOccupied(0, 0));
		assertFalse(ocean.isOccupied(1, 0));
	}

	@Test
	public void testShootAt() {
		Ship submarine = new Submarine();
		submarine.placeShipAt(0, 0, true, ocean);
		assertEquals(ocean.getHitCount(), 0);
		assertEquals(ocean.getShotsFired(), 0);
		assertTrue(ocean.shootAt(0, 0)); //shot at ship returns true
		assertTrue(ocean.shootAt(0, 0)); //repeated shot returns true
		assertEquals(ocean.getHitCount(), 2);
		assertEquals(ocean.getShotsFired(), 2);
		ocean.shootAt(0, 1);
		ocean.shootAt(0, 2);
		assertEquals(ocean.getShipsSunk(), 1);
		assertFalse(ocean.shootAt(0, 0));//shot at sunken ship returns false
		assertEquals(ocean.getHitCount(), 4);
		assertEquals(ocean.getShotsFired(), 5);
		assertFalse(ocean.shootAt(1, 0));//shot at emptysea returns false
		assertEquals(ocean.getHitCount(), 4);
		assertEquals(ocean.getShotsFired(), 6);
	}
}
