package com.me.Roguish.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.me.Roguish.Roguish;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.files.FileHandle;


public abstract class AbstractScreen implements Screen {
	
	protected Roguish game;
	protected Stage stage;
	private Skin skin;
	
	public AbstractScreen(Roguish game){
		this.game = game;
		this.stage = new Stage(0,0,true);
	}
	
	protected Skin getSkin(){
		if(skin == null ) {
            FileHandle skinFile = Gdx.files.internal( "data/gui/pack/Gui.json" );
            skin = new Skin( skinFile );
        }
        return skin;
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
