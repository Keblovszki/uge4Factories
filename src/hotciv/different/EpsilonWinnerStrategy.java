package hotciv.different;

import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.strategies.WinnerStrategy;

public class EpsilonWinnerStrategy implements WinnerStrategy {
	private Game game;
	
	public EpsilonWinnerStrategy(Game game) {
		this.game = game;
	}

	@Override
	public Player winner() {
		if(game.countWins(Player.RED) > 2) {
			return Player.RED;
		}
		if(game.countWins(Player.BLUE) > 2) {
			return Player.BLUE;
		}
		return null;
	}
}
