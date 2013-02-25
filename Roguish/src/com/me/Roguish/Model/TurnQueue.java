package com.me.Roguish.Model;

import com.badlogic.gdx.utils.Array;

public class TurnQueue {
	// First sort the array of entities based on the unit's base dexterity.
	// Then add the entities to the queue based on that order.
	// Create a getNext() method that will return the next entity in the loop,
	// remove it from the list and then add it to the back. If the entity removed
	// was a HeroUnit increase the turn count by 1. This method should also ensure
	// that the entity is alive before returning it.
	// Create a peek() method that returns the next entity in the loop without 
	// removing it from the front.
	// Create the necessary add() methods
	
	public int turnCount;
	Array<Entity> entities;
	public TurnQueue(Array<Entity> ent){
		this.entities = ent;
		turnCount = 0;
	}
	
}
