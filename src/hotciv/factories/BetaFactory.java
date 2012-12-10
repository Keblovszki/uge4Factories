package hotciv.factories;

import hotciv.different.AlphaAttackStrategy;
import hotciv.different.AlphaPopulationStrategy;
import hotciv.different.AlphaProductionStrategy;
import hotciv.different.AlphaUnitActionStrategy;
import hotciv.different.AlphaWorldLayoutStrategy;
import hotciv.different.BetaWinnerStrategy;
import hotciv.different.BetaWorldAgingStrategy;
import hotciv.framework.Game;
import hotciv.strategies.AttackingStrategy;
import hotciv.strategies.PopulationStrategy;
import hotciv.strategies.ProductionStrategy;
import hotciv.strategies.UnitActionStrategy;
import hotciv.strategies.WinnerStrategy;
import hotciv.strategies.WorldAgingStrategy;
import hotciv.strategies.WorldLayoutStrategy;

public class BetaFactory implements AbstractFactory {

	@Override
	public AttackingStrategy makeAttackStrategy(Game game) {
		return new AlphaAttackStrategy(game);
	}

	@Override
	public UnitActionStrategy makeUnitActionStrategy(Game game) {
		return new AlphaUnitActionStrategy(game);
	}

	@Override
	public WinnerStrategy makeWinnerStrategy(Game game) {
		return new BetaWinnerStrategy(game);
	}

	@Override
	public WorldAgingStrategy makeWorldAgingStrategy(Game game) {
		return new BetaWorldAgingStrategy(game);
	}

	@Override
	public WorldLayoutStrategy makeWorldLayoutStrategy(Game game) {
		return new AlphaWorldLayoutStrategy(game);
	}
	
	@Override
	public ProductionStrategy makeProductionStrategy(Game game) {
		return new AlphaProductionStrategy(game);
	}

	@Override
	public PopulationStrategy makePopulationStrategy(Game game) {
		return new AlphaPopulationStrategy();
	}

}
