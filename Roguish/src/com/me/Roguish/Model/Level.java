package com.me.Roguish.Model;
import com.me.Roguish.Controller.AbilityController;
import com.me.Roguish.Model.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.g2d.tiled.SimpleTileAtlas;
import com.badlogic.gdx.graphics.g2d.tiled.TiledMap;
import com.badlogic.gdx.graphics.g2d.tiled.TiledLoader;
import java.util.Random;

public class Level{
	public Array<Entity> entities = new Array<Entity>();
	public TurnQueue queue;
	public AbilityController ability = new AbilityController();
    public TiledMap map;
    public SimpleTileAtlas atlas;
    public HeroUnit hero;
    private Random Dice = new Random();
    public MonsterUnit rat1 = new MonsterUnit(1, 2, "E_Rat", new Array<Integer>(), MonsterUnit.RAT);
    public MonsterUnit rat2 = new MonsterUnit(2, 1, "E_Rat", new Array<Integer>(), MonsterUnit.RAT);
    public MonsterUnit rat3 = new MonsterUnit(2, 2, "E_Rat", new Array<Integer>(), MonsterUnit.RAT);
    public MonsterUnit bat1 = new MonsterUnit(1, 4, "E_Bat", new Array<Integer>(), MonsterUnit.BAT);
    public MonsterUnit spider1 = new MonsterUnit(1, 6, "E_Spider", new Array<Integer>(), MonsterUnit.SPIDER);
    public MonsterUnit shadow1 = new MonsterUnit(1, 7, "E_Shadow", new Array<Integer>(), MonsterUnit.SHADOW);
    public Entity winChest = new Entity(4,13,"Chest", new Array<Integer>());
    private MonsterUnit mon;
    
	public Level(ClassCard cCard){
		hero =  new HeroUnit(5, 5, cCard.getClassName(), new Array<Integer>(), cCard);
		create();
		setStats();
		populate();
		queue = new TurnQueue(getEntities());
	}
	
	public Level(ClassCard cCard, Array<Integer> abilities) {
		for(int i = 0; i < abilities.size; i++)
			System.out.println(abilities.get(i));
		hero =  new HeroUnit(5, 5, cCard.getClassName(),  new Array<Integer>(), cCard);
		for(int i = 0; i < abilities.size; i++ )
			hero.addAbility(abilities.get(i));
		create();
		setStats();
		populate();
		queue = new TurnQueue(getEntities());
	}
	
	
	// The below will work once the tileOpen() method is added to level.
	
	/*
	
	private void generateEntities(){
		// This can be scaled as the level difficulty
		int area = map.height * map.width;
		int totalMon = (int) area / 5;
		
		for(int i = 0; i < totalMon; i++){
			
			// Rewrite once level controller gets refactored
			int[] x = findOpenXY();
			
			//Update as new units are created
			int monType = Dice.nextInt(6);
			switch(monType){
			case MonsterUnit.RAT: mon = new MonsterUnit(x[0], x[1], "E_Rat", new Array<Integer>(), MonsterUnit.RAT); break;
			case MonsterUnit.BAT: mon = new MonsterUnit(x[0], x[1], "E_Bat", new Array<Integer>(), MonsterUnit.BAT); break;
			case MonsterUnit.SPIDER: mon = new MonsterUnit(x[0], x[1], "E_Spider", new Array<Integer>(), MonsterUnit.BAT); break;
			case MonsterUnit.SHADOW: mon = new MonsterUnit(x[0], x[1], "E_Monster", new Array<Integer>(), MonsterUnit.SHADOW); break;
			}
			
			mon.setId(1 + i);
			addEntity(mon);
		
			
		}
	}
	*/

	private void setStats() {
		 hero.setId(0);
		 rat1.setId(1);
		 rat2.setId(2);
		 rat3.setId(3);
		 bat1.setId(4);
		 spider1.setId(5);
		 shadow1.setId(6);
		 winChest.setId(1337);
		 winChest.setAlive(false);
		
	}

	public void create(){
		System.out.println("In create");
		map = TiledLoader.createMap(Gdx.files.internal("data/level/test_FoV.tmx"));
		System.out.println("Tiles loaded");
	    atlas = new SimpleTileAtlas(map, Gdx.files.internal("data/"));
	    System.out.println("atlas made");  
	   
	}

	
	private void addEntity(Entity ent){
		entities.add(ent);
	}
	
	private boolean removeEntity(Entity ent){
		return entities.removeValue(ent, true);
	}
	
	public HeroUnit getHero(){
		return hero;
	}
		// Populates entity list
	private void populate(){

		addEntity(hero); 
		addEntity(rat1);
		addEntity(rat2);
		addEntity(rat3);
		addEntity(bat1);
		addEntity(spider1);
		addEntity(shadow1);
		addEntity(winChest);
	}
	
	public Array<Entity> getEntities(){
		return this.entities;
	}
	
	public boolean tilePropCheck(int x, int y, String property){
		return ("true".equals(map.getTileProperty(getTile(x,y), property)));
	}
	public int getTile(int x, int y, int layer){
		return map.layers.get(layer).tiles[y][x];
	}
	
	public boolean tileExists(int x, int y, int layer){
		try{
			int tmp = map.layers.get(layer).tiles[y][x];
			return true;
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
	}
	
	
	public int getTile(int x, int y){
		if(x >= 0 && y>= 0)
			return map.layers.get(0).tiles[y][x];
		else return 0;
	}
	
}
