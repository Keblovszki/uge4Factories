package hotciv.strategies;

import hotciv.framework.Position;

public interface AttackingStrategy {

	public boolean resultOfTheAttack(Position attackersPosition, Position defendersPosition);
	
}
