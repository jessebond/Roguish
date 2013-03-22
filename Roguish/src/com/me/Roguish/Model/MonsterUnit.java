package com.me.Roguish.Model;
import java.math.*;
import java.util.Random;

import com.badlogic.gdx.utils.Array;
import com.me.Roguish.Controller.AbilityController;


public class MonsterUnit extends Unit {
	public static final int RAT = 0;
	public static final int BAT = 1;
	public static final int SPIDER = 2;
	public static final int BEAR = 3;
	public static final int SHADOW = 4;
	public static final int GOLEM = 5;
	private Random Dice = new Random();
		
	//private boolean finalMonster;	// If dead && finalMonster load next level. (used on bosses only?)
	private int monsterType;
	public MonsterUnit(int x, int y, String texture, Array<Integer> a, int type) {
		super(x, y, texture, a);
		setType(type);
		switch(type){
		case RAT:{
			this.setAtts(Dice.nextInt(2), Dice.nextInt(2), 6);
			this.setHP(4);
			this.addAbility(AbilityController.BITE);
			this.setAlive(true);
			
		}
		case BAT:{
			this.setAtts(Dice.nextInt(3), Dice.nextInt(3), 20);
			this.setHP(8);
			this.addAbility(AbilityController.STRONGBITE);
			this.setAlive(true);
		}
		case SPIDER:{
			this.setAtts(Dice.nextInt(4), 5, 20);
			this.setHP(12);
		}
		case BEAR:{
			this.setAtts(Dice.nextInt(5), Dice.nextInt(5), Dice.nextInt(5));
			this.setHP(14);
		}
		case SHADOW:{
			this.setAtts(Dice.nextInt(6), Dice.nextInt(6), Dice.nextInt(6));
			this.setHP(16);
			
		}
		case GOLEM:{
			this.setAtts(Dice.nextInt(7), Dice.nextInt(7), Dice.nextInt(7));
			this.setHP(20);
			
		}
		}
		
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
