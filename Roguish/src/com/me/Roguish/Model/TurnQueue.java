package com.me.Roguish.Model;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

import com.badlogic.gdx.utils.Array;

public class TurnQueue implements Queue<Entity> {
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
		entities.sort();
		for (Entity enti : entities) {
			add(enti);
		}
		turnCount = 0;
	}
	
	public Entity getNext(){
		if (peek() instanceof HeroUnit){
			turnCount++;
		}
		if (peek() instanceof HeroUnit || peek() instanceof MonsterUnit && peek().getAlive()) 
			add(peek());
		return remove();
	}
	
	
	@Override
	public boolean addAll(Collection<? extends Entity> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Iterator<Entity> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean add(Entity e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Entity element() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean offer(Entity e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Entity peek() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Entity poll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Entity remove() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
