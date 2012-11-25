package hotciv.standard;

import static org.junit.Assert.*;
import hotciv.different.*;
import hotciv.framework.*;

import org.junit.Before;
import org.junit.Test;

public class TestEpsilonCiv {
	private Game game;
	
	@Before
	public void SetUp() {
		game = new GameImpl(
				new AlphaWorldAgingStrategy(),
				new EpsilonWinnerStrategy(),
				new AlphaUnitActionStrategy(), 
				new TestWorldLayoutStrategy(),
				new EpsilonAttackStrategy() );
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
		game.attackUnit(from, to);
		assertNull("The 'from' position should be null", from);
		assertEquals("The 'to' position should be the redArcher", game.getUnitAt(to).getTypeString(), GameConstants.ARCHER);
	}
}
