package hotciv.standard;

import hotciv.framework.*;

public class CityImpl implements City {
	private Player owner;
	private int production;
	private String unitProduction = null;
	private int cityPopulation = 1;
	private String workforceFocus = null;
	private int productionChange = 6;
	private int foodProduction;
	
	//Constructor
	public CityImpl(Player p) {
		owner = p;
		production = 0;
		foodProduction = 0;
	}
	
	@Override
	public Player getOwner() {
		return owner;
	}
	
	@Override
	public void setOwner(Player p) {
		owner = p;
	}

	@Override
	public int getSize() {
		return cityPopulation;
	}
	
	@Override
	public void setSize(int reSize) {
		cityPopulation = reSize;
	}

	@Override
	public String getProduction() {
		return unitProduction;
	}
	
	@Override
	public String getWorkforceFocus() {
		return workforceFocus;
	}
	
	@Override 
	public void setWorkforceFocus(String balance){
		workforceFocus = balance;
	}
	
	@Override
	public void doProductionSum() {
		production += productionChange;
	}
	
	@Override
	public int getProductionSum() {
		return production;
	}
	
	@Override
	public void setProductionChange(int change) {
		productionChange = change; 
	}
	
	@Override
	public void setProductionSum(int change) {
		production += change; 
	}

	@Override
	public void setProduction(String unitType) {
		unitProduction = unitType;
	}

	@Override
	public int getFoodProduction() {
		return foodProduction;
	}

	@Override
	public void setFoodProduction(int foodProduction) {
		this.foodProduction = foodProduction;
	}
}
