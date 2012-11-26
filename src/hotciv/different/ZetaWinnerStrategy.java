package hotciv.different;

import hotciv.framework.Player;
import hotciv.standard.GameImpl;
import hotciv.standard.WinnerStrategy;

public class ZetaWinnerStrategy implements WinnerStrategy {
	private GameImpl game;
	
	private WinnerStrategy winnerStrategy1;
	private WinnerStrategy winnerStrategy2;
	
	public ZetaWinnerStrategy(WinnerStrategy ws1, WinnerStrategy ws2) {
		winnerStrategy1 = ws1;
		winnerStrategy2 = ws2;
	}
	@Override
	public Player winner() {
		if(game.getRounds() < 20) {
			return winnerStrategy1.winner();
		}
		else{
			game.resetAttacks();
			return winnerStrategy2.winner();
		}
	}
	
	@Override
	public void setGame(GameImpl game) {
		this.game = game;
	}
}