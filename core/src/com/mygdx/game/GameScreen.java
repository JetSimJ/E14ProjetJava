//package com.mygdx.game;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.InputAdapter;
//import com.badlogic.gdx.ScreenAdapter;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//import com.badlogic.gdx.math.Vector2;
//
//import java.util.ArrayList;
//import java.util.Random;
//
//public class GameScreen extends ScreenAdapter {
//
//    MyGdxGame game;
//    Random rand = new Random();
//
//    float circleX = 300;
//    float circleY = 150;
//    float circleRadius = 50;
//    int clickCpt = 0;
//    float xSpeed = 4;
//    float ySpeed = 3;
//    private float timeSeconds = 0f;
//    private float periodz = 1f;
//    public GameScreen(MyGdxGame game) {
//        this.game = game;
//    }
//
//    @Override
//    public void show() {
//        Gdx.input.setInputProcessor(new InputAdapter() {
//            @Override
//            public boolean touchDown(int x, int y, int pointer, int button) {
//                int renderY = Gdx.graphics.getHeight() - y;
//                if (Vector2.dst(circleX, circleY, x, renderY) < circleRadius+10) {
//                    circleX = rand.nextInt(400);
//                    circleY = rand.nextInt(400);
//                    xSpeed += 0.4;
//                    ySpeed += 0.4;
//                    circleRadius -=1;
//                    clickCpt ++;
//                    //game.setScreen(new EndScreen(game));
//                }
//                return true;
//            }
//        });
//    }
//
//    @Override
//    public void render(float delta) {
//        timeSeconds +=Gdx.graphics.getRawDeltaTime();
//        if(timeSeconds > periodz){
//            timeSeconds-=periodz;
//            showTimer();
//        }
//        createBall();
//    }
//
//    private void showTimer() {
//
//        game.batch.begin();
//        game.font.draw(game.batch, String.format("Temps: %s", timeSeconds), Gdx.graphics.getWidth()*.06f, Gdx.graphics.getHeight()*.15f);
//        game.batch.end();
//    }
//
//    public void createBall(){
//        circleX += xSpeed;
//        circleY += ySpeed;
//
//        if (circleX < 0 || circleX > Gdx.graphics.getWidth()) {
//            xSpeed *= -1;
//        }
//
//        if (circleY < 0 || circleY > Gdx.graphics.getHeight()) {
//            ySpeed *= -1;
//        }
//
//        Gdx.gl.glClearColor(0, 0, .25f, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        game.batch.begin();
//        game.font.draw(game.batch, String.format("Score: %s", clickCpt), Gdx.graphics.getWidth()*.02f, Gdx.graphics.getHeight()*.05f);
//        game.batch.end();
//        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        game.shapeRenderer.setColor(0, 1, 0, 1);
//        game.shapeRenderer.circle(circleX, circleY, circleRadius+25);
//        game.shapeRenderer.end();
//
//    }
//
//    @Override
//    public void hide() {
//        Gdx.input.setInputProcessor(null);
//    }
//}
