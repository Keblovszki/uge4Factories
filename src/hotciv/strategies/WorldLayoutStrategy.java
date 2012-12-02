package hotciv.strategies;

import hotciv.framework.City;
import hotciv.framework.Position;
import hotciv.framework.Tile;
import hotciv.framework.Unit;

import java.util.HashMap;

public interface WorldLayoutStrategy {
	
	public HashMap<Position, Unit> makeUnitList();
	
	public HashMap<Position, City> makeCityList();
	
	public HashMap<Position, Tile> makeTileList();

}
