package hotciv.factories;

import hotciv.different.AlphaAttackStrategy;
import hotciv.different.AlphaWinnerStrategy;
import hotciv.different.AlphaWorldAgingStrategy;
import hotciv.different.AlphaWorldLayoutStrategy;
import hotciv.different.GammaUnitActionStrategy;
import hotciv.strategies.AttackingStrategy;
import hotciv.strategies.UnitActionStrategy;
import hotciv.strategies.WinnerStrategy;
import hotciv.strategies.WorldAgingStrategy;
import hotciv.strategies.WorldLayoutStrategy;

public class GammaFactory implements AbstractFactory {

	@Override
	public AttackingStrategy makeAttackStrategy() {
		return new AlphaAttackStrategy();
	}

	@Override
	public UnitActionStrategy makeUnitActionStrategy() {
		return new GammaUnitActionStrategy();
	}

	@Override
	public WinnerStrategy makeWinnerStrategy() {
		return new AlphaWinnerStrategy();
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
