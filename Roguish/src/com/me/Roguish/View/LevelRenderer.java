package com.me.Roguish.View;

import com.me.Roguish.Model.Level;
import com.me.Roguish.Model.Entity;
import com.me.Roguish.Model.MonsterUnit;

import java.lang.Math;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.tiled.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector3;

public class LevelRenderer {
	private static final float CAMERA_WIDTH = 320f;
	private static final float CAMERA_HEIGHT = 480f;
	private static final float RUNNING_FRAME_DURATION = 0.06f;
	private static final int VIEW_RADIUS = 6;
	public int TILE_BLACK = 0;
	private static final int TILE_CLEAR = 1;
	//private static final float TILE_WIDTH = 32f;
	
	private Level level;
	private OrthographicCamera cam;
	
	private ShapeRenderer shapeRenderer = new ShapeRenderer();
	
	//Texture Regions
	private TextureRegion heroTexture;
	
	private boolean debug = false;
	private int width;
	private int height;
	private float ppuX;	// pixels per unit on the X axis
	private float ppuY;	// pixels per unit on the Y axis
	private float offsetX;
	private float offsetY;
	private float ratioS;
	private float ratio;
	private float centerX; // centered tile x
	private float centerY; // centered tile y
	private TileMapRenderer tileMapRenderer;
	private SpriteBatch spriteBatch;
	private BitmapFont font;
	
	private TextureAtlas atlas;
	
	public LevelRenderer(Level level, boolean debug) {
		setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		this.level = level;	
		this.debug = debug;
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		
		ratioS = CAMERA_WIDTH/CAMERA_HEIGHT;
		ratio = (float) Gdx.graphics.getHeight()/Gdx.graphics.getWidth();
		System.out.println("ratio: " + ratio);
		//tileMapRenderer = new TileMapRenderer(this.level.map, this.level.atlas, 32, 32, centerX, centerY);
		tileMapRenderer = new TileMapRenderer(this.level.map, this.level.atlas, 32, 32, 32*ratio*ratioS, 32);
		spriteBatch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("data/font/Arial16.fnt"),
                Gdx.files.internal("data/font/Arial16_0.png"), false);
		font.setColor(Color.RED);
		//System.out.println("wtf: " + 32*ratio*ratioS);
		offsetX = -CAMERA_WIDTH/3f+level.getHero().getX()*32*ratio*ratioS;
		offsetY = -CAMERA_HEIGHT/2f+(level.map.height -1 -level.getHero().getY())*centerY;
		this.cam.translate(offsetX, offsetY);
		this.cam.update();

		loadTextures();
	}
	

	public void setSize (int w, int h) {
		this.width = w;
		this.height = h;
		ppuX = (float)width / CAMERA_WIDTH;
		ppuY = (float)height / CAMERA_HEIGHT;
		centerX = ppuX * 32;
		centerY = ppuY * 32;
	}
	
	public void loadTextures(){
		atlas = new TextureAtlas(Gdx.files.internal("data/entity/pack/Entities.pack"));	
	}
	
	
	public void render(){
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		spriteBatch.disableBlending();
		spriteBatch.begin();
		renderTiles();
		spriteBatch.end();
		
		spriteBatch.enableBlending();
		spriteBatch.begin();
		renderEntities();
				
		if (debug)
			drawDebug();
		
		spriteBatch.end();
	}
	
	public void renderTiles() {
        tileMapRenderer.getProjectionMatrix().set(cam.combined);
		Vector3 tmp = new Vector3();
		tmp.set(0, 0, 0);
		cam.unproject(tmp);
		
		//updateFoV(); // updates the Field of View
		
		int[] layers = new int[2];  // layers to be rendered
		layers[0] = 1;
		layers[1] = 1;
		//tileMapRenderer.render((int) tmp.x, (int) tmp.y, width, height, layers);
		tileMapRenderer.render((int) tmp.x, (int) tmp.y,CAMERA_HEIGHT, CAMERA_HEIGHT);
        cam.zoom = 1f;
        cam.update();
        tileMapRenderer.render(cam);
	}

	// updates the field of view
	private void updateFoV(){
		int i,j;
		float x,y,l;
		for(i=0;i<level.map.width;i++)
			for(j=0;j<level.map.height;j++){
			level.map.layers.get(1).tiles[j][i] = TILE_BLACK; // tile not visible
		    x = i-level.getHero().getX();
		    y = j-level.getHero().getY();
		    l = (float) Math.sqrt((x*x)+(y*y));
		    if(l<VIEW_RADIUS)
		    	if(calcFoV(i,j) == true);
		    		level.map.layers.get(1).tiles[j][i] = TILE_CLEAR; // tile visible
		};
	}
	
	// checks visible tiles in a circle
	private boolean calcFoV(int x, int y){
		float vx,vy,ox,oy,l;
		int i;
		vx = x-level.getHero().getX();
		vy = y-level.getHero().getY();
		ox = (float)x+0.5f;
		oy= (float)y+0.5f;
		l=(float) Math.sqrt((vx*vx)+(vy*vy));
		vx/=l;
		vy/=l;
		for(i=0;i<(int)l;i++){
		    if(level.tileExists((int)ox, (int)oy, 0) || level.tilePropCheck((int)ox, (int)oy, "wall"))
		    	return false;
		    ox+=vx;
		    oy+=vy;
		};
		return true;
	}
	
	private void renderEntities(){
		for (Entity ent : level.getEntities()) {
			if(ent == level.getHero())
				spriteBatch.draw(new TextureRegion(atlas.findRegion(ent.getTexture())), Gdx.graphics.getWidth()*1/3, Gdx.graphics. getHeight()/2);
			else{
				offsetX = -CAMERA_WIDTH/3f+level.getHero().getX()*32*ratio*ratioS;
				offsetY = -CAMERA_HEIGHT/2f+(level.map.height-1-level.getHero().getY())*centerY;
				//Renders Unit Health Bars
				if(ent instanceof MonsterUnit){
					shapeRenderer.begin(ShapeType.FilledRectangle);
					shapeRenderer.setColor(Color.RED);
				if(((MonsterUnit) ent).getHP() > 0)
					shapeRenderer.filledRect(-offsetX*2.667f + ent.getX() * 32,-offsetY +(level.map.height -1 -ent.getY()) * centerY, ((MonsterUnit) ent).getHP(), 4);
					shapeRenderer.end();
				}
				spriteBatch.draw(new TextureRegion(atlas.findRegion(ent.getTexture())), -offsetX*2.667f + ent.getX() * 32, -offsetY + (level.map.height -1 - ent.getY()) * centerY);		
			}
		}
	}
	
	private boolean inRange(Entity ent){
		return true;
	}
	
	public void updateCam(float x, float y){
		cam.translate(x*32*ratio*ratioS, y*centerY);
	}
	
	private void drawDebug(){
		font.draw(spriteBatch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
		font.draw(spriteBatch, "Width: " + Gdx.graphics.getWidth(), 10, 40);
		font.draw(spriteBatch, "Height: " + Gdx.graphics.getHeight(), 10, 60);
		font.draw(spriteBatch, "HeroX: " + level.getHero().getX(), 10, 80);
		font.draw(spriteBatch, "HeroY: " + level.getHero().getY(), 10, 100);
		font.draw(spriteBatch, "HeroHP: " + level.getHero().getHP(), 10, 120);
		font.draw(spriteBatch, "HeroStr: " + level.getHero().getStr(), 10, 140);
		font.draw(spriteBatch, "HeroInt: " + level.getHero().getInt(), 10, 160);
		font.draw(spriteBatch, "HeroDex: " + level.getHero().getDex(), 10, 180);
		//font.draw(spriteBatch, "TEST - + ? TEST", 20, 40);
	}
}
