package hotciv.factories;

import hotciv.different.AlphaUnitActionStrategy;
import hotciv.different.AlphaWorldAgingStrategy;
import hotciv.different.AlphaWorldLayoutStrategy;
import hotciv.different.EpsilonAttackStrategy;
import hotciv.different.EpsilonWinnerStrategy;
import hotciv.strategies.AttackingStrategy;
import hotciv.strategies.UnitActionStrategy;
import hotciv.strategies.WinnerStrategy;
import hotciv.strategies.WorldAgingStrategy;
import hotciv.strategies.WorldLayoutStrategy;

public class EpsilonFactory implements AbstractFactory {

	@Override
	public AttackingStrategy makeAttackStrategy() {
		return new EpsilonAttackStrategy(null);
	}

	@Override
	public UnitActionStrategy makeUnitActionStrategy() {
		return new AlphaUnitActionStrategy();
	}

	@Override
	public WinnerStrategy makeWinnerStrategy() {
		return new EpsilonWinnerStrategy();
	}

	@Override
	public WorldAgingStrategy makeWorldAgingStrategy() {
		return new AlphaWorldAgingStrategy();
	}

	@Override
	public WorldLayoutStrategy makeWorldLayoutStrategy() {
		return new AlphaWorldLayoutStrategy();
	}
}
