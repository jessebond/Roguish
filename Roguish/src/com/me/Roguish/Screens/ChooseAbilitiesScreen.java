package com.me.Roguish.Screens;
import com.badlogic.gdx.Gdx;
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
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.Array;

import com.me.Roguish.Roguish;
import com.me.Roguish.Model.ClassCard;

public class ChooseAbilitiesScreen extends AbstractScreen{
	private static final int MAX_CARDS = 20;
	private int cardNo = 0;
	private int abilNo = 0;
	private Array<Integer> abilities = new Array<Integer>();
	
	private ClassCard cCard;
	
	private TextureAtlas guiAtlas;
	private TextureAtlas entAtlas;
	
	// Gui TextureRegions
	private TextureRegion leftUp;
	private TextureRegion leftDown;
	private TextureRegion rightUp;
	private TextureRegion rightDown;
	private TextureRegion nextUp;
	private TextureRegion nextDown;
	private TextureRegion backUp;
	private TextureRegion backDown;
	private TextureRegion addUp;
	private TextureRegion addDown;
	private TextureRegion delUp;
	private TextureRegion delDown;
	private TextureRegion bg;
	private TextureRegion cardRing;
	
	private ButtonStyle leftStyle;
	private ButtonStyle rightStyle;
	private ButtonStyle nextStyle;
	private ButtonStyle backStyle;
	private ButtonStyle addStyle;
	private ButtonStyle delStyle;
	
	// Entity TextureRegions
	private TextureRegion c_archer;
	private TextureRegion c_mage;
	private TextureRegion c_ninja;
	private TextureRegion c_warrior;
	private TextureRegion d_archer;
	private TextureRegion d_mage;
	private TextureRegion d_ninja;
	private TextureRegion d_warrior;
	
	private Image c_ent0;
	private Image d_ent0;
	private Image c_ent1;
	private Image d_ent1;
	private Image c_ent2;
	private Image d_ent2;
	private Image c_ent3;
	private Image d_ent3;
	
	// CardRing images
	private Image cRing;
	private Image cRing0;
	private Image cRing1;
	private Image cRing2;
	private Image cRing3;
	private Image cRing4;
	
	public ChooseAbilitiesScreen(Roguish game, ClassCard cCard){
		super(game);
		this.cCard = cCard;
		System.out.println("Entered ChooseClassScreen");
		
		//for(int i = 0; i < abilities.size; i++)
		//	abilities.set(i,-1);
	}
	
	@Override
    public void show(){
		System.out.println("ChooseClassScreen:Show()");
		Gdx.input.setInputProcessor(stage);
		
		loadGui();    // load guiAtlas and button textures
		loadEnt();    // load entAtlas and ent textures
		loadStyles(); // load button styles
		
		// Create Images
		getEntImages();
		getRingImages();
		ringMove(cRing, cardNo);
		updateAlphasRing(0);
		updateAlphasOff(-1);
		updateAlphasOn(cardNo);
				
		// Create Buttons
		Button leftButton = new Button(leftStyle);
		Button rightButton = new Button(rightStyle);
		Button nextButton = new Button(nextStyle);
		Button backButton = new Button(backStyle);
		Button addButton = new Button(addStyle);
		Button delButton = new Button(delStyle);
		
		// Create Tables
		Table table1 = new Table();  // Back and Next
		Table table2 = new Table();  // Left and Right
		Table table3 = new Table();  // Add  and Remove
		table1.setSize(480, 320);
		table2.setSize(480, 320);
		table3.setSize(480, 320);
		table1.setBackground(new TextureRegionDrawable(bg));
		
		stage.addActor(table1);
		stage.addActor(table2);
		stage.addActor(table3);
		stage.addActor(c_ent0);
		stage.addActor(d_ent0);
		stage.addActor(c_ent1);
		stage.addActor(d_ent1);
		stage.addActor(c_ent2);
		stage.addActor(d_ent2);
		stage.addActor(c_ent3);
		stage.addActor(d_ent3);
		stage.addActor(cRing);
		stage.addActor(cRing0);
		stage.addActor(cRing1);
		stage.addActor(cRing2);
		stage.addActor(cRing3);
		stage.addActor(cRing4);
		
		table1.left().padLeft(38).padTop(4);
		table1.debug();
		table2.right().top().padRight(75).padTop(55);
		table3.bottom().right().padRight(32).padBottom(2);

		backButton.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				System.out.println("Back Button Down");
				game.setScreen(new ChooseClassScreen(game));
				return false;
			}
		});
		table1.add(backButton).padBottom(195);
		table1.row();
		
		nextButton.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				System.out.println("Next Button Down, Class cardNo: " + cardNo);
				game.setScreen(new GameScreen(game, cCard));
				return false;
			}
		});
		table1.add(nextButton);
		
		System.out.println("ChooseClassScreen:Show():Action Listeners");
		leftButton.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				updateAlphasOff(cardNo);
				updateCardNo(-1);
				updateAlphasOn(cardNo);
				ringMove(cRing, cardNo);
				System.out.println("Left Button Down, CardNo: " + cardNo);
				return false;
			}
		});
		table2.add(leftButton).padRight(85);
		
		rightButton.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				updateAlphasOff(cardNo);
				updateCardNo(1);
				updateAlphasOn(cardNo);
				ringMove(cRing, cardNo);
				System.out.println("Left Button Down, CardNo: " + cardNo);
				return false;
			}
		});
		table2.add(rightButton);

		addButton.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				System.out.println("Add Down, cardNo: " + cardNo);
				addAbility(cardNo);
				return false;
			}
		});
		table3.add(addButton).padRight(35);
		
		delButton.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				System.out.println("Remove Down, cardNo: " + cardNo);
				delAbility(cardNo);
				return false;
			}
		});
		table3.add(delButton);
		
	}

	private void loadGui(){
		System.out.println("ChooseClassScreen:LoadGui()");
		guiAtlas = new TextureAtlas(Gdx.files.internal("data/gui/pack/Gui.pack"));
		
		leftUp = guiAtlas.findRegion("Btn_Left");
		leftDown = guiAtlas.findRegion("Btn_Left_Click");
		rightUp = guiAtlas.findRegion("Btn_Right");
		rightDown = guiAtlas.findRegion("Btn_Right_Click");
		nextUp = guiAtlas.findRegion("Btn_Next");
		nextDown = guiAtlas.findRegion("Btn_Next_Click");
		backUp = guiAtlas.findRegion("Btn_Back");
		backDown = guiAtlas.findRegion("Btn_Back_Click");
		addUp = guiAtlas.findRegion("Btn_Add");
		addDown = guiAtlas.findRegion("Btn_Add_Click");
		delUp = guiAtlas.findRegion("Btn_Remove");
		delDown = guiAtlas.findRegion("Btn_Remove_Click");
		
		bg = guiAtlas.findRegion("Choose");
		cardRing = guiAtlas.findRegion("CardRing");
	}
	
	private void loadEnt(){
		System.out.println("ChooseClassScreen:LoadEnt()");
		entAtlas = new TextureAtlas(Gdx.files.internal("data/entity/pack/Entities.pack"));
		
		c_archer = entAtlas.findRegion("C_Archer");
		d_archer = entAtlas.findRegion("D_Archer");
		c_mage = entAtlas.findRegion("C_Mage");
		d_mage = entAtlas.findRegion("D_Mage");
		c_ninja = entAtlas.findRegion("C_Ninja");
		d_ninja = entAtlas.findRegion("D_Ninja");
		c_warrior = entAtlas.findRegion("C_Warrior");
		d_warrior = entAtlas.findRegion("D_Warrior");
	}
	
	private void loadStyles(){
		leftStyle = new ButtonStyle();
		leftStyle.up = new TextureRegionDrawable(leftUp);
		leftStyle.down = new TextureRegionDrawable(leftDown);
				
		rightStyle = new ButtonStyle();
		rightStyle.up = new TextureRegionDrawable(rightUp);
		rightStyle.down = new TextureRegionDrawable(rightDown);

		nextStyle = new ButtonStyle();
		nextStyle.up = new TextureRegionDrawable(nextUp);
		nextStyle.down = new TextureRegionDrawable(nextDown);
		
		backStyle = new ButtonStyle();
		backStyle.up = new TextureRegionDrawable(backUp);
		backStyle.down = new TextureRegionDrawable(backDown);
		
		addStyle = new ButtonStyle();
		addStyle.up = new TextureRegionDrawable(addUp);
		addStyle.down = new TextureRegionDrawable(addDown);
		
		delStyle = new ButtonStyle();
		delStyle.up = new TextureRegionDrawable(delUp);
		delStyle.down = new TextureRegionDrawable(delDown);
	}
	
	
	// adds the delta to the cardNo while keeping it in bounds - 0 < cardNo < MAX_CARDS
	private void updateCardNo(int delta){
		cardNo += delta;
		if(cardNo < 0) cardNo = 0;
		if(cardNo >= MAX_CARDS) cardNo = MAX_CARDS - 1;
	}
	
	// sets alphas to 100 of the EntImages based on cardNo
	private void updateAlphasOn(int i){
		switch(i){
			case 0:
				c_ent0.addAction(Actions.alpha(1));
				d_ent0.addAction(Actions.alpha(1));
				break;
			case 1:
				c_ent1.addAction(Actions.alpha(1));
				d_ent1.addAction(Actions.alpha(1));
				break;
			case 2:
				c_ent2.addAction(Actions.alpha(1));
				d_ent2.addAction(Actions.alpha(1));
				break;
			case 3:
				c_ent3.addAction(Actions.alpha(1));
				d_ent3.addAction(Actions.alpha(1));
				break;
			default:
				break;
		}
	}
	
	// sets alphas to 100 of the EntImages based on cardNo
	private void updateAlphasOff(int i){
		switch(i){
			case 0:
				c_ent0.addAction(Actions.alpha(0));
				d_ent0.addAction(Actions.alpha(0));
				break;
			case 1:
				c_ent1.addAction(Actions.alpha(0));
				d_ent1.addAction(Actions.alpha(0));
				break;
			case 2:
				c_ent2.addAction(Actions.alpha(0));
				d_ent2.addAction(Actions.alpha(0));
				break;
			case 3:
				c_ent3.addAction(Actions.alpha(0));
				d_ent3.addAction(Actions.alpha(0));
				break;
			default:
				c_ent0.addAction(Actions.alpha(0));
				d_ent0.addAction(Actions.alpha(0));
				c_ent1.addAction(Actions.alpha(0));
				d_ent1.addAction(Actions.alpha(0));
				c_ent2.addAction(Actions.alpha(0));
				d_ent2.addAction(Actions.alpha(0));
				c_ent3.addAction(Actions.alpha(0));
				d_ent3.addAction(Actions.alpha(0));
				break;
		}
	}
	
	public Actor getRing(int ringNo){
		switch(ringNo){
		case 0:
			return cRing0;
		case 1:
			return cRing1;
		case 2:
			return cRing2;
		case 3:
			return cRing3;
		case 4:
			return cRing4;
		default:
			return cRing0;
		}
	}
	
	public void updateAlphasRing(Actor a, int al){
		a.addAction(Actions.alpha(al));
	}

	public void updateAlphasRing(int al){
		cRing0.addAction(Actions.alpha(al));
		cRing1.addAction(Actions.alpha(al));
		cRing2.addAction(Actions.alpha(al));
		cRing3.addAction(Actions.alpha(al));
		cRing4.addAction(Actions.alpha(al));
	}
	
	private void ringMove(Actor a, int pos){
		if (pos < 10) 
			a.addAction(Actions.moveTo(214 + (pos % 10)*24, 99));
		else
			a.addAction(Actions.moveTo(214 + (pos % 10)*24, 99 - 33));
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();

		//Table.drawDebug(stage);
	}
		
	private void getEntImages(){
		int cx = 20;
		int cy = 55;
		int dx = 316;
		int dy = 225;
				
		c_ent0 = new Image(c_archer);
		c_ent1 = new Image(c_mage);
		c_ent2 = new Image(c_ninja);
		c_ent3 = new Image(c_warrior);
		c_ent0.setScaling(Scaling.fill);
		c_ent1.setScaling(Scaling.fill);
		c_ent2.setScaling(Scaling.fill);
		c_ent3.setScaling(Scaling.fill);
		c_ent0.setPosition(cx, cy);
		c_ent1.setPosition(cx, cy);
		c_ent2.setPosition(cx, cy);
		c_ent3.setPosition(cx, cy);
		
		// decks
		d_ent0 = new Image(d_archer);
		d_ent1 = new Image(d_mage);
		d_ent2 = new Image(d_ninja);
		d_ent3 = new Image(d_warrior);
		d_ent0.setScaling(Scaling.fill);
		d_ent1.setScaling(Scaling.fill);
		d_ent2.setScaling(Scaling.fill);
		d_ent3.setScaling(Scaling.fill);
		d_ent0.setPosition(dx, dy);
		d_ent1.setPosition(dx, dy);
		d_ent2.setPosition(dx, dy);
		d_ent3.setPosition(dx, dy);
	}
	
	private void getRingImages(){
		cRing = new Image(cardRing);
		cRing0 = new Image(cardRing);
		cRing1 = new Image(cardRing);
		cRing2 = new Image(cardRing);
		cRing3 = new Image(cardRing);
		cRing4 = new Image(cardRing);
		cRing.setScaling(Scaling.fill);
		cRing0.setScaling(Scaling.fill);
		cRing1.setScaling(Scaling.fill);
		cRing2.setScaling(Scaling.fill);
		cRing3.setScaling(Scaling.fill);
		cRing4.setScaling(Scaling.fill);
	}
	
	
	// Adds an ability value cardNo to abilities
	private void addAbility(int cardNo){
		System.out.println("Size: " + abilities.size);
		if(!abilities.contains(cardNo, true) && (abilNo < 5)){
			System.out.println("adding");
			abilities.add(cardNo);
			System.out.println("added");
			abilNo++;
			updateRings();
		}
	}
	
	// Deletes an ability value cardNo to abilities
	private void delAbility(int cardNo){
		System.out.println("Size: " + abilities.size);
		if(abilities.contains(cardNo, true) && abilNo > 0){
			abilities.removeValue(cardNo, true);
			abilNo--;
			updateRings();
		}
	}
	
	private void updateRings(){
		for(int i = 0; i < 5; i++){
			if(i < abilNo){
				ringMove(getRing(i), abilities.get(i));
				updateAlphasRing(getRing(i),100);
			}
			else{
				updateAlphasRing(getRing(i),0);
			}
		}
	}
	
	@Override
	public void dispose(){
		guiAtlas.dispose();
		entAtlas.dispose();
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