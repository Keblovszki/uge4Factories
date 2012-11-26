package hotciv.standard;

import static org.junit.Assert.*;
import hotciv.factories.*;
import hotciv.framework.*;

import org.junit.Before;
import org.junit.Test;

public class TestEpsilonCiv {
	private Game game;
	
	@Before
	public void SetUp() {
		game = new GameImpl( new EpsilonFactory() );
	}
	
	@Test
	public void redArcher2_1WinsOverBlueLegion0_2() {
		Position from = new Position(2, 1);
		Position to = new Position(0, 2);
		Unit redArcher = game.getUnitAt(from);
		Unit blueLegion = game.getUnitAt(to);
		assertEquals("The position (2, 1) should be archer", redArcher.getTypeString(), GameConstants.ARCHER);
		assertEquals("The position (0, 2) should be legion", blueLegion.getTypeString(), GameConstants.LEGION);
		
		//do the attack!
		assertTrue("should be true", game.attackUnit(from, to));
		assertNull("The 'from' position should be null", game.getUnitAt(from));
		assertEquals("The 'to' position should be the redArcher", game.getUnitAt(to).getTypeString(), GameConstants.ARCHER);
	}
	
	@Test
	public void bonusFromTownToWin() {
		Position from = new Position(1, 0);
		Position to = new Position(4, 1);
		Unit redArcher = game.getUnitAt(from);
		Unit blueLegion = game.getUnitAt(to);
		City c = game.getCityAt(to);
		assertEquals("The position (1, 0) should be archer", redArcher.getTypeString(), GameConstants.ARCHER);
		assertEquals("The position (4, 1) should be legion", blueLegion.getTypeString(), GameConstants.LEGION);
		assertNotNull("The position (4, 1) should be blue city", c);
		
		//do the attack!
		assertFalse("should be false", game.attackUnit(from, to));
		assertNotNull("The blue legion is not defeated", blueLegion);
		assertEquals("The blue legion is blue", blueLegion.getOwner(), Player.BLUE);
		assertNull("The red archer is dead", game.getUnitAt(from));
	}
	
	@Test
	public void attackThreeTimesAndWin() {
		Position from = new Position(3, 3);
		Position to = new Position(4, 3);
		//do the attack!
		assertTrue("should be true", game.attackUnit(from, to));
		assertNull("No winner yet", game.getWinner());
		
		Position from1 = new Position(3, 2);
		Position to1 = new Position(2, 0);
		//do the attack!
		assertTrue("should be true", game.attackUnit(from1, to1));
		assertNull("No winner yet", game.getWinner());
		
		Position from2 = new Position(4, 1);
		Position to2 = new Position(1 ,0);
		//do the attack!
		assertTrue("should be true", game.attackUnit(from2, to2));
		assertEquals("The winner is blue", game.getWinner(), Player.BLUE);
	}
}
