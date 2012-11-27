package hotciv.standard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import hotciv.factories.ZetaFactory;
import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.Position;

import org.junit.Before;
import org.junit.Test;

public class TestZetaCiv {
	private Game game;
	
	@Before
	public void SetUp() {
		game = new GameImpl( new ZetaFactory() );
	}
	
	@Test
	public void noWinner() {
		assertNull("No winner yet", game.getWinner());
	}
	
	@Test
	public void theWinnerShouldBeRedIfRedHasAllTheCities() {
		game.moveUnit(new Position(4, 1), new Position(0, 4));
		game.moveUnit(new Position(2, 1), new Position(4, 1));
		assertEquals("Red should be the winner", game.getWinner(), Player.RED);
	}
	
	@Test
	public void blueWinnerBetaWinner() {
		// runs the first 10 rounds
					for (int i = 0; i < 20; i++) {
						game.endOfTurn();
					} 
		
		game.moveUnit(new Position(3, 2), new Position(1, 1));
		assertEquals("Blue winner", game.getWinner(), Player.BLUE);
	}
	
	@Test
	public void attackThreeTimesAndDontWinBeta() {
		Position from = new Position(3, 3);
		Position to = new Position(4, 3);
		//do the 1. attack!
		assertTrue("should be true", game.attackUnit(from, to));
		assertNull("No winner yet", game.getWinner());
		
		Position from1 = new Position(3, 2);
		Position to1 = new Position(2, 0);
		//do the 2. attack!
		assertTrue("should be true", game.attackUnit(from1, to1));
		assertNull("No winner yet", game.getWinner());
		
		Position from2 = new Position(4, 1);
		Position to2 = new Position(1 ,0);
		//do the 3. attack!
		assertTrue("should be true", game.attackUnit(from2, to2));
		assertNull("Still no winner", game.getWinner());
	}
	
	@Test
	public void attackThreeTimesAndWinEpsilon() {
		// runs the first 20 rounds
			for (int i = 0; i < 40; i++) {
				game.endOfTurn();
			}
		
		Position from = new Position(3, 3);
		Position to = new Position(4, 3);
		//do the 1. attack!
		assertTrue("should be true", game.attackUnit(from, to));
		assertNull("No winner yet", game.getWinner());
		
		Position from1 = new Position(3, 2);
		Position to1 = new Position(2, 0);
		//do the 2. attack!
		assertTrue("should be true", game.attackUnit(from1, to1));
		assertNull("No winner yet", game.getWinner());
		
		//If Red take Blue city it doesn't win
		game.moveUnit(new Position(2, 1), new Position(4, 1));
		assertNull("Red don't win", game.getWinner());
		
		Position from2 = new Position(4, 1);
		Position to2 = new Position(1 ,0);
		//do the 3. attack!
		assertTrue("should be true", game.attackUnit(from2, to2));
		assertEquals("The winner should be Blue", game.getWinner(), Player.BLUE);
		
	}
	
}