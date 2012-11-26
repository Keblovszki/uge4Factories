package hotciv.factories;

import hotciv.different.*;
import hotciv.strategies.*;

public class AlphaFactory implements AbstractFactory {

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
