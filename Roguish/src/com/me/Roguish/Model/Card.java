package com.me.Roguish.Model;

import com.badlogic.gdx.utils.Json;

public abstract class Card {
	//private Json json; 
	
	private String name;		// Unique flavor based card name
	private int rarity;			// Rarity 

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
