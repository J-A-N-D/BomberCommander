package com.jand.bombercommander;

public class Player {
	
	private static final int MAX_HP = 200;
	private static final int MAX_BOMBS = 20;
	
	private int base_hp;
	private int bombs_left;
	//private list of live AA
	private boolean fighter_has_kill;
	
	
	public Player() {
		this.base_hp = MAX_HP;
		this.bombs_left = MAX_BOMBS;
		this.fighter_has_kill = false;
	}
	
	public Player(int start_base_hp, int start_bombs_left, boolean start_fighter_has_kill) {
		this.base_hp = start_base_hp;
		this.bombs_left = start_bombs_left;
		this.fighter_has_kill = start_fighter_has_kill;
	}
	
	
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