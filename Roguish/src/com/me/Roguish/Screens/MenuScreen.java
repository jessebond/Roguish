package com.me.Roguish.Screens;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
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
		
		TextureRegion ngUp = atlas.findRegion("Btn_Start.png");
		TextureRegion ngDown = atlas.findRegion("Btn_Start_Click.png");
		
		ButtonStyle style = new ButtonStyle();
		style.up = new TextureRegionDrawable(ngUp);
		style.down = new TextureRegionDrawable(ngDown);
		Button startButton = new Button(style);
		
		
		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
		table.setSize(260, 195);
		table.setPosition(190, 142);
		
		startButton.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				System.out.println("touchDown 1");
				return false;
			}
		});
		table.add(startButton);
        
		
        
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
	
	}
	
	@Override
	public void dispose(){
		atlas.dispose();
		stage.dispose();
		
	}
	
	
}