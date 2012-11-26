package hotciv.standard;

import static org.junit.Assert.*;
import hotciv.different.*;
import hotciv.framework.*;

import org.junit.Before;
import org.junit.Test;

public class TestZetaCiv {
	private Game game;
	
	@Before
	public void SetUp() {
		game = new GameImpl(
				new AlphaWorldAgingStrategy(),
				new ZetaWinnerStrategy(),
				new AlphaUnitActionStrategy(), 
				new TestWorldLayoutStrategy(),
				new AlphaAttackStrategy() );
	}
}