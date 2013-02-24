package com.me.Roguish.Model;



public abstract class Card {	
	protected String name;		// Unique flavor based card name
	protected int rarity;			// Rarity 
	protected int cardNo;

	
	public String getName(){
		return name;
	}

	public int getRarity(){
		return this.rarity;
	}
	

}
