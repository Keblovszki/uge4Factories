package hotciv.different;

import hotciv.framework.Player;
import hotciv.standard.GameImpl;
import hotciv.standard.WinnerStrategy;

public class ZetaWinnerStrategy implements WinnerStrategy {
	private GameImpl game;
	
	@Override
	public Player winner() {
		if(game.getRounds() < 20) {
			return null;//BetaWinnerStrategy.winner();
		}
		return null;
	}
	
	@Override
	public void setGame(GameImpl game) {
		this.game = game;
	}
}