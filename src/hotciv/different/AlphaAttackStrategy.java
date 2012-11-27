package hotciv.different;

import hotciv.framework.*;
import hotciv.standard.*;
import hotciv.strategies.AttackingStrategy;

public class AlphaAttackStrategy implements AttackingStrategy{
	private GameImpl game;
	
	@Override
	public boolean resultOfTheAttack(Position attackersPosition, Position defendersPosition) {
		if(game.mapUnit.get(attackersPosition).isNotArcherFortify() == false) {
			return false;
		}
		else{
			game.mapUnit.remove(defendersPosition);
			game.mapUnit.put(defendersPosition, game.mapUnit.get(attackersPosition) );
			game.mapUnit.remove(attackersPosition);
			if(game.mapCity.get(defendersPosition) != null ) {
				if(game.mapCity.get(defendersPosition).getOwner() == game.mapUnit.get(defendersPosition).getOwner()) {
					return true;
				}
				else {
					game.mapCity.get(defendersPosition).setOwner(game.mapUnit.get(defendersPosition).getOwner());
					return true;
				}
			}
		}
		return true;
	}
	
	public void setUp(GameImpl game) {
		this.game = game;
	}
}
