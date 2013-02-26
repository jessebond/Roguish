package com.me.Roguish.Screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.me.Roguish.Roguish;

public class MenuScreen extends AbstractScreen{
	TextureAtlas guiAtlas;
	
	public MenuScreen(Roguish game){
		super(game);
	}
	
	@Override
    public void show(){
		Gdx.input.setInputProcessor(stage);
		
		guiAtlas = new TextureAtlas(Gdx.files.internal("data/gui/pack/Gui.pack"));
		
		TextureRegion ngUp = guiAtlas.findRegion("Btn_New");
		TextureRegion ngDown = guiAtlas.findRegion("Btn_New_Click");
		TextureRegion bg = guiAtlas.findRegion("MainMenu");
		
		ButtonStyle style = new ButtonStyle();
		style.up = new TextureRegionDrawable(ngUp);
		style.down = new TextureRegionDrawable(ngDown);
		Button startButton = new Button(style);
		
		Table table = new Table();
		table.setSize(480, 320);
		table.setBackground(new TextureRegionDrawable(bg));
		stage.addActor(table);
		table.bottom();
		table.debug();
				
		startButton.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				System.out.println("New Game Button Down");
				game.setScreen(new GameScreen(game));
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

		//Table.drawDebug(stage);
	}
	
	@Override
	public void dispose(){
		guiAtlas.dispose();
		stage.dispose();
		
	}
	
	public void resize (int width, int height) {
		stage.setViewport(480, 320, true);
		stage.getCamera().translate(-stage.getGutterWidth(), -stage.getGutterHeight(), 0);
	}
	
	public boolean needsGL20 () {
		return true;
	}
	
}