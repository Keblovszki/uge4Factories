package hotciv.factories;

import hotciv.different.AlphaAttackStrategy;
import hotciv.different.AlphaUnitActionStrategy;
import hotciv.different.AlphaWorldAgingStrategy;
import hotciv.different.BetaWinnerStrategy;
import hotciv.different.EpsilonWinnerStrategy;
import hotciv.different.TestWorldLayoutStrategy;
import hotciv.different.ZetaWinnerStrategy;
import hotciv.strategies.AttackingStrategy;
import hotciv.strategies.UnitActionStrategy;
import hotciv.strategies.WinnerStrategy;
import hotciv.strategies.WorldAgingStrategy;
import hotciv.strategies.WorldLayoutStrategy;

public class ZetaFactory implements AbstractFactory {

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
		return new ZetaWinnerStrategy(new BetaWinnerStrategy(), new EpsilonWinnerStrategy());
	}

	@Override
	public WorldAgingStrategy makeWorldAgingStrategy() {
		return new AlphaWorldAgingStrategy();
	}

	@Override
	public WorldLayoutStrategy makeWorldLayoutStrategy() {
		return new TestWorldLayoutStrategy();
	}

}
