package com.me.Roguish.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;
import com.me.Roguish.Model.ClassCard;
import com.me.Roguish.Model.RaceCard;

public class HeroUnit extends Unit {
	private ClassCard cCard;
	private RaceCard rCard;
	
	
	public HeroUnit(int x, int y, String texture){
		super(x, y, texture);
		cCard = new ClassCard(0);
		rCard = new RaceCard(0);
		setStats();
		this.setMovement(this.getDex());
	}

	private void setStats(){
		baseStr = cCard.getStrMod() + rCard.getStrMod();
		baseDex = cCard.getDexMod() + rCard.getDexMod();
		baseInt = cCard.getIntMod() + rCard.getIntMod();
		baseHP = 2 * baseDex;
		baseMana = 2 * baseInt;
		
		
	}
}
