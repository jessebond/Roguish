package com.me.Roguish.Model;

public class Entity {
	private int x;
	private int y;
	private boolean alive = true;

	public Entity(int x, int y){
		this.x = x;
		this.y = y;
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
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void movePosition(int dx, int dy){
		this.x += dx;
		this.y += dy;		
	}
	
	public void setAlive(boolean alive){
		this.alive = alive;
	}
}
