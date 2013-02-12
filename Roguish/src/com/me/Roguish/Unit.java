package com.me.Roguish;

public class Unit {
	private int x;					// x position
	private int y;					// y position
	private static int baseHP;				// Determined by Class/Race combo
  	private int maxHP;				// Calculated
	private int currentHP;
	private static int baseHealth; 	// Determined by Class/Race combo
	private int maxMana;
	private int currentMana;
	private boolean dead;			// Should be True is currentHealth <= 0
	private boolean finalMonster;	// If dead && finalMonster load next level. (used on bosses only?)
	private int[] status;			// Most likely an array with status effects
	private int def;				// ??? not sure yet - like AC in DCSS/NetHack (Could be based on
									// dex levels?)
	private int res;				// resistance to magic
	//Attributes
	private static int baseInt;		// Base stats
	private static int baseDex;		// Base stats
	private static int baseStr;		// Base stats

	public void setPos(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	
}
