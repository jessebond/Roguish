package com.me.Roguish.Model;

import com.badlogic.gdx.utils.Array;

public abstract class Unit extends Entity{
	
	
	public Unit(int x, int y, String texture, Array<Integer> a) {
		super(x, y, texture, a);
		System.out.println("Unit");
		this.setMovement(this.getDex());
	}

	protected static int baseHP;		// Determined by Class/Race combo
	protected int currentHP;
	protected static int baseMana;
	protected int currentMana;
	protected boolean alive;			// Should be True is currentHealth <= 0
	protected int[] status;			// Most likely an array with status effects
	protected int def;				// ??? not sure yet - like AC in DCSS/NetHack (Could be based on
									// dex levels?)
	protected int res;				// resistance to magic
	//Attributes
	protected static int baseInt;		// Base stats
	protected static int baseDex;		// Base stats
	protected static int baseStr;		// Base stats 

	public void setHP(int HP){
		this.currentHP = HP;
	}
	
	public void setMana(int mana){
		this.currentMana = mana;
	}
	
	public void updateAlive(boolean a){
		this.alive = a;
	}
	
	public void setStatus(int a, int b){
		// Finish
	}
	
	public int getHP(){
		return this.currentHP;
	}
	
	public int getMana(){
		return this.currentMana;
	}
	
	public void updateMana(int delta){
		this.setMana(this.getMana() + delta);
	}
	
	public int getBaseMana(){
		return this.baseMana;
	}
	
	public int getBaseHP(){
		return this.baseHP;
	}
	
	public boolean isAlive(){
		return this.alive;
	}
	
	public int getDef(){
		return this.def;
	}

	public int getRes(){
		return this.res;
	}

	public int getStr(){
		return this.baseStr;
	}

	public int getDex(){
		return this.baseStr;
	}
	
	public int getInt(){
		return this.baseStr;
	}
	
	public void changeHP(int delta){
		this.setHP(this.getHP() + delta);
		if(this.getHP() <= 0) this.setAlive(false);
	}
	
	public void setAtts(int str, int inte, int dex){
		this.baseStr = str;
		this.baseInt = inte;
		this.baseDex = dex;
		this.baseHP = 2*str;
		this.baseMana = 2*inte;
		this.setMovement(50 - dex);
		this.setMana(2*inte);
		this.setHP(2*str);
		this.setAlive(true);
	}

}
