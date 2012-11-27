package hotciv.factories;

import hotciv.different.*;
import hotciv.standard.*;
import hotciv.strategies.*;

public class EpsilonFactory implements AbstractFactory {

	@Override
	public AttackingStrategy makeAttackStrategy() {
		return new EpsilonAttackStrategy(new TestDice());
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
		return new TestWorldLayoutStrategy();
	}
}
