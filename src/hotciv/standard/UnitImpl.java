package hotciv.standard;
import java.util.ArrayList;

import hotciv.framework.*;

public class UnitImpl implements Unit{
	private Game game;
	private String type;
	private Player owner;
	private int defenseStrength = 0;
	private int extraDefenseStrength = 0;
	private int attackStrength = 0;
	private boolean isFortify = false;
	
	//Constructor
	public UnitImpl(Player owner, String type, Game game){
		this.owner = owner;
		this.type = type;
		this.game = game;
		
		
		
	}
	
	@Override
	public String getTypeString() {
		return type;
	}

	@Override
	public Player getOwner(){
		return owner;
	}	
	
	@Override
	public int getMoveCount(){
		return 0;
	}
	
	@Override
	public int getDefensiveStrength(){
		if(type.equals(GameConstants.ARCHER)) {
			defenseStrength = 3;
		}
		if(type.equals(GameConstants.SETTLER)) {
			defenseStrength = 3;
		}
		if(type.equals(GameConstants.LEGION)) {
			defenseStrength = 2;
		}
		return defenseStrength + extraDefenseStrength;
	}
	
	@Override
	public void increaseBonusDefenseStrength(int bonusStrength){
		extraDefenseStrength += bonusStrength;
	}
	
	@Override
	 public int getAttackingStrength(){
		if(type.equals(GameConstants.ARCHER)) {
			attackStrength = 2;
		}
		if(type.equals(GameConstants.LEGION)) {
			attackStrength = 4;
		}
		if(type.equals(GameConstants.SETTLER)) {
			attackStrength = 0;
		}
		return attackStrength;
	}
	
	@Override
	public void setIsNotFortify(boolean fortify) {
		isFortify = fortify;
	}
	
	 @Override
	public boolean isNotArcherFortify(){
		if(type.equals(GameConstants.ARCHER) && this.getDefensiveStrength() == defenseStrength) {
			setIsNotFortify(true);
			return isFortify;
		}
		else if (type.equals(GameConstants.ARCHER) && this.getDefensiveStrength() != defenseStrength) {
			return isFortify;
		}
		else if(type.equals(GameConstants.SETTLER) || type.equals(GameConstants.LEGION)) {
			return true;
		}
		return false;
	}
	 
	@Override
	public ArrayList<Unit> getUnitsAround(Position p) {
		ArrayList<Unit> allUnitsAround = new ArrayList<Unit>();
		Unit N = game.getUnitAt(p.getNorth());
		Unit NE = game.getUnitAt(p.getNorthEast());
		Unit NW = game.getUnitAt(p.getNorthWest());
		Unit W = game.getUnitAt(p.getWest());
		Unit E = game.getUnitAt(p.getEast());
		Unit SW = game.getUnitAt(p.getSouthWest());
		Unit SE = game.getUnitAt(p.getSouthEast());
		Unit S = game.getUnitAt(p.getSouth());
		
		if(N != null) {
			allUnitsAround.add(N);
		}
		if(NW != null) {
			allUnitsAround.add(NW);
		}
		if(NE != null) {
			allUnitsAround.add(NE);
		}
		if(E != null) {
			allUnitsAround.add(E);
		}
		if(W != null) {
			allUnitsAround.add(W);
		}
		if(S != null) {
			allUnitsAround.add(S);
		}
		if(SE != null) {
			allUnitsAround.add(SE);
		}
		if(SW != null) {
			allUnitsAround.add(SW);
		}
		
		return allUnitsAround;
	}

}
