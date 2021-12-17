package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import game.HangmanGame;
import processor.GameOverProcessor;
import sprite.Hangman;

public class GameOverScreen implements Screen {
    SpriteBatch spriteBatch;
    BitmapFont font;

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        font = InitialScreen.assetManager.get("fonts/font.fnt", BitmapFont.class);
        GameOverProcessor.init();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        spriteBatch.begin();
        font.draw(spriteBatch,"game over \n\n", Gdx.graphics.getWidth() / 2 -80, Gdx.graphics.getHeight() / 2);
        font.draw(spriteBatch,"click to play again", Gdx.graphics.getWidth() / 2 -130, Gdx.graphics.getHeight() / 2 - 300);
        if (GameOverProcessor.clicked){
            Hangman.gameOverSound.stop();
            HangmanGame.hangmanGame.setScreen(new Hangman());
        }
        // spriteBatch.draw((Texture) MainScreen.assetManager.get("flappytextures.png"), Gdx.graphics.getWidth() / 2 - 95 / 2f, Gdx.graphics.getHeight() / 2 - 20 / 2f, 145, 198, 240 - 145, 218 - 198);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
