package hotciv.standard;

import static org.junit.Assert.*;
import hotciv.factories.*;
import hotciv.framework.*;

import org.junit.Before;
import org.junit.Test;

public class TestEtaCiv {
	private Game game;
	
	@Before
	public void SetUp() {
		game = new GameImpl( new EtaFactory() );
	}
	
	@Test
	public void thereShouldBeACityAt1_1Red() {
		Position p = new Position(1, 1);
		City c = game.getCityAt(p);
		assertNotNull("There is a city at position (1, 1)", c);
		assertEquals("The city here should be red", c, c);
	}
	
	@Test
	public void noProductionInFoodFokus() {
		City c = game.getCityAt(new Position(1, 1));
		c.setWorkforceFocus(GameConstants.foodFocus);
		assertEquals("The production is 0", c.getProductionSum(), 0);
		c.setProduction(GameConstants.ARCHER);
		
		//1 round
		game.endOfTurn(); game.endOfTurn();
		
		assertEquals("Still the same", c.getProductionSum(), 0);
	}
	
	@Test
	public void productionOfArchers(){
		City c = game.getCityAt(new Position(1, 1));
		c.setWorkforceFocus(GameConstants.productionFocus);
		assertEquals("The production is 0", c.getProductionSum(), 0);
		c.setProduction(GameConstants.ARCHER);
		
		//run 4 rounds
		for (int i = 0; i < 2; i++) {
			game.endOfTurn();
		}
		assertEquals("The productionSum should be 3", 3, c.getProductionSum());
		for (int i = 0; i < 2; i++) {
			game.endOfTurn();
		}
		assertEquals("The productionSum should be 6", 6, c.getProductionSum());
		for (int i = 0; i < 2; i++) {
			game.endOfTurn();
		}
		assertEquals("The productionSum should be 2", 9, c.getProductionSum());
		for (int i = 0; i < 2; i++) {
			game.endOfTurn();
		}
		assertEquals("The productionSum should be 2", 2, c.getProductionSum());
		
		Unit u1 = game.getUnitAt(new Position(1, 1));
		assertNotNull("There is a unit at position (1, 1)", u1);
		assertEquals("There should be a settler at (1, 1)", GameConstants.ARCHER, u1.getTypeString());
		assertEquals("The productionSum should be 2", 2, c.getProductionSum());
		assertNull("Is the position north for the city is null", game.getUnitAt(new Position(0, 1)));
		
	}
	
	@Test
	public void switchBetweenFoodAndProdFocus(){
		City c = game.getCityAt(new Position(1, 1));
		c.setWorkforceFocus(GameConstants.productionFocus);
		assertEquals("The production is 0", c.getProductionSum(), 0);
		assertEquals("No food", c.getFoodProduction(), 0);
		
		//Run 4 rounds
		for(int i = 0; i < 8; i++){
			game.endOfTurn();
		}
		assertEquals("The production is 12", 12, c.getProductionSum());
		assertEquals("No food", 0, c.getFoodProduction());
		
		//set to food focus
		c.setWorkforceFocus(GameConstants.foodFocus);
		
		//Run for 2 rounds
		for(int i = 0; i < 4; i++){
			game.endOfTurn();
		}
		
		assertEquals("The production is still 12", 12, c.getProductionSum());
		assertEquals("the food is now 6", 6, c.getFoodProduction());
	}
	
	@Test
	public void theCityPopuEquals3() {
		City c = game.getCityAt(new Position(1, 1));
		c.setWorkforceFocus(GameConstants.foodFocus);
		assertEquals("this city has size 1", c.getSize(), 1);
		assertEquals("NO FOOD!", c.getFoodProduction(), 0);
		
		//1 round run
		game.endOfTurn(); 
		game.endOfTurn();
		assertEquals("more food", 3, c.getFoodProduction());
		
		//1 round
		for (int i = 0; i < 2; i++) {
			game.endOfTurn();
		}
		
		assertEquals("The size is 2", c.getSize(), 1);
		assertEquals("6 food", 6, c.getFoodProduction());
		
		//1 round
		for (int i = 0; i < 2; i++) {
			game.endOfTurn();
		}
		
		assertEquals("The size is 2", c.getSize(), 2);
		assertEquals("NO FOOD!", 0, c.getFoodProduction());
		
		//2 rounds
		for (int i = 0; i < 4; i++) {
			game.endOfTurn();
		}
		
		//population of the city should be 3...
		assertEquals("The size is 2", c.getSize(), 3);
		assertEquals("NO FOOD!", c.getFoodProduction(), 0);
	}
	
	@Test
	public void noCityWithPopOver9() {
		City c = game.getMapCity().get(new Position(1, 1));
		c.setWorkforceFocus(GameConstants.foodFocus);
		
		//200 rounds
		for (int i = 0; i < 400; i++) {
			game.endOfTurn();
		}
		
		assertEquals("The citySize is size 9", c.getSize(), 9);
	}
}