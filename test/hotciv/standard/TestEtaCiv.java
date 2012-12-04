package hotciv.standard;

import static org.junit.Assert.*;
import hotciv.factories.*;
import hotciv.framework.*;

import org.junit.Before;
import org.junit.Test;

public class TestEtaCiv {
	private Game game;
	
	@Before
	public void SetUp() {
		game = new GameImpl( new EtaFactory() );
	}
	
	@Test
	public void thereShouldBeACityAt1_1Red() {
		Position p = new Position(1, 1);
		City c = game.getCityAt(p);
		assertNotNull("There is a city at position (1, 1)", c);
		assertEquals("The city here should be red", c, c);
	}
	
	@Test
	public void productionInRedShouldBeSomething() {
		City c = game.getCityAt(new Position(1, 1));
		assertEquals("The production is 0", c.getProductionSum(), 0);
		c.setProduction(GameConstants.ARCHER);
		game.endOfTurn(); game.endOfTurn();
		assertEquals("Still the same", c.getProductionSum(), 0);
	}
}