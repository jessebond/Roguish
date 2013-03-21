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
	
	// Negative numbers used to designate monster abilities. (These cannot be selected by the CHAOS skill)
	public static final int BITE = -2;
	public static final int STRONGBITE = -3;
	public static final int WEB = -4;
	public static final int SHADOWSTRIKE = -5;

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
	public static final int CHAOS = 23;
	public static final int TELEPORT = 24;
	public static final int DRAIN = 25;
	public static final int TOUCHDRAIN = 26;
	
	public AbilityController(){
	}
	
	public void activate(Entity origin, Entity target, int ability ){
		switch(ability){
			case (B_AXE):{
				((Unit)target).changeHP(-1 * Dice.nextInt(12));
				System.out.println("You swing your axe with great force");
				break;
			}
			case (B_BOW):{
				((Unit) target).changeHP( -1 * (Dice.nextInt(8))); 
				break;
			}
			case(B_XBOW):{
				((Unit) target).changeHP( -1 * (Dice.nextInt(9))); 
				break;
			}
			
			case(B_SHURIKEN):{
				((Unit) target).changeHP( -1 * Dice.nextInt(5) * Dice.nextInt(5));
				break;
			}
			case (B_STAFF):{
				((Unit)target).changeHP(-2 * (int) Math.round(.5 * ((Unit)origin).getInt()));
				break;
			}
			case (B_WAND):{
				((Unit)target).changeHP(-1 * (int) Math.round(.5 * ((Unit)origin).getInt()));
				break;
			}
			case (B_SWORD):{
				((Unit)target).changeHP(-1 * Dice.nextInt(10));
				((Unit)origin).updateMovement(2);
				break;
			}
			case (A_AXE):{
				((Unit)target).changeHP(-1 * Dice.nextInt(14));
				break;
			}
			case (A_BOW):{
				((Unit) target).changeHP( -1 * (Dice.nextInt(9)));
				break;
			}
			case (A_XBOW):{
				((Unit)target).changeHP(-1 * Dice.nextInt(10));
				break;
			}
			case (A_SHURIKEN):{
				((Unit) target).changeHP( -1 * Dice.nextInt(5) * Dice.nextInt(5) + 4);
				break;
			}
			case (A_STAFF):{
				((Unit)target).changeHP(-2 * (int) Math.round(.9 * ((Unit)origin).getInt()) + 2);
				break;
			}
			case (A_SWORD):{
				((Unit)target).changeHP(-1 * Dice.nextInt(12));
				((Unit)origin).updateMovement(2);
				break;
			}
			case (A_WAND):{
				((Unit)target).changeHP(-1 * (int) Math.round(.5 * ((Unit)origin).getInt()));
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
					((Unit)target).changeHP(-1 * Dice.nextInt(2));
				}
				break;
			}
			case(CHAOS):{
				if(((Unit)origin).getMana() >= 5){
					activate(origin, target,  Dice.nextInt(24) );
					((Unit)origin).updateMana(-5);
				}
			}
			case(TELEPORT):{
				if(((Unit)origin).getMana() >= 7){
					origin.movePosition(Dice.nextInt(10), Dice.nextInt(10));
					((Unit)origin).updateMana(-7);
				}
			}
			case(FIREBALL):{
				if(((Unit)origin).getMana() >= 7){
					((Unit)target).changeHP(-15 + (int) Math.round(.5 * ((Unit)origin).getInt()));
				}
			}
			case(DRAIN):{
				if(((Unit)origin).getMana() >= 5){
					int x = Dice.nextInt(4);
					((Unit)target).changeHP(-1 * x);
					((Unit)origin).changeHP(x);
					((Unit)origin).updateMana(-5);
				}
			}
			case(TOUCHDRAIN):{
				if(((Unit)origin).getMana() >= 5){
					int x = Dice.nextInt(6);
					((Unit)target).changeHP(-1 * x);
					((Unit)origin).changeHP(x);
					((Unit)origin).updateMana(-5);
				}
				
			}
			case(WEB):{
				if(((Unit)origin).getMana() >= 10){
					((Unit)target).updateMovement(10);
					((Unit)origin).updateMana(-5);
				}
			}
			case(SHADOWSTRIKE):{
				((Unit)target).changeHP(-1* (int) Math.round(((Unit)target).getHP()/10));
				
			}
			default:
				break;
		}
	}
	
public int getRange(int ability){
	switch(ability){
		case (B_AXE):{
			return 1;
		}
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
			case(CHAOS):{
				return 10;
			}
			case(TELEPORT):{
				return 9999999;
			}
			case(DRAIN):{
				return 4;
			}
			case(TOUCHDRAIN):{
				return 1;
			}
			case(WEB):{
				return 2;
			}
			case(SHADOWSTRIKE):{
				return 1;
			}
			default: 
				return 0;
		}
	}
}

