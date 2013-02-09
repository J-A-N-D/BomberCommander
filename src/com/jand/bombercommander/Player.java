package com.jand.bombercommander;

public class Player {
	
	private int base_hp;
	private int bombs_left;
	//private list of live AA
	private boolean fighter_has_kill;
	
	
	public int getBaseHP() {
		return base_hp;
	}
	
	public int getBombsLeft() {
		return bombs_left;
	}
	
	public boolean getFighterHasKill() {
		return fighter_has_kill;
	}
	
	
	public void setBaseHP(int new_base_hp) {
		this.base_hp = new_base_hp;
	}
	
	public void setBombsLeft(int updated_bombs_left) {
		this.bombs_left = updated_bombs_left;
	}
	
	public void setFighterHasKill(boolean updated_fighter_has_kill) {
		this.fighter_has_kill = updated_fighter_has_kill;
	}
	
}