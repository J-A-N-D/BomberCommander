package com.jand.bombercommander;

import java.util.List;

import com.jand.bombercommander.GameObject.GameObjectType;


public class GameRunner {
	
	//private static final int NUM_OF_LANES = 5;
	
	private List<GameObject> p1_game_objects;
	private List<GameObject> p2_game_objects;
	
	public enum P1BomberState {
		SHOT_BY_FIGHTER, SHOT_BY_AA, DESTROYED_AA, DAMAGED_BASE
	}
	
	public enum P2BomberState {
		SHOT_BY_FIGHTER, SHOT_BY_AA, DESTROYED_AA, DAMAGED_BASE
	}
	
	//private GameObject p1_bomber;
	//private GameObject p2_bomber;
	
	private boolean is_p1_turn;
	
	public GameRunner() {
		p1_game_objects.clear();
		p2_game_objects.clear();
		
		//p1_bomber = new GameObject(GameObjectType.BOMBER, true, 1);
		//p2_bomber = new GameObject(GameObjectType.BOMBER, true, 1);
		
		p1_game_objects.add(new GameObject(GameObjectType.ANTIAIR, true, 0));
		p1_game_objects.add(new GameObject(GameObjectType.BOMBER, true, 1));
		p1_game_objects.add(new GameObject(GameObjectType.FIGHTER, true, 2));
		
		p2_game_objects.add(new GameObject(GameObjectType.ANTIAIR, false, 0));
		p2_game_objects.add(new GameObject(GameObjectType.BOMBER, true, 1));
		p2_game_objects.add(new GameObject(GameObjectType.FIGHTER, false, 2));
		
		is_p1_turn = true;
	}
	
	public GameRunner(GameObject new_p1_anti_air, GameObject new_p1_bomber, GameObject new_p1_fighter,
						GameObject new_p2_anti_air, GameObject new_p2_bomber, GameObject new_p2_fighter,
						boolean new_is_p1_turn) {
		p1_game_objects.clear();
		p2_game_objects.clear();
		
		//p1_bomber = new_p1_bomber;
		//p2_bomber = new_p1_bomber;
		
		p1_game_objects.add(new_p1_anti_air);
		p1_game_objects.add(new_p1_bomber);
		p1_game_objects.add(new_p1_fighter);
		
		p2_game_objects.add(new_p2_anti_air);
		p2_game_objects.add(new_p2_bomber);
		p2_game_objects.add(new_p2_fighter);
		
		is_p1_turn = new_is_p1_turn;
	}
	
	public void roundEndUpdates() {
		
		GameObject p1_anti_air = null;
		GameObject p2_anti_air = null;
		
		GameObject p1_fighter = null;
		GameObject p2_fighter = null;
		
		GameObject p1_bomber = null;
		GameObject p2_bomber = null;
		
		for(GameObject o: p1_game_objects){
			if (o.type == GameObjectType.ANTIAIR) {
				p1_anti_air = o;
			} else if (o.type == GameObjectType.BOMBER) {
				p1_bomber = o;
			} else {
				p1_fighter = o;
			}
		}
		
		for(GameObject o: p2_game_objects){
			if (o.type == GameObjectType.ANTIAIR) {
				p2_anti_air = o;
			} else if (o.type == GameObjectType.BOMBER) {
				p2_bomber = o;
			} else {
				p2_fighter = o;
			}
		}
		
		
		
	}
}