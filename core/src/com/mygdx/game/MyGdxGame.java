package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame implements ApplicationListener {

	// Constant rows and columns of the sprite sheet
	private static final int FRAME_COLS = 6, FRAME_ROWS = 5;

	// Objects used
	Animation<TextureRegion> walkAnimation; // Must declare frame type (TextureRegion)
	Texture walkSheet;
	SpriteBatch spriteBatch;
	BitmapFont font;
	ShapeRenderer shapeRenderer;
	// A variable for tracking elapsed time for the animation
	float stateTime;
	boolean hauteurMax =true;
	int hauteur= 140;
	float rectX=400;
	float rectY=135;
	float rectW=66;
	float rectH=66;
	float xSpeed =4;
	float ySpeed=3;
	int distance= 50;
	@Override
	public void create() {

		// Load the sprite sheet as a Texture
		walkSheet = new Texture(Gdx.files.internal("sprite-animation4.png"));

		// Use the split utility method to create a 2D array of TextureRegions. This is
		// possible because this sprite sheet contains frames of equal size and they are
		// all aligned.
		TextureRegion[][] tmp = TextureRegion.split(walkSheet,
				walkSheet.getWidth() / FRAME_COLS,
				walkSheet.getHeight() / FRAME_ROWS);

		// Place the regions into a 1D array in the correct order, starting from the top
		// left, going across first. The Animation constructor requires a 1D array.
		TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
		int index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
			for (int j = 0; j < FRAME_COLS; j++) {
				walkFrames[index++] = tmp[i][j];
			}
		}
		// Initialize the Animation with the frame interval and array of frames
		walkAnimation = new Animation<TextureRegion>(0.035f, walkFrames);
		// Instantiate a SpriteBatch for drawing and reset the elapsed animation
		// time to 0
		spriteBatch = new SpriteBatch();
		stateTime = 0f;
		font = new BitmapFont();
		shapeRenderer = new ShapeRenderer();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
		stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
		rectX -= xSpeed;

        if (rectX < -50) {
            rectX =600;
        }
		 //Get current frame of animation for the current stateTime
		TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
		spriteBatch.begin();
		spriteBatch.draw(currentFrame, distance, hauteur); // Draw current frame at (50, 50)
		spriteBatch.end();
		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
		shapeRenderer.setColor(1,1,1,1);
		shapeRenderer.line(0,135,300000,100);
		shapeRenderer.end();
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(1,0,0,0);
		shapeRenderer.rect(rectX,rectY,rectW,rectH);
		shapeRenderer.end();

		if (hauteurMax){
			if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
				if (hauteur<=300)
					hauteur+=5;
				if (hauteur > 300)
					hauteurMax = false;
			}else
			{
				if (hauteur>=140)
					hauteur-=7;
			}
		}
		else {
			if (hauteur>=140)
				hauteur-=7;
			if (hauteur < 140)
				hauteurMax = true;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)){
			if (distance>20)
				distance-=5;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)){
			if (distance<550)
				distance+=5;
		}

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() { // SpriteBatches and Textures must always be disposed
		spriteBatch.dispose();
		walkSheet.dispose();
	}
}