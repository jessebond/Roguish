package com.me.Roguish.Model;

import com.badlogic.gdx.utils.Array;

import com.me.Roguish.Model.ClassCard;
import com.me.Roguish.Model.RaceCard;

public class HeroUnit extends Unit {
	private ClassCard cCard;
	private RaceCard rCard;
	
	
	public HeroUnit(int x, int y, String texture, Array<Integer> a, ClassCard cCard){
		super(x, y, texture, a);
		System.out.println("Hero");
		this.cCard = cCard;
		rCard = new RaceCard(0);
		setStats();
	}

	private void setStats(){
		this.setAtts(cCard.getStrMod() + rCard.getStrMod(), cCard.getIntMod() + rCard.getIntMod(),  cCard.getDexMod() + rCard.getDexMod());
	}
}
