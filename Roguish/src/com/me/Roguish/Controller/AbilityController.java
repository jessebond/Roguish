package com.me.Roguish.Controller;

import com.me.Roguish.Model.Entity;
import com.me.Roguish.Model.MonsterUnit;
import com.me.Roguish.Model.Unit;
import java.math.*;
import java.util.Random;

public class AbilityController {
	
	private Random Dice = new Random();
		
	
	// Negative numbers used to designate monster abilities. (These cannot be selected by the CHAOS skill)
	public static final int BITE = -2;
	public static final int STRONGBITE = -3;
	public static final int WEB = -4;
	public static final int SHADOWSTRIKE = -5;
	public static final int MAUL = -6;

	// B for Basic versions of Abilities
	// A for Advanced versions of Abilities
	public static final int B_AXE = 0;
	public static final int B_BOW = 1;
	public static final int B_XBOW = 2;
	public static final int B_SHURIKEN = 3;
	public static final int B_STAFF = 4;
	public static final int B_SWORD = 5;
	public static final int ICEBOLT = 6;
	public static final int GALOSHES = 7;
	public static final int GAUNTLET = 8;
	public static final int HEALTHBOOST = 9;
	public static final int MANABOOST = 10;
	public static final int CHAOS =  11;
	public static final int TELEPORT = 12;
	public static final int DRAIN = 13;
	public static final int TOUCHDRAIN = 14;
	public static final int B_WAND = 16;
	public static final int FIREBALL = 18;
	public static final int EARTHQUAKE = 19;
	
	public static final int LONGSWORD = 20;
	public static final int SHIELD = 21;

	/*
	public static final int A_AXE = 17;    
	public static final int A_BOW = 18;    
	public static final int A_XBOW = 19;  
	public static final int A_SHURIKEN = 23;  
	public static final int A_STAFF = 24;    
											
	public static final int A_SWORD = 26;  
	public static final int A_WAND = 15;
	*/

	
	
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
				break;
			}
			case(TELEPORT):{
				if(((Unit)origin).getMana() >= 7){
					origin.movePosition(Dice.nextInt(10), Dice.nextInt(10));
					((Unit)origin).updateMana(-7);
				}
				break;
			}
			case(FIREBALL):{
				if(((Unit)origin).getMana() >= 7){
					((Unit)target).changeHP(-8 + (int) Math.round(.5 * ((Unit)origin).getInt()));
					((Unit)origin).updateMana(-7);
				}
				break;
			}
			case(DRAIN):{
				if(((Unit)origin).getMana() >= 5){
					int x = Dice.nextInt(4);
					((Unit)target).changeHP(-1 * x);
					((Unit)origin).changeHP(x);
					((Unit)origin).updateMana(-5);
				}
				break;
			}
			case(TOUCHDRAIN):{
				if(((Unit)origin).getMana() >= 5){
					int x = Dice.nextInt(6);
					((Unit)target).changeHP(-1 * x);
					((Unit)origin).changeHP(x);
					((Unit)origin).updateMana(-5);
				}
				break;	
			}
			case(ICEBOLT):{
				if(((Unit)origin).getMana() >= 7){
					((Unit)target).changeHP(-6 + (int) Math.round(.5 * ((Unit)origin).getInt()));
					((Unit)target).updateMovement(10);
					((Unit)origin).updateMana(-7);
				}
				break;	
			}
			case(EARTHQUAKE):{
				if(((Unit)origin).getMana() >= 5){
					((Unit)target).changeHP(-5 + (int) Math.round(.4 * ((Unit)origin).getInt()));
					((Unit)origin).updateMana(-5);
					((Unit)target).movePosition(Dice.nextInt(2) * (-1 * Dice.nextInt(2)), Dice.nextInt(2) * (-1 * Dice.nextInt(2)));
				}
				break;	
			}
			case(WEB):{
				if(((Unit)origin).getMana() >= 10){
					((Unit)target).updateMovement(10);
					((Unit)origin).updateMana(-5);
				}
				break;
			}
			case(SHADOWSTRIKE):{
				((Unit)target).changeHP(-1* (int) Math.round(((Unit)target).getHP()/6) + 1 );
				break;
				
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
			case(ICEBOLT):{
				return 8;
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

