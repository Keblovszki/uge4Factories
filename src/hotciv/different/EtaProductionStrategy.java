package hotciv.different;

import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.framework.Tile;
import hotciv.standard.UnitImpl;
import hotciv.strategies.ProductionStrategy;

import java.util.ArrayList;

public class EtaProductionStrategy implements ProductionStrategy {
	
	private Game game;
	
	public EtaProductionStrategy(Game game) {
		this.game = game;
	}

	@Override
	public void createProductionInCityAt(Position p) {
		final ArrayList<Position> postitionsAroundTheCity = p.getNeighbours();
		final ArrayList<Tile> tilesAroundCity = new ArrayList<Tile>();
		
		//add all tiles around the city to an ArrayList.
		for (Position currentPosition : postitionsAroundTheCity) {
			tilesAroundCity.add(game.getTileAt(currentPosition));
		}
		
		// Archer costs 10 production
		// Legions costs 15 production
		// Settler costs 30 production
		if (game.getMapCity().get(p) != null) {
			City c = game.getMapCity().get(p);
			if (c.getWorkforceFocus() == GameConstants.productionFocus) {
				if (c.getProductionSum() >= GameConstants.costMap.get(c.getProduction())) {
					for (Position currentPosition : postitionsAroundTheCity) {
						if (game.getMapUnit().get(currentPosition) == null) {
							game.getMapUnit().put(currentPosition, new UnitImpl(c.getOwner(), c.getProduction(), game));
							break;
						}
					}
					c.setProductionSum(-GameConstants.costMap.get(c.getProduction()));
				}
			}
			if (c.getWorkforceFocus() == GameConstants.foodFocus) {
				if(tilesAroundCity.contains(GameConstants.PLAINS)) {
					
				}
			}
		}
	}

}
