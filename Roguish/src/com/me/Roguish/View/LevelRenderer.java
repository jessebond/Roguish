package com.me.Roguish.View;

import com.me.Roguish.Model.Level;

import com.badlogic.gdx.Gdx;

public class LevelRenderer {

	private Level level;
	
	private boolean debug = false;
	
	public LevelRenderer(Level level, boolean debug) {
		this.level = level;	
		this.debug = debug;
	}
}
