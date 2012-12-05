package hotciv.standard;

import hotciv.factories.AbstractFactory;
import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Tile;
import hotciv.framework.Unit;
import hotciv.strategies.AttackingStrategy;
import hotciv.strategies.PopulationStrategy;
import hotciv.strategies.ProductionStrategy;
import hotciv.strategies.UnitActionStrategy;
import hotciv.strategies.WinnerStrategy;
import hotciv.strategies.WorldAgingStrategy;
import hotciv.strategies.WorldLayoutStrategy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;


/**
 * Skeleton implementation of HotCiv.
 * 
 * This source code is from the book "Flexible, Reliable Software: Using
 * Patterns and Agile Development" published 2010 by CRC Press. Author: Henrik B
 * Christensen Computer Science Department Aarhus University
 * 
 * This source code is provided WITHOUT ANY WARRANTY either expressed or
 * implied. You may study, use, modify, and distribute it for non-commercial
 * purposes. For any commercial use, see http://www.baerbak.com/
 */

public class GameImpl implements Game {
	private Player playerInTurn = Player.RED;
	private int age = -4000;
	private HashMap<Position, City> mapCity;
	private HashMap<Position, Unit> mapUnit;
	private HashMap<Position, Tile> mapTile;
	public int attackConterRED = 0;
	public int attackCounterBLUE = 0;
	private WorldAgingStrategy worldAgingStrategy;
	private WinnerStrategy winnerStrategy;
	private UnitActionStrategy unitActionStrategy;
	private WorldLayoutStrategy worldLayoutStrategy;
	private AttackingStrategy attackingStrategy;
	private ProductionStrategy productionStrategy;
	private PopulationStrategy populationStrategy;
	private int round = 1;

	// Constructor
	public GameImpl(AbstractFactory abstractFactory) {
		setMapCity(new HashMap<Position, City>());
		setMapUnit(new HashMap<Position, Unit>());
		setMapTile(new HashMap<Position, Tile>());

		winnerStrategy = abstractFactory.makeWinnerStrategy(this);
		worldAgingStrategy = abstractFactory.makeWorldAgingStrategy(this);
		unitActionStrategy = abstractFactory.makeUnitActionStrategy(this);
		worldLayoutStrategy = abstractFactory.makeWorldLayoutStrategy(this);
		attackingStrategy = abstractFactory.makeAttackStrategy(this);
		productionStrategy = abstractFactory.makeProductionStrategy(this);
		populationStrategy = abstractFactory.makePopulationStrategy(this);

		getMapCity().putAll(worldLayoutStrategy.makeCityList());
		getMapUnit().putAll(worldLayoutStrategy.makeUnitList());
		getMapTile().putAll(worldLayoutStrategy.makeTileList());
	}

	@Override
	public Tile getTileAt(Position p) {
		return getMapTile().get(p);
	}

	@Override
	public Unit getUnitAt(Position p) {
		return getMapUnit().get(p);
	}

	@Override
	public City getCityAt(Position p) {
		return getMapCity().get(p);
	}

	@Override
	public Player getPlayerInTurn() {
		return playerInTurn;
	}

	@Override
	public Player getWinner() {
		// winnerStrategy.setGame(this);
		return this.winnerStrategy.winner();
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public boolean moveUnit(Position from, Position to) {
		// Moves your unit
		if (getMapUnit().get(to) != null) {
			return false;
		}
		if (getMapUnit().get(from).isNotArcherFortify() == false) {
			return false;
		}
		getMapUnit().put(to, getMapUnit().get(from));
		getMapUnit().remove(from);
		if (getMapCity().get(to) != null) {
			if (getMapCity().get(to).getOwner() == getMapUnit().get(to).getOwner()) {
				return true;
			} else {
				getMapCity().get(to).setOwner(getMapUnit().get(to).getOwner());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean attackUnit(Position from, Position to) {
		if (getMapUnit().get(to) != null) {
			boolean rota = this.attackingStrategy.resultOfTheAttack(from, to);
			if (rota == true) {
				if (getUnitAt(to).getOwner() == Player.RED) {
					attackConterRED += 1;
				}
				if (getUnitAt(to).getOwner() == Player.BLUE) {
					attackCounterBLUE += 1;
				}
			}
			return rota;
		}
		return false;
	}

	public int countWins(Player p) {
		if (p == Player.RED) {
			return attackConterRED;
		} else {
			return attackCounterBLUE;
		}
	}

	@Override
	public void endOfTurn() {
		if (playerInTurn == Player.RED) {
			playerInTurn = Player.BLUE;
		} else {
			age = worldAgingStrategy.worldAging(age);
			playerInTurn = Player.RED;
			for(Entry<Position, City> entry : mapCity.entrySet()){
				Position p = entry.getKey();
				productionStrategy.createProductionInCityAt(p);
				populationStrategy.increasePopulation(p);
			}
			round += 1;
		}
	}

	public int getRounds() {
		return round;
	}

	public void resetAttacks() {
		attackConterRED = 0;
		attackCounterBLUE = 0;
	}

	@Override
	public void changeWorkForceFocusInCityAt(Position p, String balance) {
		getMapCity().get(p).setWorkforceFocus(balance);
	}

	@Override
	public void changeProductionInCityAt(Position p, String unitType) {
		getMapCity().get(p).setProduction(unitType);
	}

	@Override
	public void performUnitActionAt(Position p) {
		Unit u = getMapUnit().get(p);
		unitActionStrategy.performUnitActionAt(u, p);
	}

	@Override
	public void createProductionInCityAt(Position p) {
		productionStrategy.createProductionInCityAt(p);
	}

	public void removeUnit(Position p) {
		getMapUnit().remove(p);
	}

	@Override
	public void addCity(Position p, Player owner) {
		getMapCity().put(p, new CityImpl(owner));
	}

	@Override
	public Collection<City> getAllCities() {
		return getMapCity().values();
	}

	@Override
	public HashMap<Position, City> getMapCity() {
		return mapCity;
	}

	@Override
	public void setMapCity(HashMap<Position, City> mapCity) {
		this.mapCity = mapCity;
	}

	@Override
	public HashMap<Position, Unit> getMapUnit() {
		return mapUnit;
	}

	@Override
	public void setMapUnit(HashMap<Position, Unit> mapUnit) {
		this.mapUnit = mapUnit;
	}

	@Override
	public HashMap<Position, Tile> getMapTile() {
		return mapTile;
	}

	@Override
	public void setMapTile(HashMap<Position, Tile> mapTile) {
		this.mapTile = mapTile;
	}
}
