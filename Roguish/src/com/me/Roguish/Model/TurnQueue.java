package com.me.Roguish.Model;

import java.util.LinkedList;
import java.util.Queue;

import com.badlogic.gdx.utils.Array;

public class TurnQueue{
	
	public int turnCount;
	Queue<Entity> queue = new LinkedList<Entity>();
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
		if (queue.peek() instanceof HeroUnit){
			turnCount++;
			System.out.println(turnCount);
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
