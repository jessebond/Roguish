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
			//abilities.add(AbilityController.LONGSWORD);
			//abilities.add(AbilityController.SHIELD);
			break;
		default:
			break;
		}
	}
	
	public String getImageClass(int cardNo){
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
			return "Warrior";
		}
	}
	
	public String getImageFace(int cardNo){
		return "F_" + getImageClass(cardNo);
	}
	
	public String getImageDeck(int cardNo){
		return "D_" + getImageClass(cardNo);
	}

	public String getImageCard(int cardNo){
		return "C_" + getImageClass(cardNo);
	}
}