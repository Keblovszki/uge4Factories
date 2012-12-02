package hotciv.different;

import hotciv.framework.Game;
import hotciv.framework.Player;
import hotciv.strategies.WinnerStrategy;

public class AlphaWinnerStrategy implements WinnerStrategy {
	private Game game;
	
	public AlphaWinnerStrategy(Game game) {
		this.game = game;
	}
	
	@Override
	public Player winner(){
		int age = this.game.getAge();
		if(age >= -3000){
			return Player.RED;
		}
		return null;
	}
}
