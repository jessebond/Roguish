package com.me.Roguish.Model;

import com.badlogic.gdx.graphics.Texture;

public class Entity implements Comparable<Entity> {
	private int x;
	private int y;
	private int movement;
	private boolean alive = true;
	private String texture;

	public Entity(int x, int y, String texture){
		this.x = x;
		this.y = y;
		this.texture = texture;
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
		return this.movement;
	}
	
	public void setMovement(int mov){
		this.movement = mov;
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
		return this.movement - ent.movement;
	}
}
