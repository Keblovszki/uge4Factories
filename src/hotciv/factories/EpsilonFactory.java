package hotciv.factories;

import hotciv.different.AlphaPopulationStrategy;
import hotciv.different.AlphaProductionStrategy;
import hotciv.different.AlphaUnitActionStrategy;
import hotciv.different.AlphaWorldAgingStrategy;
import hotciv.different.EpsilonAttackStrategy;
import hotciv.different.EpsilonWinnerStrategy;
import hotciv.different.TestWorldLayoutStrategy;
import hotciv.framework.Game;
import hotciv.standard.TestDice;
import hotciv.strategies.AttackingStrategy;
import hotciv.strategies.PopulationStrategy;
import hotciv.strategies.ProductionStrategy;
import hotciv.strategies.UnitActionStrategy;
import hotciv.strategies.WinnerStrategy;
import hotciv.strategies.WorldAgingStrategy;
import hotciv.strategies.WorldLayoutStrategy;

public class EpsilonFactory implements AbstractFactory {

	@Override
	public AttackingStrategy makeAttackStrategy(Game game) {
		return new EpsilonAttackStrategy(new TestDice(), game);
	}

	@Override
	public UnitActionStrategy makeUnitActionStrategy(Game game) {
		return new AlphaUnitActionStrategy(game);
	}

	@Override
	public WinnerStrategy makeWinnerStrategy(Game game) {
		return new EpsilonWinnerStrategy(game);
	}

	@Override
	public WorldAgingStrategy makeWorldAgingStrategy(Game game) {
		return new AlphaWorldAgingStrategy(game);
	}

	@Override
	public WorldLayoutStrategy makeWorldLayoutStrategy(Game game) {
		return new TestWorldLayoutStrategy(game);
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
