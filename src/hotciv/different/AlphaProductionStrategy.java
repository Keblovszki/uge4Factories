package hotciv.different;

import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.standard.UnitImpl;
import hotciv.strategies.ProductionStrategy;

import java.util.ArrayList;

public class AlphaProductionStrategy implements ProductionStrategy {

	private Game game;

	public AlphaProductionStrategy(Game game) {
		this.game = game;
	}

	public void createProductionInCityAt(Position p) {
		final ArrayList<Position> postitionsAroundTheCity = p.getNeighbours();
		// Archer costs 10 production
		// Legions costs 15 production
		// Settler costs 30 production
		if (game.getMapCity().get(p) != null) {
			City c = game.getMapCity().get(p);
			c.doProductionSum();
			if (c.getProduction() != null && c.getProductionSum() >= GameConstants.costMap.get(c.getProduction())) {
				for (Position currentPosition : postitionsAroundTheCity) {
					if (game.getMapUnit().get(currentPosition) == null) {
						game.getMapUnit().put(currentPosition, new UnitImpl(c.getOwner(), c.getProduction(), game));
						break;
					}
				}
				c.setProductionSum(- GameConstants.costMap.get(c.getProduction()));
			}
		}
	}
}
