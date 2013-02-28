package com.me.Roguish.Screens;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.Scaling;


import com.me.Roguish.Roguish;
import com.me.Roguish.Model.Level;
import com.me.Roguish.View.LevelRenderer;
import com.me.Roguish.Controller.LevelController;
import com.me.Roguish.Model.ClassCard;

public class GameScreen extends AbstractScreen implements InputProcessor {
	private Level level;
	private LevelRenderer renderer;
	private LevelController controller;
	private ClassCard cCard;
	
	private int width, height;
	
	private TextureAtlas guiAtlas;
	private TextureAtlas entAtlas;
	
	private TextureRegion menuUp;
	private TextureRegion menuDown;
	private TextureRegion c_hero;
	private TextureRegion hud;
	private ButtonStyle menuStyle;
	private Image ihud;
	private Image ic_hero;

 
	public GameScreen(Roguish game, ClassCard cCard){
        super(game);
        this.cCard = cCard;
        
		level = new Level(cCard);
		renderer = new LevelRenderer(level, true);
		controller = new LevelController(level);
    }
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(this);
		
		loadGui();
		
		Button menuButton = new Button(menuStyle);
		System.out.println("delta: " + (Gdx.graphics.getWidth() - stage.getWidth()));
		System.out.println("screen: " + Gdx.graphics.getWidth());
		System.out.println("stage: " + stage.getWidth());
		
		
		Table table = new Table();
		table.setSize(480, 320);
		table.setPosition(90, 0);
		table.right();
		table.debug();
		
		stage.addActor(table);
		stage.addActor(ic_hero);
		
		table.add(ihud);
		table.row();
		
		menuButton.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				System.out.println("Back Button Down");
				game.setScreen(new MenuScreen(game));
				return false;
			}
		});
		table.add(menuButton);
	}

	private void loadGui(){
		System.out.println("ChooseClassScreen:LoadGui()");
		guiAtlas = new TextureAtlas(Gdx.files.internal("data/gui/pack/Gui.pack"));
		entAtlas = new TextureAtlas(Gdx.files.internal("data/entity/pack/Entities.pack"));
		
		menuUp = guiAtlas.findRegion("Btn_Menu");
		menuDown = guiAtlas.findRegion("Btn_Menu_Click");
		hud = guiAtlas.findRegion("Hud");
		
		menuStyle = new ButtonStyle();
		menuStyle.up = new TextureRegionDrawable(menuUp);
		menuStyle.down = new TextureRegionDrawable(menuDown);
	
		ihud = new Image(hud);
		ihud.setScaling(Scaling.fill);
		
		c_hero = entAtlas.findRegion(cCard.getFaceName());
		ic_hero = new Image(c_hero);
		ic_hero.setScaling(Scaling.fill);
		ic_hero.setPosition(394, 197);
		
	}
	
	

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);

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
		//Gdx.input.setInputProcessor(null);
		guiAtlas.dispose();
		entAtlas.dispose();
		stage.dispose();
	}
	
	
	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.LEFT)
			controller.leftPressed();
		if (keycode == Keys.RIGHT)
			controller.rightPressed();
		if (keycode == Keys.UP)
			controller.upPressed();
		if (keycode == Keys.DOWN)
			controller.downPressed();
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.LEFT)
			controller.leftReleased();
		if (keycode == Keys.RIGHT)
			controller.rightReleased();
		if (keycode == Keys.UP)
			controller.upReleased();
		if (keycode == Keys.DOWN)
			controller.downReleased();
		return true;
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
		// TODO Auto-generated method stub
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

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		controller.update(delta);
		renderer.render();
		if(controller.gameOver) game.setScreen(new GameOverScreen(game));
		if(controller.gameWon) game.setScreen(new GameWonScreen(game));

		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		//Table.drawDebug(stage);
	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(480, 320, true);
		renderer.setSize(width, height);
		this.width = width;
		this.height = height;

	}
}
