package com.me.Roguish;

import com.me.Roguish.Screens.*;
import com.me.Roguish.Controller.LibraryManager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;

public class Roguish extends Game {
	boolean firstTimeCreate = true;
	FPSLogger fps;
	
	// Managers
	private LibraryManager libraryManager;
	
    public LibraryManager getProfileManager(){
        return libraryManager;
    }

	
	@Override
	public void create() {	
		// Load card libraries
		libraryManager = new LibraryManager();
		libraryManager.retrieveClassLibrary();
		libraryManager.retrieveRaceLibrary();
		
		// Set current Screen to SplashScreen
		setScreen(new SplashScreen(this));
		fps = new FPSLogger();
	}

	@Override
	public void dispose() {
		super.dispose();
		getScreen().dispose();
	}

	@Override
	public void render() {		
		super.render();
		fps.log();
	}
	
	 @Override
	 public void pause()
	 {
		 libraryManager.persist();  // don't know if player is coming back so save library
	 }	
	

}
