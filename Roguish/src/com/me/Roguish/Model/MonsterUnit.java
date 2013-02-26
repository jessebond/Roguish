package com.me.Roguish.Model;

public class MonsterUnit extends Unit {
	
	private boolean finalMonster;	// If dead && finalMonster load next level. (used on bosses only?)

	public MonsterUnit(int x, int y, String texture) {
		super(x, y, texture);
	}
	
	

}
