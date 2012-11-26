package hotciv.factories;

import hotciv.strategies.*;

public interface AbstractFactory {

	public AttackingStrategy makeAttackStrategy();
	
	public UnitActionStrategy makeUnitActionStrategy();
	
	public WinnerStrategy makeWinnerStrategy();
	
	public WorldAgingStrategy makeWorldAgingStrategy();
	
	public WorldLayoutStrategy makeWorldLayoutStrategy();
	
}
