package com.me.Roguish.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.me.Roguish.Model.Entity;
import com.me.Roguish.Model.HeroUnit;
import com.me.Roguish.Model.MonsterUnit;
import com.me.Roguish.Model.Level;
import com.me.Roguish.Model.TurnQueue;

public class LevelController {
	private Level level;
	private Entity hero;
	
	enum Keys {
		LEFT, RIGHT, UP, DOWN
	}
	
	static Map<Keys, Boolean> keys = new HashMap<LevelController.Keys, Boolean>();
	static {
		keys.put(Keys.LEFT, false);
		keys.put(Keys.RIGHT, false);
		keys.put(Keys.UP, false);
		keys.put(Keys.DOWN, false);
	};
	
	public LevelController(Level level){
		this.level = level;
		this.hero = level.getHero();
		
	}
	
	// Main update method
	public void update(float delta){
		// process
		processInput();
		// do something
	}
	
	
	private void processInput(){
		if (keys.get(Keys.LEFT)){
			
		}
		if (keys.get(Keys.RIGHT)){
		}
		if (keys.get(Keys.DOWN)){
			
		}
		if (keys.get(Keys.UP)){
		}
	}
	
	
	// Keypresses
	public void leftPressed() {
		keys.get(keys.put(Keys.LEFT, true));
	}
	
	public void leftReleased() {
		keys.get(keys.put(Keys.LEFT, false));
		checkHeroTurn();
		if(hero.getX() > 0 && tileOpen(hero.getX() - 1, hero.getY())){
			level.queue.getNext();
			hero.movePosition(-1, 0);
			level.queue.add(hero);
		}
		System.out.println(level.getTile(hero.getX(), hero.getY()));
	}
	
	public void rightPressed() {
		keys.get(keys.put(Keys.RIGHT, true));
	}
	
	public void rightReleased() {
		keys.get(keys.put(Keys.RIGHT, false));
		checkHeroTurn();
		if(hero.getX() < 9 && tileOpen(hero.getX() + 1, hero.getY())){
			level.queue.getNext();
			hero.movePosition(1 , 0);
			level.queue.add(hero);
		}
		System.out.println(level.getTile(hero.getX(), hero.getY()));
	}
	
	public void upPressed() {
		keys.get(keys.put(Keys.UP, true));
	}
	
	public void upReleased() {
		keys.get(keys.put(Keys.UP, false));
		checkHeroTurn();
		if(hero.getY() > 0 && tileOpen(hero.getX(), hero.getY() - 1)){
			level.queue.getNext();
			hero.movePosition(0, -1);
			level.queue.add(hero);
		}
		System.out.println(level.getTile(hero.getX(), hero.getY()));
	}
	
	public void downPressed() {
		keys.get(keys.put(Keys.DOWN, true));
	}
	
	public void downReleased() {
		keys.get(keys.put(Keys.DOWN, false));
		checkHeroTurn();
		if(hero.getY() < 14 && tileOpen(hero.getX(), hero.getY() + 1)){
			level.queue.getNext();
			hero.movePosition(0, 1);
			level.queue.add(hero);
		}
		System.out.println(level.getTile(hero.getX(), hero.getY()));
	}
	
	public boolean tileOpen(int x, int y){
		for (Entity ent : level.getEntities()) {
			if (ent.getX() == x && ent.getY() == y && ent.getAlive()) return false;
		}
		if(level.tilePropCheck(x,y,"wall")) return false;
		else return true;
	}
	
	public void doMonsterTurns(){
		Random Dice = new Random();
		if (level.queue.getEnt() instanceof MonsterUnit){
			int index = findId(level.queue.getNext());
			if(adjacentHero(level.entities.get(index).getX(), level.entities.get(index).getX())){
				int n = Dice.nextInt(level.entities.get(index).getAbilities().size);
				level.ability.activate(level.entities.get(index), level.getHero(), n);
			}
			else{
				System.out.println("THere");
				level.entities.get(index).movePosition(Dice.nextInt(2), Dice.nextInt(2));
				if(level.entities.get(index).getAlive()) level.queue.add(level.entities.get(index));
			}
		}
			
			/*if(adjacentHero(level.queue..getX(), temp.getY())){
				int n = Dice.nextInt(temp.getAbilities().size);
				level.ability.activate(temp, hero, n);
				if(temp.getAlive()) level.queue.add(temp);
			}
			else{
				temp.movePosition(Dice.nextInt(1), Dice.nextInt(1));
				if(temp.getAlive()) level.queue.add(temp);
			}
			*/
	}
	
	
	public void checkHeroTurn(){
		System.out.println(level.queue.turnCount);
		while (!(level.queue.getEnt() instanceof HeroUnit)){
			System.out.println("Here");
			doMonsterTurns();
		}
	}
	
	public boolean adjacentHero(int x, int y){
		if ( (hero.getX() == x + 1 || hero.getX() == x -1)  && (hero.getY() == y))
			return true;
		if ( (hero.getY() == y + 1 || hero.getY() == y - 1) && (hero.getX() == x))
			return true;
		else return false;
	}
	
	public int findId(int x){
		for(int i = 0; i < level.entities.size; i++ ){
			if(x == level.entities.get(i).getId()) return i;
		}
		return -1;	
	}
	
}
