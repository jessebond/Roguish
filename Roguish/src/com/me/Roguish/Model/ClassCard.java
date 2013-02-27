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
		case 0: // Archer
			strMod = 3;
			dexMod = 5;
			intMod = 1; 
			break;
		case 1: // Mage
			strMod = 1;
			dexMod = 3;
			intMod = 5; 
			break;
		case 2: // Ninja
			strMod = 2;
			dexMod = 4;
			intMod = 3; 
			break;
		case 3: // Warrior
			strMod = 5;
			dexMod = 3;
			intMod = 1; 
			break;
		default: // error
			strMod = -1;
			dexMod = -1;
			intMod = -1;
			break;
		}
	}
	
	public String getClassName(int cardNo){
		switch(cardNo){
		case 0:
			return "Archer";
		case 1:
			return "Mage";
		case 2:
			return "Ninja";
		case 3:
			return "Warrior";	
		default:
			return "BadCardNo";
		}
	}
	
	public String getClassName(){
		return getClassName(this.cardNo);
	}
	
	// Used for the TextureRegion name for the respective uses
	public String getFaceName(int cardNo){
		return "F_" + getClassName(cardNo);
	}
	
	public String getDeckName(int cardNo){
		return "D_" + getClassName(cardNo);
	}

	public String getCardName(int cardNo){
		return "C_" + getClassName(cardNo);
	}
}