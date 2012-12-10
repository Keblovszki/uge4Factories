package hotciv.different;

import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.strategies.PopulationStrategy;

public class EtaPopulationStrategy implements PopulationStrategy {
	private Game game;
	
	public EtaPopulationStrategy(Game game) {
		this.game = game;
	}
	
	@Override
	public void increasePopulation(Position p) {
		if (game.getMapCity().get(p) != null) {
			City c = game.getMapCity().get(p);
			int food = c.getFoodProduction();
			int population = c.getSize();
			if (population < 9) {
				if (5 + population * 3 < food) {
					c.setSize(population + 1);
					c.setFoodProduction(0);
				}
			}
		}
	}
}
