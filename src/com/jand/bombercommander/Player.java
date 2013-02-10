package com.jand.bombercommander;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.jand.bombercommander.GameObject.GameObjectType;

public class Player implements Iterable<GameObject>{
	
	private static final int MAX_HP = 10;
	
	private int base_hp;
	protected List<GameObject> gameObjects;
	protected GameObject antiAir, fighter, bomber;
	
	
	public Player() {
		this.base_hp = MAX_HP;
		//this.fighter_has_kill = false;
		
		this.antiAir = new GameObject(GameObjectType.ANTIAIR, true, 0);
		this.bomber = new GameObject(GameObjectType.BOMBER, true, 1);
		this.fighter = new GameObject(GameObjectType.FIGHTER, true, 2);
		
		gameObjects = new LinkedList<GameObject>();
		gameObjects.add(antiAir);
		gameObjects.add(bomber);
		gameObjects.add(fighter);
	}
	
	public Player(GameObject new_anti_air, GameObject new_bomber, GameObject new_fighter) {
		this.base_hp = MAX_HP;
		
		this.antiAir = new_anti_air;
		this.bomber = new_bomber;
		this.fighter = new_fighter;
		
		gameObjects = new LinkedList<GameObject>();
		gameObjects.add(antiAir);
		gameObjects.add(bomber);
		gameObjects.add(fighter);
	}
	
	
	public int getBaseHP() {
		return base_hp;
	}
	
	public GameObject getAntiAir() {
		return antiAir;
	}
	
	public GameObject getBomber() {
		return bomber;
	}
	
	public GameObject getFighter() {
		return fighter;
	}
	
	
	public void setBaseHP(int new_base_hp) {
		this.base_hp = new_base_hp;
	}
	
	public void setAntiAir(GameObject new_antiAir) {
		this.antiAir = new_antiAir;
	}
	
	public void setBomber(GameObject new_bomber) {
		this.bomber = new_bomber;
	}
	
	public void setFighter(GameObject new_fighter) {
		this.fighter = new_fighter;
	}
	

	@Override
	public Iterator<GameObject> iterator() {
		// TODO Auto-generated method stub
		return gameObjects.iterator();
	}
	
}