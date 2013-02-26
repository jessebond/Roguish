package com.me.Roguish.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.Array;

public class ClassCard extends Card {
	// Hero attribute modifiers for the various cards.	
	private int intMod;
	private int dexMod;
	private int strMod;
	private Array<Integer> abilities;
	
	public ClassCard (int cardNo){
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
	
	public Array<Integer> getAbilities(){
		return this.abilities;
	}

	private void setStats(int cardNo){
		switch(cardNo){
		case 0:
			strMod = 5;
			dexMod = 3;
			intMod = 1; 
			abilities.add(Ability.LONGSWORD);
			abilities.add(Ability.SHIELD);
			break;
		default:
			break;
		}
	}
}