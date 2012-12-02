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

public class DeltaWorldLayoutStrategy implements WorldLayoutStrategy {
	private Game game;

	public DeltaWorldLayoutStrategy(Game game) {
		this.game = game;
	}

	public HashMap<Position, Unit> makeUnitList() {
		HashMap<Position, Unit> mapUnit = new HashMap<Position, Unit>();

		mapUnit.put(new Position(3, 8), new UnitImpl(Player.BLUE, GameConstants.ARCHER, game));
		mapUnit.put(new Position(4, 4), new UnitImpl(Player.BLUE, GameConstants.LEGION, game));
		mapUnit.put(new Position(5, 5), new UnitImpl(Player.BLUE, GameConstants.SETTLER, game));
		return mapUnit;
	}

	public HashMap<Position, City> makeCityList() {
		HashMap<Position, City> mapCity = new HashMap<Position, City>();

		mapCity.put(new Position(8, 12), new CityImpl(Player.RED));
		mapCity.put(new Position(4, 5), new CityImpl(Player.BLUE));
		return mapCity;
	}

	public HashMap<Position, Tile> makeTileList() {
		HashMap<Position, Tile> mapTile = new HashMap<Position, Tile>();

		String[] layout;
		layout = new String[] { 
				"...ooMooooo.....", 
				"..ohhoooofffoo..", 
				".oooooMooo...oo.", 
				".ooMMMoooo..oooo",
				"...ofooohhoooo..", 
				".ofoofooooohhoo.", 
				"...ooo..........", 
				".ooooo.ooohooM..", 
				".ooooo.oohooof..",
				"offfoooo.offoooo",
				"oooooooo...ooooo",
				".ooMMMoooo......",
				"..ooooooffoooo..",
				"....ooooooooo...",
				"..ooohhoo.......",
				".....ooooooooo..", };
		String line;
		for (int r = 0; r < GameConstants.WORLDSIZE; r++) {
			line = layout[r];
			for (int c = 0; c < GameConstants.WORLDSIZE; c++) {
				char tileChar = line.charAt(c);
				String type = "error";
				if (tileChar == '.') {
					type = GameConstants.OCEANS;
				}
				if (tileChar == 'o') {
					type = GameConstants.PLAINS;
				}
				if (tileChar == 'M') {
					type = GameConstants.MOUNTAINS;
				}
				if (tileChar == 'f') {
					type = GameConstants.FOREST;
				}
				if (tileChar == 'h') {
					type = GameConstants.HILLS;
				}
				Position p = new Position(r, c);
				mapTile.put(p, new TileImpl(p, type));
			}
		}
		return mapTile;
	}
}
