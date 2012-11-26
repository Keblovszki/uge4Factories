package hotciv.standard;

import static org.junit.Assert.*;
import hotciv.factories.ZetaFactory;
import hotciv.framework.*;

import org.junit.Before;
import org.junit.Test;

public class TestZetaCiv {
	private Game game;
	
	@Before
	public void SetUp() {
		game = new GameImpl( new ZetaFactory() );
	}
	
	@Test
	public void attackThreeTimesAndWin() {
		assertNull("No winner yet", game.getWinner());
	}
}