package hotciv.different;

import hotciv.strategies.WorldAgingStrategy;

public class AlphaWorldAgingStrategy implements WorldAgingStrategy{
	
	public int worldAging(int age){
		return age + 100;
	}
}
