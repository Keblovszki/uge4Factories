package hotciv.factories;

import hotciv.framework.Game;
import hotciv.strategies.AttackingStrategy;
import hotciv.strategies.PopulationStrategy;
import hotciv.strategies.ProductionStrategy;
import hotciv.strategies.UnitActionStrategy;
import hotciv.strategies.WinnerStrategy;
import hotciv.strategies.WorldAgingStrategy;
import hotciv.strategies.WorldLayoutStrategy;

public interface AbstractFactory {

	public AttackingStrategy makeAttackStrategy(Game game);
	
	public UnitActionStrategy makeUnitActionStrategy(Game game);
	
	public WinnerStrategy makeWinnerStrategy(Game game);
	
	public WorldAgingStrategy makeWorldAgingStrategy(Game game);
	
	public WorldLayoutStrategy makeWorldLayoutStrategy(Game game);
	
	public ProductionStrategy makeProductionStrategy(Game game);
	
	public PopulationStrategy makePopulationStrategy(Game game);
	
}
