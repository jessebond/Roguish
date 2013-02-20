package com.me.Roguish.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.me.Roguish.Roguish;

public abstract class AbstractScreen implements Screen {
	
	Roguish game;
	
	public AbstractScreen(Roguish game){
		this.game = game;
	}
	
	@Override
	public void resize (int width, int height) {
	}

	@Override
	public void show () {
	}

	@Override
	public void hide () {
	}

	@Override
	public void pause () {
	}

	@Override
	public void resume () {
	}

	@Override
	public void dispose () {
	}
}
