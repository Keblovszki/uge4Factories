package hotciv.different;

import java.util.ArrayList;

import hotciv.framework.*;
import hotciv.standard.*;

public class EpsilonAttackStrategy implements AttackingStrategy {
	private Game game;
	
	@Override
	public boolean resultOfTheAttack(GameImpl game, Position attackersPosition, Position defendersPosition) {
		
		int attackStrength = game.getUnitAt(attackersPosition).getAttackingStrength();
		int defenseStrength = game.getUnitAt(defendersPosition).getDefensiveStrength();
		
		attackStrength = (attackStrength + bonusFromUnitsAround(attackersPosition))*bonusFromTerrain(attackersPosition);
		defenseStrength = (defenseStrength + bonusFromUnitsAround(defendersPosition))*bonusFromTerrain(defendersPosition);
				
		return (attackStrength > defenseStrength);
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
