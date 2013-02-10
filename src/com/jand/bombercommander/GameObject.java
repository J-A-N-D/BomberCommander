package com.jand.bombercommander;

public class GameObject {
	
	protected boolean is_player_one;
	protected int field_position;
	protected GameObjectType type;
	
	public enum GameObjectType {
		ANTIAIR, FIGHTER, BOMBER
	}
	
	public GameObject() {
		this.is_player_one = true;
		this.field_position = 0;
		this.type = GameObjectType.ANTIAIR;
	}
	
	public GameObject(GameObjectType start_type, boolean start_is_player_one, int start_field_position) {
		this.type = start_type;
		this.is_player_one = start_is_player_one;
		this.field_position = start_field_position;
	}
	
	
	public boolean getIsPlayerOne() {
		return is_player_one;
	}
	
	public int getFieldPosition() {
		return field_position;
	}
	
	public GameObjectType getType() {
		return type;
	}
	
	
	public void setIsPlayerOne(boolean is_player_one) {
		this.is_player_one = is_player_one;
	}
	
	public void setFieldPosition(int new_field_position) {
		this.field_position = new_field_position;
	}
	
	public void setType(GameObjectType new_type) {
		this.type = new_type;
	}
	
}