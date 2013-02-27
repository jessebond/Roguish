package com.me.Roguish.Screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.me.Roguish.Roguish;

public class ChooseClassScreen extends AbstractScreen{
	private static final int MAX_CARDS = 4;
	private int cardNo = 0;
	
	private TextureAtlas guiAtlas;
	private TextureAtlas entAtlas;
	
	private TextureRegion leftUp;
	private TextureRegion leftDown;
	private TextureRegion rightUp;
	private TextureRegion rightDown;
	private TextureRegion nextUp;
	private TextureRegion nextDown;
	private TextureRegion backUp;
	private TextureRegion backDown;
	private TextureRegion bg;
	
	private ButtonStyle leftStyle;
	private ButtonStyle rightStyle;
	private ButtonStyle nextStyle;
	private ButtonStyle backStyle;
	
	public ChooseClassScreen(Roguish game){
		super(game);
		System.out.println("Entered ChooseClassScreen");
	}
	
	@Override
    public void show(){
		System.out.println("ChooseClassScreen:Show()");
		Gdx.input.setInputProcessor(stage);
		
		loadGui();    // load atlas and button textures
		loadStyles(); // load button styles
			
		System.out.println("ChooseClassScreen:Show():New Buttons");
		Button leftButton = new Button(leftStyle);
		Button rightButton = new Button(rightStyle);
		Button nextButton = new Button(nextStyle);
		Button backButton = new Button(backStyle);
		
		System.out.println("ChooseClassScreen:Show():Table");
		Table table = new Table();
		table.setSize(480, 320);
		table.setBackground(new TextureRegionDrawable(bg));
		stage.addActor(table);
		table.columnDefaults(1);
		table.left().padLeft(52);
		table.debug();

		backButton.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				System.out.println("Back Button Down");
				game.setScreen(new MenuScreen(game));
				return false;
			}
		});
		table.add(backButton).colspan(2).padBottom(25);
		table.row();
		
		System.out.println("ChooseClassScreen:Show():Action Listeners");
		leftButton.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				addCardNo(-1);
				System.out.println("Left Button Down, CardNo: " + cardNo);
				return false;
			}
		});
		table.add(leftButton).padRight(50);
		
		rightButton.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				addCardNo(1);
				System.out.println("Left Button Down, CardNo: " + cardNo);
				return false;
			}
		});
		table.add(rightButton).padLeft(50);
		table.row();


		
		nextButton.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				System.out.println("Next Button Down, Class cardNo: " + cardNo);
				game.setScreen(new GameScreen(game));
				return false;
			}
		});
		table.add(nextButton).colspan(2).padTop(95);
		
	}

	private void loadGui(){
		System.out.println("ChooseClassScreen:LoadGui()");
		guiAtlas = new TextureAtlas(Gdx.files.internal("data/gui/pack/Gui.pack"));
		entAtlas = new TextureAtlas(Gdx.files.internal("data/entity/pack/Entities.pack"));
		
		leftUp = guiAtlas.findRegion("Btn_Left");
		leftDown = guiAtlas.findRegion("Btn_Left_Click");
		rightUp = guiAtlas.findRegion("Btn_Right");
		rightDown = guiAtlas.findRegion("Btn_Right_Click");
		nextUp = guiAtlas.findRegion("Btn_Next");
		nextDown = guiAtlas.findRegion("Btn_Next_Click");
		backUp = guiAtlas.findRegion("Btn_Back");
		backDown = guiAtlas.findRegion("Btn_Back_Click");
		
		bg = guiAtlas.findRegion("ChooseClass");
	}
	
	private void loadStyles(){
		System.out.println("ChooseClassScreen:LoadStyles()");
		System.out.println("1a");
		leftStyle = new ButtonStyle();
		System.out.println("1b:");
		leftStyle.up = new TextureRegionDrawable(leftUp);
		System.out.println("1c");
		leftStyle.down = new TextureRegionDrawable(leftDown);
		System.out.println("1d");
		
		rightStyle = new ButtonStyle();
		rightStyle.up = new TextureRegionDrawable(rightUp);
		rightStyle.down = new TextureRegionDrawable(rightDown);

		nextStyle = new ButtonStyle();
		nextStyle.up = new TextureRegionDrawable(nextUp);
		nextStyle.down = new TextureRegionDrawable(nextDown);
		
		backStyle = new ButtonStyle();
		backStyle.up = new TextureRegionDrawable(backUp);
		backStyle.down = new TextureRegionDrawable(backDown);
	}
	
	// adds the delta to the cardNo while keeping it in bounds - 0 < cardNo < MAX_CARDS
	private void addCardNo(int delta){
		cardNo += delta;
		if(cardNo < 0) cardNo = 0;
		if(cardNo >= MAX_CARDS) cardNo = MAX_CARDS - 1;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();

		Table.drawDebug(stage);
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