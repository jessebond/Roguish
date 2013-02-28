package com.me.Roguish.Controller;

import com.me.Roguish.Model.Entity;
import com.me.Roguish.Model.Unit;

public class AbilityController {
	public static final int LONGSWORD = 0;
	public static final int SHIELD = 1;
	public static final int FIREBALL = 2;
	public static final int BITE = 3;
	public static final int STRONGBITE = 4;
	
	public AbilityController(){
	}
	
	public void activate(Entity origin, Entity target, int ability ){
		switch(ability){
			case (LONGSWORD):{
			}
			case (SHIELD):{
			}
			case(FIREBALL):{
			}
			case(BITE):{
				if(target instanceof Unit){
					((Unit)target).changeHP(-1);
				}
			}
			case(STRONGBITE):{
				if(target instanceof Unit){
					((Unit)target).changeHP(2 * ((Unit)origin).getStr());
				}
			}
		}
	}
}

