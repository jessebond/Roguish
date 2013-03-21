package com.me.Roguish.Model;

import java.util.PriorityQueue;
import com.badlogic.gdx.utils.Array;

public class TurnQueue{
	
	public int turnCount;
	PriorityQueue<Entity> queue = new PriorityQueue<Entity>();
	Array<Entity> entities;
	public Level level;
	public TurnQueue(){
		turnCount = 0;
		
	}
	public TurnQueue(Array<Entity> ent){
		this.entities = ent;
		entities.sort();
		for (Entity enti : entities) {
			queue.add(enti);
		}
		turnCount = 0;
	}
	
	public int getNext(){
		turnCount++;
		for (Entity enti : entities) {
			enti.updateMovement(-1);
		}
		return queue.remove().getId();
	}
	
	public int peek(){
		return queue.peek().getId();
	}
	
	public Entity getEnt(){
		return queue.peek();
	}
	
	public void add(Entity ent){
		queue.add(ent);
	}
}
