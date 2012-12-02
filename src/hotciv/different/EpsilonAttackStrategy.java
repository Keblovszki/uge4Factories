package hotciv.different;

import hotciv.framework.City;
import hotciv.framework.Dice;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Unit;
import hotciv.strategies.AttackingStrategy;

import java.util.ArrayList;

public class EpsilonAttackStrategy implements AttackingStrategy {
	private Game game;
	private Dice dice;
	
	public EpsilonAttackStrategy(Dice awesomeDice, Game game) {
		dice = awesomeDice;
		this.game = game;
	}
		
	@Override
	public boolean resultOfTheAttack(Position attackersPosition, Position defendersPosition) {
		
		int attackStrength = game.getUnitAt(attackersPosition).getAttackingStrength();
		int defenseStrength = game.getUnitAt(defendersPosition).getDefensiveStrength();
		
		attackStrength = (attackStrength + bonusFromUnitsAround(attackersPosition))*bonusFromTerrain(attackersPosition)*dice.rollDice();
		defenseStrength = (defenseStrength + bonusFromUnitsAround(defendersPosition))*bonusFromTerrain(defendersPosition)*dice.rollDice();
				
		boolean theAttackersResult = (attackStrength > defenseStrength);
		if(theAttackersResult == true) {
			game.getMapUnit().remove(defendersPosition);
			game.getMapUnit().put(defendersPosition, game.getMapUnit().get(attackersPosition));
			game.getMapUnit().remove(attackersPosition);
			return true;
		}
		else {
			game.getMapUnit().remove(attackersPosition);
			return false;
		}
	}
	
	public int bonusFromUnitsAround(Position p) {
		final ArrayList<Unit> allUnitsAround = game.getUnitAt(p).getUnitsAround(p);
		int bonusFromAround = 0;
		
		Player attackingPlayer = game.getUnitAt(p).getOwner();
		for(Unit u : allUnitsAround) {
			if(u.getOwner() == attackingPlayer) {
				bonusFromAround += 1;
			}
		}

		return bonusFromAround;
	}
	
	public int bonusFromTerrain(Position p) {
		//If your unit is at a city they will be owned by the same player..
		City c = game.getCityAt(p);
		if(c != null) {
			return 3;
		}
		if(game.getTileAt(p).equals(GameConstants.FOREST) || game.getTileAt(p).equals(GameConstants.HILLS)) {
			return 2;
		}
		return 1;
	}
}
