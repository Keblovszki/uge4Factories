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
	private int foodProduction = 0;
	private int unitProduction = 0;

	public EtaProductionStrategy(Game game) {
		setMapTilesAroundCity(new HashMap<String, Integer>());
		mapTilesAroundCity.put(GameConstants.PLAINS, 0);
		mapTilesAroundCity.put(GameConstants.FOREST, 0);
		mapTilesAroundCity.put(GameConstants.OCEANS, 0);
		mapTilesAroundCity.put(GameConstants.MOUNTAINS, 0);
		mapTilesAroundCity.put(GameConstants.HILLS, 0);
		mapTilesAroundCity.put("CITY", 1);

		this.game = game;
	}

	public void makeTileMap(Position p) {
		final ArrayList<Position> postitionsAroundTheCity = p.getNeighbours();
		final ArrayList<Tile> tilesAroundCity = new ArrayList<Tile>();

		// add all tiles around the city to an ArrayList.
		for (Position currentPosition : postitionsAroundTheCity) {
			tilesAroundCity.add(game.getTileAt(currentPosition));
		}

		for (Tile tile : tilesAroundCity) {
			int count = mapTilesAroundCity.get(tile.getTypeString());
			count++;
			mapTilesAroundCity.put(tile.getTypeString(), count);
		}
	}
	
	public void calculateTheUnitProduction(City c) {
		int sizeOfCity = c.getSize();
		for (String tile : GameConstants.costList) {
			int count1 = mapTilesAroundCity.get(tile);
			for (int i = 0; i < count1; i++) {
				if (sizeOfCity > 0) {
					sizeOfCity --;
					unitProduction += GameConstants.costMap.get(tile);
				}
				else {
					break;
				}
			}
			c.setProductionSum(c.getProductionSum() + unitProduction);
		}
	}
	
	public void calculateTheFoodProduction(City c) {
		int sizeOfCity = c.getSize();
		for (String tile : GameConstants.foodList) {
			int count = mapTilesAroundCity.get(tile);
			for (int i = 0; i < count; i++) {
				if(sizeOfCity > 0) {
					sizeOfCity --;
					foodProduction += GameConstants.foodMap.get(tile);
				}
				else {
					break;
				}
			}
			c.setFoodProduction(c.getFoodProduction() + foodProduction);
		}
	}

	@Override
	public void createProductionInCityAt(Position p) {
		final ArrayList<Position> postitionsAroundTheCity = p.getNeighbours();
		makeTileMap(p);

		if (game.getMapCity().get(p) != null) {
			City c = game.getMapCity().get(p);
			if (c.getWorkforceFocus().equals(GameConstants.productionFocus)) {
				calculateTheUnitProduction(c);
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
			if (c.getWorkforceFocus().equals(GameConstants.foodFocus)) {
				calculateTheFoodProduction(c);
			}
		}
	}

	public HashMap<String, Integer> getMapTilesAroundCity() {
		return mapTilesAroundCity;
	}

	public void setMapTilesAroundCity(HashMap<String, Integer> mapTilesAroundCity) {
		this.mapTilesAroundCity = mapTilesAroundCity;
	}

	@Override
	public void doProductionSum() {
		//do nothing...
	}
}
