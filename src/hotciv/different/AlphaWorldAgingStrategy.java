package hotciv.different;

import hotciv.framework.Game;
import hotciv.strategies.WorldAgingStrategy;

public class AlphaWorldAgingStrategy implements WorldAgingStrategy{
	@SuppressWarnings("unused")
	private Game game;

	public AlphaWorldAgingStrategy(Game game) {
		this.game = game;
	}

	public int worldAging(int age){
		return age + 100;
	}
}
