package hotciv.standard;

import hotciv.framework.*;
import hotciv.different.*;

public interface AttackingStrategy {
	
	public boolean resultOfTheAttack(GameImpl game, Position attackersPosition, Position defendersPosition);
	public void setUp(GameImpl game);
}
