package hotciv.framework;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Collection of constants used in HotCiv Game. Note that strings are used
 * instead of enumeration types to keep the set of valid constants open to
 * extensions by future HotCiv variants. Enums can only be changed by compile
 * time modification.
 * 
 * This source code is from the book "Flexible, Reliable Software: Using
 * Patterns and Agile Development" published 2010 by CRC Press. Author: Henrik B
 * Christensen Computer Science Department Aarhus University
 * 
 * This source code is provided WITHOUT ANY WARRANTY either expressed or
 * implied. You may study, use, modify, and distribute it for non-commercial
 * purposes. For any commercial use, see http://www.baerbak.com/
 */
public class GameConstants {
	public static final HashMap<String, Integer> costMap = new HashMap<String, Integer>();
	public static final HashMap<String, Integer> foodMap = new HashMap<String, Integer>();
	public static final ArrayList<String> costList = new ArrayList<String>();
	public static final ArrayList<String> foodList = new ArrayList<String>();
	public static final HashMap<String, Integer> productionMap = new HashMap<String, Integer>();
	// The size of the world is set permanently to a 16x16 grid
	public static final int WORLDSIZE = 16;
	// Valid unit types
	public static final String ARCHER = "archer";
	public static final String LEGION = "legion";
	public static final String SETTLER = "settler";
	// Valid terrain types
	public static final String PLAINS = "plains";
	public static final String OCEANS = "ocean";
	public static final String FOREST = "forest";
	public static final String HILLS = "hills";
	public static final String MOUNTAINS = "mountain";
	// Valid production balance types
	public static final String productionFocus = "hammer";
	public static final String foodFocus = "apple";
	// Map for units costs
	static {
		costMap.put(ARCHER, 10);
		costMap.put(LEGION, 15);
		costMap.put(SETTLER, 30);
	}
	// Map for food production
	static {
		foodMap.put(PLAINS, 3);
		foodMap.put(OCEANS, 1);
		foodMap.put(FOREST, 0);
		foodMap.put(MOUNTAINS, 0);
		foodMap.put(HILLS, 0);
	}
	// Map for unit production
	static {
		productionMap.put(PLAINS, 0);
		productionMap.put(OCEANS, 0);
		productionMap.put(FOREST, 3);
		productionMap.put(MOUNTAINS, 1);
		productionMap.put(HILLS, 2);
	}

	static {
		foodList.add(PLAINS);
		foodList.add(OCEANS);
		foodList.add("CITY");
		foodList.add(MOUNTAINS);
		foodList.add(HILLS);
		foodList.add(FOREST);
	}
	
	static {
		costList.add(FOREST);
		costList.add(HILLS);
		costList.add(MOUNTAINS);
		costList.add("CITY");
		costList.add(OCEANS);
		costList.add(PLAINS);
	}

}
