package com.me.Roguish.Model;

import com.badlogic.gdx.utils.Json;

public class ClassCard extends Card {
	Json json;
	
	// Hero attribute modifiers for the various cards.
	
	private static int intMod;
	private static int dexMod;
	private static int strMod;
	private Ability[] abilities;
	
	public ClassCard (String cardName){
		json = new Json();
		
		loadData(cardName);
		intMod = 3;
		dexMod = 3;
		strMod = 3;
		
	}
	
	private void loadData(String cardName){
	
		
	}
	
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
	
	public Ability[] getAbilities(){
		return this.abilities;
	}

}
