package com.me.Roguish.Model;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

import com.badlogic.gdx.utils.Array;

public class TurnQueue implements Queue<Entity> {
	// Possible issue is state of entities not being updated after their turn...
	// Fix this by moving the check alive logic into the Controller
	
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
		// This logic should be added to the level controller rather than here.
		/*
		if (peek() instanceof HeroUnit || peek() instanceof MonsterUnit && peek().getAlive()) 
			add(peek());
		*/
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
