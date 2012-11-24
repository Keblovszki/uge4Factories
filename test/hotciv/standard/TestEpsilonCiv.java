package hotciv.standard;

import static org.junit.Assert.*;
import hotciv.different.AlphaUnitActionStrategy;
import hotciv.different.AlphaWorldAgingStrategy;
import hotciv.different.AlphaWorldLayoutStrategy;
import hotciv.different.EpsilonAttackStrategy;
import hotciv.different.EpsilonWinnerStrategy;
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
				new AlphaWorldLayoutStrategy(),
				new EpsilonAttackStrategy() );
	}
	
}
