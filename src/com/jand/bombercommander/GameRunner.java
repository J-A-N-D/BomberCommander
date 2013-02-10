package com.jand.bombercommander;

import com.jand.bombercommander.GameObject.GameObjectType;


public class GameRunner {
	
	//private static final int NUM_OF_LANES = 5;
	
	Player p1;
	Player p2;
	
	public enum BomberState {
		SHOT_BY_FIGHTER, SHOT_BY_AA, DESTROYED_AA, DAMAGED_BASE
	}
	
	BomberState P1BomberState;
	BomberState P2BomberState;
	
	private boolean is_p1_turn;
	
	public GameRunner() {
		p1 = new Player();
		p2 = new Player();
		
		is_p1_turn = true;
	}
	
	public GameRunner(Player new_p1, Player new_p2, boolean new_is_p1_turn) {
		p1 = new_p1;
		p2 = new_p2;
		
		is_p1_turn = new_is_p1_turn;
	}
	
	
	public Player getP1() {
		return p1;
	}
	
	public Player getP2() {
		return p2;
	}
	
	public boolean getIsP1Turn() {
		return is_p1_turn;
	}
	
	
	public void setPlayerTurn(boolean new_is_p1_turn) {
		this.is_p1_turn = new_is_p1_turn;
	}
	
	public void setP1GameObjects(GameObject new_p1_bomber, GameObject new_p1_fighter, GameObject new_p1_anti_air) {
		this.p1.gameObjects.clear();
		
		this.p1.gameObjects.add(new_p1_bomber);
		this.p1.gameObjects.add(new_p1_fighter);
		this.p1.gameObjects.add(new_p1_anti_air);
	}
	
	public void setP1GameObjects(GameObject new_p1_bomber, GameObject new_p1_fighter) {
		this.p1.gameObjects.clear();
		
		this.p1.gameObjects.add(new_p1_bomber);
		this.p1.gameObjects.add(new_p1_fighter);
	}
	
	public void setP2GameObjects(GameObject new_p2_bomber, GameObject new_p2_fighter, GameObject new_p2_anti_air) {
		this.p2.gameObjects.clear();
		
		this.p2.gameObjects.add(new_p2_bomber);
		this.p2.gameObjects.add(new_p2_fighter);
		this.p2.gameObjects.add(new_p2_anti_air);
	}
	
	public void setP2GameObjects(GameObject new_p2_bomber, GameObject new_p2_fighter) {
		this.p2.gameObjects.clear();
		
		this.p2.gameObjects.add(new_p2_bomber);
		this.p2.gameObjects.add(new_p2_fighter);
	}
	
	
	public void roundEndUpdates() {
		
		GameObject p1_anti_air = null;
		GameObject p2_anti_air = null;
		
		GameObject p1_fighter = null;
		GameObject p2_fighter = null;
		
		GameObject p1_bomber = null;
		GameObject p2_bomber = null;
		
		for(GameObject o: p1.gameObjects){
			if (o.type == GameObjectType.ANTIAIR) {
				p1_anti_air = o;
			} else if (o.type == GameObjectType.BOMBER) {
				p1_bomber = o;
			} else {
				p1_fighter = o;
			}
		}
		
		for(GameObject o: p2.gameObjects){
			if (o.type == GameObjectType.ANTIAIR) {
				p2_anti_air = o;
			} else if (o.type == GameObjectType.BOMBER) {
				p2_bomber = o;
			} else {
				p2_fighter = o;
			}
		}
		
		if(p1_bomber.getFieldPosition() == p2_fighter.getFieldPosition()) {
			this.P1BomberState = BomberState.SHOT_BY_FIGHTER;
		} else if ( p2_anti_air != null && ( Math.abs(p1_bomber.getFieldPosition() - p2_anti_air.getFieldPosition()) ) == 1) {
			this.P1BomberState = BomberState.SHOT_BY_AA;
		} else if ( p2_anti_air != null && (p1_bomber.getFieldPosition() == p2_anti_air.getFieldPosition()) ) {
			this.P1BomberState = BomberState.DESTROYED_AA;
		} else {
			this.P1BomberState = BomberState.DAMAGED_BASE;
		}
		
		if(p2_bomber.getFieldPosition() == p1_fighter.getFieldPosition()) {
			this.P2BomberState = BomberState.SHOT_BY_FIGHTER;
		} else if ( p1_anti_air != null && ( Math.abs(p2_bomber.getFieldPosition() - p1_anti_air.getFieldPosition()) ) == 1) {
			this.P1BomberState = BomberState.SHOT_BY_AA;
		} else if ( p1_anti_air != null && (p2_bomber.getFieldPosition() == p1_anti_air.getFieldPosition()) ) {
			this.P1BomberState = BomberState.DESTROYED_AA;
		} else {
			this.P1BomberState = BomberState.DAMAGED_BASE;
		}
		
	}
}