package hotciv.factories;

import hotciv.different.AlphaPopulationStrategy;
import hotciv.different.BetaWorldAgingStrategy;
import hotciv.different.DeltaWorldLayoutStrategy;
import hotciv.different.EpsilonAttackStrategy;
import hotciv.different.EpsilonWinnerStrategy;
import hotciv.different.EtaProductionStrategy;
import hotciv.different.GammaUnitActionStrategy;
import hotciv.framework.Game;
import hotciv.standard.TestDice;
import hotciv.strategies.AttackingStrategy;
import hotciv.strategies.PopulationStrategy;
import hotciv.strategies.ProductionStrategy;
import hotciv.strategies.UnitActionStrategy;
import hotciv.strategies.WinnerStrategy;
import hotciv.strategies.WorldAgingStrategy;
import hotciv.strategies.WorldLayoutStrategy;

public class SemiCivFactory implements AbstractFactory {

	@Override
	public AttackingStrategy makeAttackStrategy(Game game) {
		return new EpsilonAttackStrategy(new TestDice(), game);
	}

	@Override
	public UnitActionStrategy makeUnitActionStrategy(Game game) {
		return new GammaUnitActionStrategy(game);
	}

	@Override
	public WinnerStrategy makeWinnerStrategy(Game game) {
		return new EpsilonWinnerStrategy(game);
	}

	@Override
	public WorldAgingStrategy makeWorldAgingStrategy(Game game) {
		return new BetaWorldAgingStrategy(game);
	}

	@Override
	public WorldLayoutStrategy makeWorldLayoutStrategy(Game game) {
		return new DeltaWorldLayoutStrategy(game);
	}
	
	@Override
	public ProductionStrategy makeProductionStrategy(Game game) {
		return new EtaProductionStrategy(game);
	}

	@Override
	public PopulationStrategy makePopulationStrategy(Game game) {
		return new AlphaPopulationStrategy();
	}

}
