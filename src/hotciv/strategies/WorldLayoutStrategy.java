package hotciv.strategies;

import hotciv.framework.Position;
import hotciv.standard.CityImpl;
import hotciv.standard.TileImpl;
import hotciv.standard.UnitImpl;

import java.util.HashMap;

public interface WorldLayoutStrategy {
	
	public HashMap<Position, UnitImpl> makeUnitList();
	
	public HashMap<Position, CityImpl> makeCityList();
	
	public HashMap<Position, TileImpl> makeTileList();

}
