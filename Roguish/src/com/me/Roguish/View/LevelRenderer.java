package com.me.Roguish.View;

import com.me.Roguish.Model.Level;
import com.me.Roguish.Model.Entity;
import com.me.Roguish.Model.MonsterUnit;

import java.lang.Math;

import com.badlogic.gdx.Gdx;
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
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
//import com.badlogic.gdx.utils.OrthoCamController;

public class LevelRenderer {
	private static final float CAMERA_WIDTH = 320f;
	private static final float CAMERA_HEIGHT = 480f;
	private static final int VIEW_RADIUS = 6;
	private static final int SEEN_LAYER = 3;
	private static final int VISION_LAYER = 2;
	private static final int BACKGROUND_LAYER = 0;
	private static final int CLEAR_TILE = 64;
	private static final int BLACK_TILE = 42;
	private static final int ENT_DIM = 32;

	private Level level;

	private ShapeRenderer shapeRenderer = new ShapeRenderer();
	
	//Texture Regions
	private TextureRegion heroTexture;
	
	private boolean debug = false;
	private int w;
	private int h;
	private float offsetX;
	private float offsetY;
	private OrthogonalTiledMapRenderer renderer;
	private TiledMap map;
	private OrthographicCamera camera;
//	private OrthoCamController cameraController;
	private BitmapFont font;
	private SpriteBatch batch;
	
	private TextureAtlas atlas;
	private TiledMapTileLayer seenLayer;
	private TiledMapTileLayer visionLayer;
	private TiledMapTileLayer backgroundLayer;
	private TiledMapTile clearTile;
	private TiledMapTile blackTile;
	
	public LevelRenderer(Level level, boolean debug) {
		this.level = level;	
		this.debug = false;
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		this.map = level.map;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, (w / h) * 15f, 15f);
		offsetX = level.getHero().getX() - 4;
		offsetY = level.getHero().getY() - 5;
		camera.translate(-offsetX, -offsetY);
		camera.update();
		
		atlas = new TextureAtlas(Gdx.files.internal("data/entity/pack/Entities.pack"));
		font = new BitmapFont();
		batch = new SpriteBatch();
		
		renderer = new OrthogonalTiledMapRenderer(this.map, 1f / 32f);
		seenLayer = (TiledMapTileLayer)map.getLayers().get(SEEN_LAYER);
		visionLayer = (TiledMapTileLayer)map.getLayers().get(VISION_LAYER);
		backgroundLayer = (TiledMapTileLayer)map.getLayers().get(BACKGROUND_LAYER);

		clearTile = map.getTileSets().getTile(CLEAR_TILE);
		blackTile = map.getTileSets().getTile(BLACK_TILE);
		
		seenInit();
	}
	

	public void updateTiles(){
		clearTile = map.getTileSets().getTile(CLEAR_TILE);
		blackTile = map.getTileSets().getTile(BLACK_TILE);
	}
	
	public void setSize (int w, int h) {
		this.w = w;
		this.h = h;
	}
	
		
	public void render(){
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camera.update();
		renderer.setView(camera);
		
		int[] backgroundLayers = { 0, 1 }; // don't allocate every frame!
		int[] foregroundLayers = { 2, 3 };    // don't allocate every frame!
		
		
		updateFoV();
		updateSeen();
		
		renderer.render(backgroundLayers);
		
		batch.enableBlending();
		batch.begin();
		renderEntities();
		drawHealth();
		if (debug)
			drawDebug();
		batch.end();
		renderer.render(foregroundLayers);
	}

	
	void updateFoV()
	{
	  float x,y;
	  int i,j;
	  for(i=0;i<level.columns;i++)
			for(j=0;j<level.rows;j++)
				visionLayer.getCell(i, j).setTile(blackTile);
	  for(i=0;i<360;i++)
	  {
	    x=(float)Math.cos((double)i*0.01745f);
	    y=(float)Math.sin((double)i*0.01745f);
	    DoFov(x,y);
	  };
	};

	void DoFov(float x,float y)
	{
	  int i;
	  float ox,oy;
	  ox = (float)level.getHero().getX()+0.5f;
	  oy = (float)level.getHero().getY()+0.5f;
	  for(i=0;i<VIEW_RADIUS;i++)
	  {
		visionLayer.getCell((int)ox, (int)oy).setTile(clearTile);
		if(level.tilePropCheck((int)ox, (int)oy, "wall"))
	      return;
	    ox+=x;
	    oy+=y;
	  };
	};
	
	private void seenInit(){
		int i,j;
		for(i=0;i<level.columns;i++)
			for(j=0;j<level.rows;j++)
				seenLayer.getCell(i, j).setTile(blackTile);
	}
	
	private void updateSeen(){
		int i,j;
		for(i=0;i<level.columns;i++)
			for(j=0;j<level.rows;j++)
				if(visionLayer.getCell(i,j) != null && visionLayer.getCell(i,j).getTile().getId() == clearTile.getId())
					seenLayer.getCell(i, j).setTile(clearTile);
	}
	
	private void renderEntities(){
		for (Entity ent : level.getEntities()) {
			if(ent == level.getHero())
				batch.draw(new TextureRegion(atlas.findRegion(ent.getTexture())), 6*ENT_DIM, 5*ENT_DIM);
			else{
				if(visionLayer.getCell(ent.getX(),ent.getY()) != null && visionLayer.getCell(ent.getX(),ent.getY()).getTile().getId() == clearTile.getId()){
					//Renders Unit Health Bars
					if(ent instanceof MonsterUnit){
						shapeRenderer.begin(ShapeType.Filled);
						shapeRenderer.setColor(Color.RED);
						if(((MonsterUnit) ent).getHP() > 0){
							shapeRenderer.rect((ent.getX() + offsetX) * ENT_DIM,(ent.getY() + offsetY) * ENT_DIM, ((MonsterUnit) ent).getHP(), 4);
						}
						shapeRenderer.end();
						if(((MonsterUnit) ent).getHP() <= 0)
							batch.draw(new TextureRegion(atlas.findRegion("Grave")), (ent.getX() + offsetX) * ENT_DIM, (ent.getY() + offsetY) * ENT_DIM);
						else batch.draw(new TextureRegion(atlas.findRegion(ent.getTexture())), (ent.getX() + offsetX) * ENT_DIM, (ent.getY() + offsetY) * ENT_DIM);
					}
					else
						batch.draw(new TextureRegion(atlas.findRegion(ent.getTexture())), (ent.getX() + offsetX) * ENT_DIM, (ent.getY() + offsetY) * ENT_DIM);
				}
			}
		}
	}
	
	public void updateCam(float x, float y){
		offsetX -= x;
		offsetY -= y;
		camera.translate(x, y);
	}
	
	private void drawHealth(){
		float hp, mana;
		hp = level.getHero().getHP()/level.getHero().getBaseHP();
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.RED);
		shapeRenderer.rect(10, 80, 200, 20);
		shapeRenderer.setColor(Color.GREEN);
		shapeRenderer.rect(10, 80, hp, 20);
		
		shapeRenderer.end();
	}
	
	private void drawDebug(){
		font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
		font.draw(batch, "Width: " + Gdx.graphics.getWidth(), 10, 40);
		font.draw(batch, "Height: " + Gdx.graphics.getHeight(), 10, 60);
		font.draw(batch, "HeroX: " + level.getHero().getX(), 10, 80);
		font.draw(batch, "HeroY: " + level.getHero().getY(), 10, 100);
		font.draw(batch, "HeroHP: " + level.getHero().getHP(), 10, 120);
		font.draw(batch, "HeroStr: " + level.getHero().getStr(), 10, 140);
		font.draw(batch, "HeroInt: " + level.getHero().getInt(), 10, 160);
		font.draw(batch, "HeroDex: " + level.getHero().getDex(), 10, 180);
		//font.draw(spriteBatch, "TEST - + ? TEST", 20, 40);
	}
	
	public void dispose() {
		map.dispose();
	}
}
