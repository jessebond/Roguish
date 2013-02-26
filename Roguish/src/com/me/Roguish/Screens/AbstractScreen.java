package com.me.Roguish.Screens;

import com.badlogic.gdx.Screen;
import com.me.Roguish.Roguish;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public abstract class AbstractScreen implements Screen {
	
	protected Roguish game;
	protected Stage stage;
	public SpriteBatch batch;
	
	public AbstractScreen(Roguish game){
		this.game = game;
		this.stage = new Stage(0,0,true);
	}
	
	public SpriteBatch getBatch(){
        if(batch == null){
            batch = new SpriteBatch();
        }
        return batch;
    }
	
	@Override
	public void resize (int width, int height) {
	}

	@Override
	public void show () {
	}

	@Override
	public void hide () {
		dispose();
	}

	@Override
	public void pause () {
	}

	@Override
	public void resume () {
	}

	@Override
	public void dispose () {
		stage.dispose();
	}
}
