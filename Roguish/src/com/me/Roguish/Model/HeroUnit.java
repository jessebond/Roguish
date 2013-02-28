package com.me.Roguish.Model;

import com.badlogic.gdx.utils.Array;

import com.me.Roguish.Model.ClassCard;
import com.me.Roguish.Model.RaceCard;

public class HeroUnit extends Unit {
	private ClassCard cCard;
	private RaceCard rCard;
	
	
	public HeroUnit(int x, int y, String texture, Array<Integer> a, ClassCard cCard){
		super(x, y, texture, a);
		this.cCard = cCard;
		rCard = new RaceCard(0);
		setStats();
	}

	private void setStats(){
		baseStr = cCard.getStrMod() + rCard.getStrMod();
		baseDex = cCard.getDexMod() + rCard.getDexMod();
		baseInt = cCard.getIntMod() + rCard.getIntMod();
		baseHP = 2 * baseDex;
		baseMana = 2 * baseInt;
		this.setAlive(true);
		
		
	}
}
