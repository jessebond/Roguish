package com.me.Roguish.Screens;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.me.Roguish.Roguish;

public class MenuScreen extends AbstractScreen{
	TextureAtlas atlas;
	
	public MenuScreen(Roguish game){
		super(game);
	}
	
	@Override
    public void show(){
		Gdx.input.setInputProcessor(stage);
		
		atlas = new TextureAtlas(Gdx.files.internal("data/gui/pack/Gui.atlas"));
		
		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
        table.add("Welcome to Roguish for Android!").spaceBottom(50);
        table.row();
        
        TextButton newGameButton = new TextButton("New game", getSkin());
        
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}