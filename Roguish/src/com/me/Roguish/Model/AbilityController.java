package com.me.Roguish.Model;

public class AbilityController {
	public static final int LONGSWORD = 0;
	public static final int SHIELD = 1;
	public static final int FIREBALL = 2;
	public static final int BITE = 3;
	
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
				System.out.println("You've been bitten!");
			}
		}
		
	}

	
}

