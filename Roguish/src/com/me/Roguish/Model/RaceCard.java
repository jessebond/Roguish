package com.me.Roguish.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.Array;

public class RaceCard extends Card {
	// Hero attribute modifiers for the various cards.	
	private int intMod;
	private int dexMod;
	private int strMod;
	private Array<String> abilities;
	
	public RaceCard (int cardNo){
		this.cardNo = cardNo;
		setStats(cardNo);
		
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
	
	public Array<String> getAbilities(){
		return this.abilities;
	}

	private void setStats(int cardNo){
		switch(cardNo){
		case 0:
			strMod = 3;
			dexMod = 3;
			intMod = 3; 
			break;
		default:
			break;
		}
	}
}