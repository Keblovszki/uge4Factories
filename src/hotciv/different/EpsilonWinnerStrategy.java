package hotciv.different;

import hotciv.framework.Player;
import hotciv.standard.GameImpl;
import hotciv.strategies.WinnerStrategy;

public class EpsilonWinnerStrategy implements WinnerStrategy {
	private GameImpl game;
	
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

	@Override
	public void setGame(GameImpl game) {
		this.game = game;
	}

}
