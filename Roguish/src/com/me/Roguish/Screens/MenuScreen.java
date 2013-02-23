package com.me.Roguish.Screens;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.me.Roguish.Roguish;

public class MenuScreen extends AbstractScreen implements InputProcessor{
	TextureRegion title;
	TextureRegion startGame;
	SpriteBatch batch;
	float time = 0;
	
	public MenuScreen(Roguish game){
		super(game);
	}
	
	@Override
	public void show () {
		title = new TextureRegion(new Texture(Gdx.files.internal("data/entity/Hero.png")), 0, 0, 480, 320);
		startGame = new TextureRegion(new Texture(Gdx.files.internal("data/Start.png")), 0, 0, 240, 160 );
		batch = new SpriteBatch();
		batch.getProjectionMatrix().setToOrtho2D(0, 0, 480, 320);
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render (float delta) {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(title, 0, 0);
		batch.draw(startGame, 40, 40);
		batch.end();

		time += delta;
		if (time > 1) {
			if  (Gdx.input.getX() > 40 && Gdx.input.getX() < 280 && Gdx.input.getY() > 40 && Gdx.input.getY() < 200  ) {
				game.setScreen(new GameScreen(game));
			}
		} 
	}

	@Override
	public void hide () {
		Gdx.app.debug("Roguish", "dispose main menu");
		batch.dispose();
		title.getTexture().dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
