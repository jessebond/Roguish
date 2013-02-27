package com.me.Roguish.Model;

import com.badlogic.gdx.utils.Array;


public class MonsterUnit extends Unit {
	public static final int RAT = 0;
	
	private boolean finalMonster;	// If dead && finalMonster load next level. (used on bosses only?)
	private int monsterType;
	public MonsterUnit(int x, int y, String texture, Array<Integer> a, int type) {
		super(x, y, texture, a);
		setType(type);
	}
	public MonsterUnit(int x, int y, String texture, Array<Integer> a){
		super(x,y,texture,a);
	}
	public int getType(){
		return this.monsterType;
	}
	
	private void setType(int x){
		this.monsterType = x;
	}
	

}
