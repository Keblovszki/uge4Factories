package hotciv.different;

import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.strategies.WinnerStrategy;

public class BetaWinnerStrategy implements WinnerStrategy {
	private Game game;
	
	public BetaWinnerStrategy(Game game) {
		this.game = game;
	}
	
	public Player winner() {
		Player p = null;
		Player owner = null;
		Player owner1 = null;
		
		for(City c : this.game.getAllCities()) {
			if(Player.RED == c.getOwner()) {
				owner = c.getOwner();
			}
			if(Player.BLUE == c.getOwner()) {
				owner1 = c.getOwner();
			}
		}
		if(owner == null) {
			p = Player.BLUE;
		}
		if(owner1 == null) {
			p = Player.RED;
		}
		return p;
	}
}

	