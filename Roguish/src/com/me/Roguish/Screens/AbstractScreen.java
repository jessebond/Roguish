package com.me.Roguish.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.me.Roguish.Roguish;

public class AbstractScreen implements Screen {
	
	protected Roguish game;
	protected  BitmapFont font;
	protected SpriteBatch batch;
	protected Stage stage;
	protected Skin skin;
    protected TextureAtlas atlas;
    protected Table table;
	
	public AbstractScreen(Roguish game){
		this.game = game;
		this.font = new BitmapFont();
		this.batch = new SpriteBatch();
		this.stage = new Stage(0, 0, true);
	}
	
	//Returns the Screen's Name (Splash Screen, Menu Screen etc)
	protected String getName(){
		return getClass().getSimpleName();
	}
	
	protected boolean isGameScreen(){
		return false;
	}
	
	public BitmapFont getFont(){
		if (font == null) font = new BitmapFont();
		return font;
	}
	
	public SpriteBatch getBatch(){
		if(batch == null) batch = new SpriteBatch();
		return batch;
	}
	
	public TextureAtlas getAtlas(){
		if(atlas == null) atlas = new TextureAtlas();
		return atlas;
	}
	
	protected Skin getSkin(){
		if(skin == null) skin = new Skin();
		return skin;
	}
	
	protected Table getTable(){
		if (table == null){
			table = new Table(getSkin());
			table.setFillParent(true);
			stage.addActor(table);
		}
		
		return table;
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
		//Clear screen with black.
        Gdx.gl.glClearColor( 0f, 0f, 0f, 1f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

        // update and draw the stage actors
        stage.act( delta );
        stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
		//Determing what Roguish.LOG does first
		//Gdx.app.log(Roguish.LOG, "Resizing screen: " + getName() + " to " + width + " by " + height);

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
		stage.dispose();
		batch.dispose();
		font.dispose();
		skin.dispose();
		atlas.dispose();
		

	}

}
