package com.me.Roguish.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;

public class ClassCard extends Card {
	// Hero attribute modifiers for the various cards.	
	private int intMod;
	private int dexMod;
	private int strMod;
	private Ability[] abilities;
	
	public ClassCard (String cardName){
		this.name = cardName;
		intMod = 3;
		dexMod = 3;
		strMod = 3;
		
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
