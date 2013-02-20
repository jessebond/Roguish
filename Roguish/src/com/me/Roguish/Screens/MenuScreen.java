package com.me.Roguish.Screens;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.me.Roguish.Roguish;

public class MenuScreen extends AbstractScreen {
	
	public MenuScreen(Roguish game){
		super(game);
	}
	
	@Override
	public void show(){
		super.show();
		Table table = super.getTable();
		table.add("Welcome to Roguish").spaceBottom(50);
		table.row();
		
		//Setup Start Game button
		TextButton startGameButton = new TextButton("Start Match", getSkin());
		startGameButton.addListener(new DefaultActorListener(){
			@Override
			public void touchUp(ActorEvent event, float x, float y, int pointer, int button){
				super.touchUp(event, x, y, pointer, button);
				game.setScreen(new StartGameSCreen(game));
			}
		});
		
	}
}
