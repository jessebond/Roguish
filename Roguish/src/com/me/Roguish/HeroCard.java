package com.me.Roguish;

public class HeroCard extends Card {
	
	// Hero attribute modifiers for the various cards.
	
	private static int intMod;
	private static int dexMod;
	private static int strMod;
	private Ability[] abilities;
	
	
	// Getter and setter methods for HeroCard attributes
	
	public int getIntMod(){
		return this.intMod;
	}
	
	public int getDexMod(){
		return this.dexMod;
	}
	
	public int getStrMod(){
		return this.strMod;
	}
	
	public void setIntMod(int x){
		this.intMod = x;
	}
	
	public void setDexMod(int x){
		this.dexMod = x;
	}
	
	public void setStrMod(int x){
		this.strMod = x;
	}
	
	public Ability[] getAbilities(){
		return this.abilities;
	}

}
