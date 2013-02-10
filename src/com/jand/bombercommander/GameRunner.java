package com.jand.bombercommander;

import java.util.Arrays;

import com.jand.bombercommander.GameObject.GameObjectType;

public class GameRunner {
	
	private static final int NUM_OF_LANES = 5;
	
	private GameObjectType[] p1Lane = new GameObjectType[5];
	private GameObjectType[] p2Lane = new GameObjectType[5];
	private boolean is_p1_turn;
	
	public GameRunner() {
		Arrays.fill(p1Lane, null);
		Arrays.fill(p1Lane, null);
		is_p1_turn = true;
	}
	
	public void roundEndUpdates() {
		
		boolean skip_lane_2_check = true;
		int adjacent_lane = 1;
		
		for(int i = 0; i < NUM_OF_LANES; i++) {
			
			if (i == 4) {
				adjacent_lane = 3;
			}
			
			switch(p1Lane[i]) {
				case BOMBER:
					if (p2Lane[i] == GameObjectType.ANTIAIR) {
						// destroyAA(boolean is_first_player);
						skip_lane_2_check = true;
					}
					else {
						if (i == 0 || i == 5) {
							if((p2Lane[i] == null || p2Lane[i] == GameObjectType.BOMBER)
								&& (p2Lane[adjacent_lane] == GameObjectType.ANTIAIR)){
								// damageP2Base()//!!!
							}
							else {
								if(p2Lane[i] == GameObjectType.FIGHTER) {
									//save that fighter took it down to play fighter destroy animation
								}
								else {
									// save that fighter was taken down by AA to play AA destroy animation
								}
							}
						}
						else {
							if((p2Lane[i] == null || p2Lane[i] == GameObjectType.BOMBER)
								&& (p2Lane[i-1] == GameObjectType.ANTIAIR)
								&& (p2Lane[i+1] == GameObjectType.ANTIAIR)) {
								// damageP2Base()//!!!
							}
							else {
								if(p2Lane[i] == GameObjectType.FIGHTER) {
									//save that fighter took it down to play fighter destroy animation
								}
								else {
									// save that fighter was taken down by AA to play AA destroy animation
								}
							}
						}
					}
					break;
				case FIGHTER:
					break;
				case ANTIAIR:
					break;
			}	
			
		}
		
	}
	
}