package hotciv.different;

import java.util.*;


import hotciv.framework.*;
import hotciv.standard.*;
import hotciv.strategies.AttackingStrategy;

public class EpsilonAttackStrategy implements AttackingStrategy {
	private GameImpl game;
	private Dice dice;
	
	public EpsilonAttackStrategy(Dice awesomeDice) {
		dice = awesomeDice;
	}
		
	@Override
	public boolean resultOfTheAttack(Position attackersPosition, Position defendersPosition) {
		
		int attackStrength = game.getUnitAt(attackersPosition).getAttackingStrength();
		int defenseStrength = game.getUnitAt(defendersPosition).getDefensiveStrength();
		
		attackStrength = (attackStrength + bonusFromUnitsAround(attackersPosition))*bonusFromTerrain(attackersPosition)*dice.rollDice();
		defenseStrength = (defenseStrength + bonusFromUnitsAround(defendersPosition))*bonusFromTerrain(defendersPosition)*dice.rollDice();
				
		boolean theAttackersResult = (attackStrength > defenseStrength);
		if(theAttackersResult == true) {
			game.mapUnit.remove(defendersPosition);
			game.mapUnit.put(defendersPosition, game.mapUnit.get(attackersPosition));
			game.mapUnit.remove(attackersPosition);
			return true;
		}
		else {
			game.mapUnit.remove(attackersPosition);
			return false;
		}
	}
	
	public int bonusFromUnitsAround(Position p) {
		ArrayList<Unit> AllUnitsAround = new ArrayList<Unit>();
		int bonusFromAround = 0;
		Unit N = game.getUnitAt(p.getNorth(p));
		Unit NE = game.getUnitAt(p.getNorthEast(p));
		Unit NW = game.getUnitAt(p.getNorthWest(p));
		Unit W = game.getUnitAt(p.getWest(p));
		Unit E = game.getUnitAt(p.getEast(p));
		Unit SW = game.getUnitAt(p.getSouthWest(p));
		Unit SE = game.getUnitAt(p.getSouthEast(p));
		Unit S = game.getUnitAt(p.getSouth(p));
		
		if(N != null) {
			AllUnitsAround.add(N);
		}
		if(NW != null) {
			AllUnitsAround.add(NW);
		}
		if(NE != null) {
			AllUnitsAround.add(NE);
		}
		if(E != null) {
			AllUnitsAround.add(E);
		}
		if(W != null) {
			AllUnitsAround.add(W);
		}
		if(S != null) {
			AllUnitsAround.add(S);
		}
		if(SE != null) {
			AllUnitsAround.add(SE);
		}
		if(SW != null) {
			AllUnitsAround.add(SW);
		}
		
		Player attackingPlayer = game.getUnitAt(p).getOwner();
		for(Unit u : AllUnitsAround) {
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
	
	public void setUp(GameImpl game) {
		this.game = game;
	}
}
