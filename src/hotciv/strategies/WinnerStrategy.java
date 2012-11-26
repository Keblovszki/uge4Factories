package hotciv.strategies;

import hotciv.framework.*;
import hotciv.standard.GameImpl;

public interface WinnerStrategy {
	
	public Player winner();
	public void setGame(GameImpl game);

}
