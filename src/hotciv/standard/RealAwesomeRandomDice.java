package hotciv.standard;

import hotciv.framework.Dice;
import java.util.*;

public class RealAwesomeRandomDice implements Dice {
	Random generator = new Random();
	
	public int rollDice() {
		int roll = generator.nextInt(6) + 1;
		return roll;
	}

}
