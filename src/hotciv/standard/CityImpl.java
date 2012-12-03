package hotciv.standard;

import hotciv.framework.*;

public class CityImpl implements City {
	private Player owner;
	private int production;
	private String unitProduction = null;
	private int cityPopulation = 1;
	private String workforceFocus = null;
	
	//Constructor
	public CityImpl(Player p) {
		owner = p;
		production = 0;
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
		production += 6;
	}
	
	@Override
	public int getProductionSum() {
		return production;
	}
	
	@Override
	public void setProductionSum(int change) {
		production += change; 
	}

	@Override
	public void setProduction(String unitType) {
		unitProduction = unitType;
	}
}
