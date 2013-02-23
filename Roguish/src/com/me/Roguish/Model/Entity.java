package com.me.Roguish.Model;

import com.badlogic.gdx.graphics.Texture;

public class Entity {
	private int x;
	private int y;
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
}
