package com.jand.bombercommander;

public class GameObject {
	
	protected boolean is_player_one;
	protected int field_position;
	
	
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