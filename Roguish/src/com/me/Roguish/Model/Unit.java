package com.me.Roguish.Model;

public abstract class Unit extends Entity{
	
	
	public Unit(int x, int y, String texture) {
		super(x, y, texture);
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
	
	public int getBaseMana(){
		return this.baseMana;
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

}
