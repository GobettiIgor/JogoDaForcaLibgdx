package sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import enums.PossibleWords;
import screens.InitialScreen;

import java.util.Random;

public class Hangman implements Screen {

    public static Music gameMusic;

    SpriteBatch spriteBatch;
    private static Texture mainHangman;
    private HangmanBackground hangmanBackground;
    public Puppet puppet;
    public Box box;
    public static String clue;
    public static String word;
    int posX = 120, posY = 100;

    BitmapFont font;

    public static InputMultiplexer multiplexer;

    public static void addInputProcessor(InputProcessor inputProcessor){
        if(multiplexer == null){
            multiplexer = new InputMultiplexer();
            Gdx.input.setInputProcessor(multiplexer);
        }
        multiplexer.addProcessor(inputProcessor);
    }

    public Hangman() {
        spriteBatch = new SpriteBatch();

        gameMusic = InitialScreen.assetManager.get("musicaJogo.mp3", Music.class);
        gameMusic.setVolume(0.7f);
        gameMusic.setLooping(true);
        gameMusic.play();

        mainHangman = InitialScreen.assetManager.get("ForcaSemFundo1.jpg", Texture.class);
        hangmanBackground = new HangmanBackground();
        puppet = new Puppet();
        box = new Box();

        PossibleWords ps = wordSelection();
        clue = ps.getDescription();
        word = ps.name();

        int teste = word.length();

        font = InitialScreen.assetManager.get("fonts/font.fnt", BitmapFont.class);

    }

    public void update(final float delta){
    }

    public void desenhar(final SpriteBatch batch, final float delta){
        update(delta);
        //this.draw(batch,delta);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1,1,1,0);

        spriteBatch.begin();
        hangmanBackground.draw(spriteBatch);
        puppet.draw(delta, spriteBatch);
        font.draw(spriteBatch,"erros restantes:",300,450);
        font.draw(spriteBatch,word,160,125);

        /*
        for (int i = 0; i < word.length(); i++) {
            if (i > 0) {
                posX = 76;
            }
            box.draw(spriteBatch, posX, posY);
        }*/
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

    private PossibleWords wordSelection(){
        return PossibleWords.values()[new Random().nextInt(PossibleWords.values().length)];
    }
}