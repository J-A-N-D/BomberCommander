package com.jand.bombercommander;

public class GameObject {
	
	protected boolean is_player_one;
	protected int field_position;
	
	public GameObject() {
		this.is_player_one = true;
		this.field_position = 0;
	}
	
	public GameObject(boolean start_is_player_one, int start_field_position) {
		this.is_player_one = start_is_player_one;
		this.field_position = start_field_position;
	}
	
	
	public boolean getIsPlayerOne() {
		return is_player_one;
	}
	
	public int getFieldPosition() {
		return field_position;
	}
	
	
	public void setIsPlayerOne(boolean is_player_one) {
		this.is_player_one = is_player_one;
	}
	
	public void setFieldPosition(int new_field_position) {
		this.field_position = new_field_position;
	}
	
}