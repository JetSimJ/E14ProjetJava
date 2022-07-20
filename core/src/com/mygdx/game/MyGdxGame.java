package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.badlogic.gdx.math.MathUtils.random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	BitmapFont font;
	ShapeRenderer shapeRenderer;
	float circleX = 200;
	float circleY = 100;
	float circleX2 = 400;
	float circleY2 = 100;
	float xSpeed = 120;
	float ySpeed = 60;
	float xSpeed2 = 2;
	float ySpeed2 = 1;

	float r = MathUtils.random();
	float g = MathUtils.random();
	float b = MathUtils.random();
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		shapeRenderer = new ShapeRenderer();
		
		colorsPick();

	}

	private void colorsPick() {
		Gdx.input.setInputProcessor(new InputAdapter() {

			@Override
			public boolean keyTyped (char key) {
				r = MathUtils.random();
				g = MathUtils.random();
				b = MathUtils.random();
				return true;
			}

			@Override
			public boolean touchDown (int x, int y, int pointer, int button) {
				r = MathUtils.random();
				g = MathUtils.random();
				b = MathUtils.random();
				return true;
			}
		});
	}

	@Override
	public void render () {

		Gdx.gl.glClearColor(r, g, b, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		keyboardMouseMouvement();
		automovement();


	}

	private void keyboardMouseMouvement() {
		if (Gdx.input.isTouched()) {
		circleX = Gdx.input.getX();
		circleY = Gdx.graphics.getHeight() - Gdx.input.getY();
	}

		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			circleY++;
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.S)){
			circleY--;
		}

		if(Gdx.input.isKeyPressed(Input.Keys.A)){
			circleX--;
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.D)){
			circleX++;
		}
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(0, 1, 0, 1);
		shapeRenderer.circle(circleX, circleY, 75);
		shapeRenderer.end();
	}

	private void automovement() {
		circleX2 += xSpeed2;
		circleY2 += ySpeed2;
		if(circleX2 < 75 || circleX2 > Gdx.graphics.getWidth()){
			xSpeed2 *= -1;
		}
		if(circleY2 < 75 || circleY2 > Gdx.graphics.getHeight()){
			ySpeed2 *= -1;
		}
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(1, 1, 0, 1);
		shapeRenderer.circle(circleX2, circleY2, 75);
		shapeRenderer.end();
	}

	@Override
	public void dispose () {
		shapeRenderer.dispose();
		batch.dispose();
		font.dispose();
	}
}
