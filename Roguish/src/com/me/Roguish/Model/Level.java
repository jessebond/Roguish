package com.me.Roguish.Model;
import com.me.Roguish.Model.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.g2d.tiled.SimpleTileAtlas;
import com.badlogic.gdx.graphics.g2d.tiled.TiledMap;
import com.badlogic.gdx.graphics.g2d.tiled.TiledLoader;
import com.badlogic.gdx.graphics.g2d.tiled.TileAtlas;

public class Level{
	private static int maxEntity = 16;
	private Array<Entity> entities = new Array<Entity>();
	
    public TiledMap map;
    public SimpleTileAtlas atlas;
    
	public Level(){
		create();
	
	}
	
	
	public void create(){
		System.out.println("In create");
		map = TiledLoader.createMap(Gdx.files.internal("data/level/test.tmx"));
		System.out.println("Tiles loaded");
	    atlas = new SimpleTileAtlas(map, Gdx.files.internal("data/"));
	    System.out.println("atlas made");
	}

}
