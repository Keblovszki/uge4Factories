package hotciv.strategies;

import hotciv.framework.*;
import hotciv.standard.GameImpl;


public interface UnitActionStrategy {

	public void performUnitActionAt(Unit unit, Position p);
	public void setGame(GameImpl game);
	
}
