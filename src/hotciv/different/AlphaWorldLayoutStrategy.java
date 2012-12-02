package hotciv.different;

import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Tile;
import hotciv.framework.Unit;
import hotciv.standard.CityImpl;
import hotciv.standard.TileImpl;
import hotciv.standard.UnitImpl;
import hotciv.strategies.WorldLayoutStrategy;

import java.util.HashMap;


public class AlphaWorldLayoutStrategy implements WorldLayoutStrategy {
	
	private Game game;
	
	public AlphaWorldLayoutStrategy(Game game) {
		this.game = game;
	}

	public HashMap<Position, Unit> makeUnitList() {
		HashMap<Position, Unit> mapUnit = new HashMap<Position, Unit>();
		
		mapUnit.put(new Position(2, 0), new UnitImpl(Player.RED, GameConstants.ARCHER, game) );
		mapUnit.put(new Position(3, 2), new UnitImpl(Player.BLUE, GameConstants.LEGION, game) );
		mapUnit.put(new Position(4, 3), new UnitImpl(Player.RED, GameConstants.SETTLER, game) );
		return mapUnit;
	}
	
	public HashMap<Position, City> makeCityList() {
		HashMap<Position, City> mapCity = new HashMap<Position, City>();
		
		mapCity.put(new Position(1, 1), new CityImpl(Player.RED));
		mapCity.put(new Position(4, 1), new CityImpl(Player.BLUE));
		return mapCity;
	}
	
	public HashMap<Position, Tile> makeTileList() {
		HashMap<Position, Tile> mapTile = new HashMap<Position, Tile>();

		for(int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				mapTile.put(new Position(i, j), new TileImpl(new Position(i, j), GameConstants.PLAINS));
			}
		}
		mapTile.put(new Position(1, 0), new TileImpl(new Position (1, 0), GameConstants.OCEANS));
		mapTile.put(new Position(0, 1), new TileImpl(new Position (0, 1), GameConstants.HILLS));
		mapTile.put(new Position(2, 2), new TileImpl(new Position (2, 2), GameConstants.MOUNTAINS));
		
		return mapTile;
	}
	
}
