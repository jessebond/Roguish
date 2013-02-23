package com.me.Roguish.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.me.Roguish.Roguish;

public class SplashScreen extends AbstractScreen {
	
	TextureRegion intro;
	SpriteBatch batch;
	float time = 0;

    public SplashScreen(Roguish game){
        super(game);
    }

    @Override
	public void show () {
		intro = new TextureRegion(new Texture(Gdx.files.internal("data/Splash_512x512.png")), 0, 200, 480, 320);
		batch = new SpriteBatch();
		batch.getProjectionMatrix().setToOrtho2D(0, 0, 480, 320);
	}

	@Override
	public void render (float delta) {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(intro, 0, 0);
		batch.end();

		time += delta;
		if (time > 1) {
			if (Gdx.input.isKeyPressed(Keys.ANY_KEY) || Gdx.input.justTouched()) {
				game.setScreen(new MenuScreen(game));
			}
		}
	}

	@Override
	public void hide () {
		Gdx.app.debug("Roguish", "dispose intro");
		batch.dispose();
		intro.getTexture().dispose();
	}

}
