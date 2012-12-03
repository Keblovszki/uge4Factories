package hotciv.factories;

import hotciv.different.AlphaAttackStrategy;
import hotciv.different.AlphaProductionStrategy;
import hotciv.different.AlphaUnitActionStrategy;
import hotciv.different.AlphaWinnerStrategy;
import hotciv.different.AlphaWorldAgingStrategy;
import hotciv.different.AlphaWorldLayoutStrategy;
import hotciv.framework.Game;
import hotciv.strategies.AttackingStrategy;
import hotciv.strategies.ProductionStrategy;
import hotciv.strategies.UnitActionStrategy;
import hotciv.strategies.WinnerStrategy;
import hotciv.strategies.WorldAgingStrategy;
import hotciv.strategies.WorldLayoutStrategy;

public class AlphaFactory implements AbstractFactory {

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
		return new AlphaWinnerStrategy(game);
	}

	@Override
	public WorldAgingStrategy makeWorldAgingStrategy(Game game) {
		return new AlphaWorldAgingStrategy(game);
	}

	@Override
	public WorldLayoutStrategy makeWorldLayoutStrategy(Game game) {
		return new AlphaWorldLayoutStrategy(game);
	}
	
	@Override
	public ProductionStrategy makeProductionStrategy(Game game) {
		return new AlphaProductionStrategy(game);
	}
}
