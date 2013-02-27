package com.me.Roguish.Model;

public class MonsterUnit extends Unit {
	public static final int RAT = 0;
	
	private boolean finalMonster;	// If dead && finalMonster load next level. (used on bosses only?)
	private int monsterType;
	public MonsterUnit(int x, int y, String texture, int type) {
		super(x, y, texture);
		setType(type);
	}
	public MonsterUnit(int x, int y, String texture){
		super(x,y,texture);
	}
	public int getType(){
		return this.monsterType;
	}
	
	private void setType(int x){
		this.monsterType = x;
	}
	

}
