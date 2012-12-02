package hotciv.different;

import hotciv.framework.*;
import hotciv.standard.*;
import hotciv.strategies.UnitActionStrategy;

public class GammaUnitActionStrategy implements UnitActionStrategy {
	private Game game;

	public GammaUnitActionStrategy(Game game) {
		this.game = game;
	}

	@Override
	public void performUnitActionAt(Unit unit, Position p) {
		Player owner = this.game.getUnitAt(p).getOwner();

		// The archer fortifies..
		if (unit.getTypeString().equals(GameConstants.ARCHER)) {
			if (unit.isNotArcherFortify()) {
				unit.increaseBonusDefenseStrength(unit.getDefensiveStrength());
				unit.setIsNotFortify(false);
			} else {
				unit.increaseBonusDefenseStrength(-(unit.getDefensiveStrength() / 2));
				unit.setIsNotFortify(true);
			}
		}

		// Settler builds the city..
		if (unit.getTypeString().equals(GameConstants.SETTLER)) {
			this.game.removeUnit(p);
			this.game.addCity(p, owner);
		}
	}

	public void setGame(GameImpl game) {
		this.game = game;
	}
}
