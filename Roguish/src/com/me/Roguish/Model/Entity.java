package com.me.Roguish.Model;

import com.badlogic.gdx.utils.Array;

public class Entity implements Comparable<Entity> {
	private int x;
	private int y;
	private int id;
	// Base movement is the entities movement dictated by their dexterity stat. After each turn currentMovement gets reset to this value.
	private int baseMovement;
	// Current movement is the entities movement after various modifications by skills & traps . This is the value that turns are determined by.
	private int currentMovement;
	private boolean alive = true;
	private String texture;
	private Array<Integer> abilities = new Array<Integer>();

	public Entity(int x, int y, String texture, Array<Integer> a){
		this.x = x;
		this.y = y;
		this.texture = texture;
		this.abilities = new Array<Integer>(a);
	}
	
	public void addAbility(int x){
		abilities.add(x);
	}
	
	public Array<Integer> getAbilities(){
		return this.abilities;
	}
	
	public void setId(int x){
		this.id = x;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public boolean getAlive(){
		return this.alive;
	}
	
	public String getTexture(){
		return this.texture;
	}
	
	public int getMovement(){
		return this.baseMovement;
	}
	
	public void resetMovement(){
		this.currentMovement = this.baseMovement;
	}
	
	public void setMovement(int mov){
		this.baseMovement = mov;
	}
	
	public void updateMovement(int delta){
		this.currentMovement += delta;
		if(this.currentMovement < 0)
			this.currentMovement = 0;
	}
	
	public void setPosition(int x, int y){
		System.out.println("Enter setposition function");
		this.x = x;
		this.y = y;
		System.out.println("Exit setposition function");

	}
	
	public void movePosition(int dx, int dy){
		this.x += dx;
		this.y += dy;		
	}
	
	public void setAlive(boolean alive){
		this.alive = alive;
	}

	
	public int compareTo(Entity ent) {
		return this.currentMovement - ent.currentMovement;
	}


	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
}
