package hotciv.different;

import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.strategies.WinnerStrategy;

public class ZetaWinnerStrategy implements WinnerStrategy {
	private Game game;
	
	private WinnerStrategy winnerStrategy1;
	private WinnerStrategy winnerStrategy2;
	
	public ZetaWinnerStrategy(WinnerStrategy ws1, WinnerStrategy ws2, Game game) {
		winnerStrategy1 = ws1;
		winnerStrategy2 = ws2;
		this.game = game;
	}
	
	@Override
	public Player winner() {
		if(game.getRounds() < 20) {
			//winnerStrategy1.setGame(this.game);
			return winnerStrategy1.winner();
		}
		else if(game.getRounds() == 20) {
			game.resetAttacks();
			return winnerStrategy1.winner();
		}
		else {
			//winnerStrategy2.setGame(this.game);
			return winnerStrategy2.winner();
		}
	}
}