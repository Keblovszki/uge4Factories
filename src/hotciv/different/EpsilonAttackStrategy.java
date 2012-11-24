package hotciv.different;

import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.standard.AttackingStrategy;
import hotciv.standard.GameImpl;

public class EpsilonAttackStrategy implements AttackingStrategy {

	@Override
	public boolean resultOfTheAttack(GameImpl game, Position attackersPosition, Position defendersPosition) {
		return false;
	}
	
	public void setUp(GameImpl game) {
		
	}
}
