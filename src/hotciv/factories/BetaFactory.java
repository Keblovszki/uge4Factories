package hotciv.factories;

import hotciv.different.AlphaAttackStrategy;
import hotciv.different.AlphaUnitActionStrategy;
import hotciv.different.AlphaWorldLayoutStrategy;
import hotciv.different.BetaWinnerStrategy;
import hotciv.different.BetaWorldAgingStrategy;
import hotciv.strategies.AttackingStrategy;
import hotciv.strategies.UnitActionStrategy;
import hotciv.strategies.WinnerStrategy;
import hotciv.strategies.WorldAgingStrategy;
import hotciv.strategies.WorldLayoutStrategy;

public class BetaFactory implements AbstractFactory {

	@Override
	public AttackingStrategy makeAttackStrategy() {
		return new AlphaAttackStrategy();
	}

	@Override
	public UnitActionStrategy makeUnitActionStrategy() {
		return new AlphaUnitActionStrategy();
	}

	@Override
	public WinnerStrategy makeWinnerStrategy() {
		return new BetaWinnerStrategy();
	}

	@Override
	public WorldAgingStrategy makeWorldAgingStrategy() {
		return new BetaWorldAgingStrategy();
	}

	@Override
	public WorldLayoutStrategy makeWorldLayoutStrategy() {
		return new AlphaWorldLayoutStrategy();
	}

}
