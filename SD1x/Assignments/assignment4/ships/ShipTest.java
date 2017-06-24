package Assignments.assignment4.ships;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Assignments.assignment4.*;

public class ShipTest {
	Ocean ocean;
	Ship battleShip;
	Ship battleCruiser;
	Ship cruiser1;
	Ship cruiser2;
	Ship lightCruiser1;
	Ship lightCruiser2;
	Ship destroyer1;
	Ship destroyer2;
	Ship destroyer3;
	Ship submarine1;
	Ship submarine2;
	Ship submarine3;
	Ship submarine4;
	
	@Before
	public void setUp() throws Exception {
		ocean = new Ocean();
		battleShip = new BattleShip();      //8 squares x1
		battleCruiser = new BattleCruiser();//7 squares x1
		cruiser1 = new Cruiser();           //6 squares x2
		cruiser2 = new Cruiser(); 
		lightCruiser1 = new LightCruiser(); //5 squares x2
		lightCruiser2 = new LightCruiser();
		destroyer1 = new Destroyer();       //4 squares x3
		destroyer2 = new Destroyer();
		destroyer3 = new Destroyer();
		submarine1 = new Submarine();       //3 squares x4
		submarine2 = new Submarine();
		submarine3 = new Submarine();
		submarine4 = new Submarine();
	}

	@Test
	public void testPlaceShipAt() {
		battleShip.placeShipAt(0, 0, false, ocean); //place ship vertically at (0,0)
		Ship[][] shipArray = ocean.getShipArray();
		for(int i = 0; i < battleShip.getLength(); i++){
			assertTrue(shipArray[0+i][0].toString().equals("S"));
		}
	}
	
	@Test
	public void testOkToPlaceShip() {
		//test placement at boundries
		assertFalse(battleShip.okToPlaceShipAt(19, 19, true, ocean));
		assertFalse(battleShip.okToPlaceShipAt(19, 19, false, ocean));
		assertFalse("Placed a ship that stuck out of the ocean", cruiser1.okToPlaceShipAt(0, 18, true, ocean));
		//test overlap placement
		battleShip.placeShipAt(0, 0, false, ocean);
		assertTrue(battleCruiser.okToPlaceShipAt(0, 1, false, ocean));
		assertFalse(battleCruiser.okToPlaceShipAt(1, 0, true, ocean));
	}


	@Test
	public void testShootAt() {
		battleShip.placeShipAt(0, 0, true, ocean);
		assertTrue(battleShip.shootAt(0, 0));
		assertTrue(battleShip.shootAt(0, 1));
		assertFalse(battleShip.shootAt(1, 0));

		assertTrue(battleShip.getHit()[0]);
		assertTrue(battleShip.getHit()[1]);
		for(int i = 2; i < battleShip.getLength(); i++){
			assertFalse(battleShip.getHit()[i]);
		}

	}

	@Test
	public void testIsSunk() {
		battleCruiser.placeShipAt(0, 0, true, ocean);
		//test no hit ship
		assertFalse(battleShip.isSunk());
		//test partially hit ship
		battleCruiser.shootAt(0, 0);
		battleCruiser.shootAt(0, 1);
		battleCruiser.shootAt(0, 2);
		assertFalse(battleShip.isSunk());
		//test sunk ship
		battleCruiser.shootAt(0, 3);
		battleCruiser.shootAt(0, 4);
		battleCruiser.shootAt(0, 5);
		battleCruiser.shootAt(0, 6);
		assertFalse(battleShip.isSunk());
	}
}
