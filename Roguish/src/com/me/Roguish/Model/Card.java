package com.me.Roguish.Model;



public abstract class Card {
	//private Json json; 
	
	protected String name;		// Unique flavor based card name
	protected int rarity;			// Rarity 

	/*
	private void loadData(String cardName){
		json = new Json();
		
	}*/
	
	public String getName(){
		return name;
	}

	public int getRarity(){
		return this.rarity;
	}
	

}
