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
		map = TiledLoader.createMap(Gdx.files.internal("data/level/test2.tmx"));
		System.out.println("Tiles loaded");
	    atlas = new SimpleTileAtlas(map, Gdx.files.internal("data/"));
	    System.out.println("atlas made");
	    populate();
	    
	}

	
	private void addEntity(Entity ent){
		entities.add(ent);
	}
	
	private boolean removeEntity(Entity ent){
		return entities.removeValue(ent, true);
	}
	
	
	// Populates entity list
	private void populate(){
		addEntity(new Entity(1, 1, "data/Hero.png")); // temporary entity gen
		addEntity(new Entity(1, 2, "data/Enemy.png"));
		addEntity(new Entity(2, 1, "data/Enemy.png"));
		addEntity(new Entity(2, 2, "data/Hero.png"));	
	}
	
	public Array<Entity> getEntities(){
		return this.entities;
	}
}
