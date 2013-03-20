package com.me.Roguish.Controller;

import com.me.Roguish.Model.Entity;
import com.me.Roguish.Model.MonsterUnit;
import com.me.Roguish.Model.Unit;
import java.math.*;
import java.util.Random;

public class AbilityController {
	
	private Random Dice = new Random();
	public static final int LONGSWORD = 20;
	public static final int SHIELD = 21;
	public static final int FIREBALL = 22;
	public static final int BITE = -2;
	public static final int STRONGBITE = -3;

	// B for Basic versions of Abilities
	// A for Advanced versions of Abilities
	public static final int B_AXE = 0;
	public static final int B_BOW = 1;
	public static final int B_XBOW = 2;
	public static final int B_SHURIKEN = 3;
	public static final int B_STAFF = 4;
	// 5
	public static final int B_SWORD = 6;	
	public static final int B_WAND = 7;
	public static final int A_AXE = 8;
	public static final int A_BOW = 9;
	public static final int A_XBOW = 10;
	public static final int A_SHURIKEN = 11;
	public static final int A_STAFF = 12;
	// 13
	public static final int A_SWORD = 14;
	public static final int A_WAND = 15;

	public static final int GALOSHES = 16;
	public static final int GAUNTLET = 17;
	public static final int HEALTHBOOST = 18;
	public static final int MANABOOST = 19;
	
	public AbilityController(){
	}
	
	public void activate(Entity origin, Entity target, int ability ){
		switch(ability){
			case (B_AXE):{
				((Unit)target).changeHP(-2 * Dice.nextInt(4));
				System.out.println("You swing your axe with great force");
				break;
			}
			case (B_BOW):{
				break;
			}
			case(B_XBOW):{
				break;
			}
			
			case(B_SHURIKEN):{
				break;
			}
			case (B_STAFF):{
				break;
			}
			case (B_WAND):{
				break;
			}
			case (B_SWORD):{
				break;
			}
			case (A_AXE):{
				break;
			}
			case (A_BOW):{
				break;
			}
			case (A_XBOW):{
				break;
			}
			case (A_SHURIKEN):{
				break;
			}
			case (A_STAFF):{
				break;
			}
			case (A_SWORD):{
				break;
			}
			case (A_WAND):{
				break;
			}
			case (GALOSHES):{
				break;
			}
			case (HEALTHBOOST):{
				break;
			}
			case (MANABOOST):{
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
					((Unit)target).changeHP(-Dice.nextInt(2));
				}
				break;
			}
			default:
				break;
		}
	}
	
public int getRange(int ability){
	switch(ability){
		case (B_BOW):{
			return 8;
		}
		case(B_XBOW):{
			return 6;
		}
		
		case(B_SHURIKEN):{
			return 3;
		}
		case (B_STAFF):{
			return 1;
		}
		case (B_WAND):{
			return 2;
		}
		case (B_SWORD):{
			return 1;
		}
		case (A_AXE):{
			return 1;
		}
		case (A_BOW):{
			return 9;
		}
		case (A_XBOW):{
			return 6;
		}
		case (A_SHURIKEN):{
			return 3;
		}
		case (A_STAFF):{
			return 1;
		}
		case (A_SWORD):{
			return 1;
		}
		case (A_WAND):{
			return 3;
		}
		case (GALOSHES):{
			return 0;
		}
		case (HEALTHBOOST):{
			return 0;
		}
		case (MANABOOST):{
			return 0;
		}
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

