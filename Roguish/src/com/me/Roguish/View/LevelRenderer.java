package com.me.Roguish.View;

import com.me.Roguish.Model.Level;

import com.badlogic.gdx.Gdx;

public class LevelRenderer {

	private Level level;
	
	private boolean debug = false;
	private int width;
	private int height;
	
	public LevelRenderer(Level level, boolean debug) {
		this.level = level;	
		this.debug = debug;
	}
	
	public void setSize (int width, int height) {
		this.width = width;
		this.height = height;
	}
}
