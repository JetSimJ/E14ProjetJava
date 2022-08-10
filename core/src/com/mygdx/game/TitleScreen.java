//package com.mygdx.game;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.InputAdapter;
//import com.badlogic.gdx.ScreenAdapter;
//import com.badlogic.gdx.graphics.GL20;
//
//public class TitleScreen extends ScreenAdapter {
//
//    MyGdxGame game;
//
//    public TitleScreen(MyGdxGame game) {
//        this.game = game;
//    }
//
//    @Override
//    public void show(){
//        Gdx.input.setInputProcessor(new InputAdapter() {
//            @Override
//            public boolean keyDown(int keyCode) {
//                if (keyCode == Input.Keys.SPACE) {
//                    game.setScreen(new GameScreen(game));
//                }
//                return true;
//            }
//        });
//    }
//
//    @Override
//    public void render(float delta) {
//        Gdx.gl.glClearColor(0, .25f, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        game.batch.begin();
//        game.font.draw(game.batch, "Bienvenue sur l'écran d'accueil!", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .75f);
//        game.font.draw(game.batch, "Appuyez sur le plus de cercles en 30 secondes.", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .5f);
//        game.font.draw(game.batch, "Appuyez sur espace pour commencer.", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .25f);
//        game.batch.end();
//    }
//
//    @Override
//    public void hide(){
//        Gdx.input.setInputProcessor(null);
//    }
//}
