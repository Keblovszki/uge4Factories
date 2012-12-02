package hotciv.different;

import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.framework.Unit;
import hotciv.standard.GameImpl;
import hotciv.strategies.UnitActionStrategy;

public class AlphaUnitActionStrategy implements UnitActionStrategy {
	@SuppressWarnings("unused")
	private Game game;

	public AlphaUnitActionStrategy(Game game) {
		this.game = game;
	}
	
	@Override
	public void performUnitActionAt(Unit unit, Position p) {
		//There should be nothing in here because AlphaCiv say so..
	}

	@Override
	public void setGame(GameImpl game) {
		
	}

}
