package hotciv.strategies;

import hotciv.framework.*;
import hotciv.standard.GameImpl;
import hotciv.different.*;

public interface AttackingStrategy {
	
	public boolean resultOfTheAttack(Position attackersPosition, Position defendersPosition);
	public void setUp(GameImpl game);
}
