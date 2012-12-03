package hotciv.different;

import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.framework.Tile;
import hotciv.standard.UnitImpl;
import hotciv.strategies.ProductionStrategy;

import java.util.ArrayList;
import java.util.HashMap;

public class EtaProductionStrategy implements ProductionStrategy {
	
	private Game game;
	private HashMap<String, Integer> mapTilesAroundCity;
	private int plainsCount = 0;
	private int oceanCount = 0;
	private int hillCount = 0;
	private int mountainCount = 0;
	private int forestCount = 0;

	
	public EtaProductionStrategy(Game game) {
		setMapTilesAroundCity(new HashMap<String, Integer>());
		getMapTilesAroundCity().put(GameConstants.PLAINS, plainsCount);
		getMapTilesAroundCity().put(GameConstants.FOREST, forestCount);
		getMapTilesAroundCity().put(GameConstants.OCEANS, oceanCount);
		getMapTilesAroundCity().put(GameConstants.MOUNTAINS, mountainCount);
		getMapTilesAroundCity().put(GameConstants.HILLS, hillCount);
		
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
		
		for (Tile tile : tilesAroundCity) {
			if (tile.getTypeString() == GameConstants.PLAINS) {
				plainsCount += 1;
				getMapTilesAroundCity().put(GameConstants.PLAINS, plainsCount);
			}
			else if (tile.getTypeString() == GameConstants.OCEANS) {
				oceanCount += 1;
				getMapTilesAroundCity().put(GameConstants.OCEANS, oceanCount);
			}
			else if (tile.getTypeString() == GameConstants.MOUNTAINS) {
				mountainCount += 1;
				getMapTilesAroundCity().put(GameConstants.OCEANS, mountainCount);
			}
			else if (tile.getTypeString() == GameConstants.HILLS) {
				hillCount += 1;
				getMapTilesAroundCity().put(GameConstants.OCEANS, hillCount);
			}
			else if (tile.getTypeString() == GameConstants.FOREST) {
				forestCount += 1;
				getMapTilesAroundCity().put(GameConstants.OCEANS, forestCount);
			}
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
	
	public HashMap<String, Integer> getMapTilesAroundCity() {
		return mapTilesAroundCity;
	}

	public void setMapTilesAroundCity(HashMap<String, Integer> mapTilesAroundCity) {
		this.mapTilesAroundCity = mapTilesAroundCity;
	}

}
