package com.jand.bombercommander;

public class Player {
	
	private static final int MAX_HP = 10;
	
	private int base_hp;
	GameObject antiAir, fighter, bomber;
	
	
	public Player() {
		this.base_hp = MAX_HP;
		this.fighter_has_kill = false;
	}
	
	
	public int getBaseHP() {
		return base_hp;
	}
	
	
	public void setBaseHP(int new_base_hp) {
		this.base_hp = new_base_hp;
	}
	
}