package com.me.Roguish.Controller;

import com.me.Roguish.Model.Entity;
import com.me.Roguish.Model.MonsterUnit;
import com.me.Roguish.Model.Unit;

public class AbilityController {
	public static final int LONGSWORD = 20;
	public static final int SHIELD = 21;
	public static final int FIREBALL = 22;
	public static final int BITE = -2;
	public static final int STRONGBITE = -3;

	public static final int B_AXE = 0;
	public static final int B_BOW = 1;
	public static final int B_XBOW = 2;
	public static final int B_SHURIKEN = 3;
	public static final int B_STAFF = 4;
	public static final int B_STARS = 5;
	public static final int B_SWORD = 6;	
	public static final int B_WAND = 7;
	public static final int A_AXE = 8;
	public static final int A_BOW = 9;
	public static final int A_XBOW = 10;
	public static final int A_SHURIKEN = 11;
	public static final int A_STAFF = 12;
	public static final int A_STARS = 13;
	public static final int A_SWORD = 14;
	public static final int A_WANT = 15;

	public static final int GALOSHES = 16;
	public static final int GAUNTLET = 17;
	public static final int HEALTHBOOST = 18;
	public static final int MANABOOST = 19;
	
	public AbilityController(){
	}
	
	public void activate(Entity origin, Entity target, int ability ){
		switch(ability){
			case (LONGSWORD):{
				((Unit)target).changeHP(-2 * ((Unit)origin).getStr());
				System.out.println(((MonsterUnit)target).getHP());
				break;
			}
			case (SHIELD):{
				break;
			}
			case(FIREBALL):{
				break;
			}
			case(BITE):{
				if(target instanceof Unit){
					((Unit)target).changeHP(-1);
				}
				break;
			}
			case(STRONGBITE):{
				if(target instanceof Unit){
					((Unit)target).changeHP(((Unit)origin).getStr());
				}
				break;
			}
			default:
				break;
		}
	}
	
	public int getRange(int ability){
		switch(ability){
			case (LONGSWORD):{
				return 1;
			}
			case (SHIELD):{
				return 1;
			}
			case (BITE):{
				return 1;
			}
			case (STRONGBITE):{
				return 1;
			}
			case(FIREBALL):{
				return 8;
			}
			default: 
				return 0;
		}
	}
}

