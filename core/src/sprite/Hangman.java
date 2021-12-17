package sprite;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import controller.BulletController;
import enums.PossibleWords;
import game.HangmanGame;
import processor.BulletProcessor;
import processor.CongratulationsProcessor;
import processor.GameOverProcessor;
import processor.HangmanProcessor;
import screens.CongratulationsScreen;
import screens.GameOverScreen;
import screens.InitialScreen;
import com.badlogic.gdx.utils.Timer;

import java.util.*;

public class Hangman implements Screen {

    public static Music gameMusic;
    public static Sound gameOverSound;
    public static Sound victorySound;

    SpriteBatch spriteBatch;
    private static Texture mainHangman;
    private HangmanBackground hangmanBackground;
    public static Puppet puppet;
    public PuppetHangman puppetHangman;
    public HangmanProcessor hangmanProcessor;
    public Box box;
    public static String clue;
    public static String word;
    int attempts = 5;
    float delay = 1; // seconds

    public static ArrayList<Letter> arrayword;
    public static ArrayList<Letter> arrayLettersWrong;
    public static ArrayList<String> arrayLettersPlayed;

    BulletOrigin bullet;
    BulletProcessor bp;

    BitmapFont font;

    public static InputMultiplexer multiplexer;

    OrthographicCamera camera;
    float width = Gdx.graphics.getWidth();
    float height = Gdx.graphics.getHeight();

    ShapeRenderer shapeRenderer;

    public Hangman() {
        spriteBatch = new SpriteBatch();
        hangmanProcessor = new HangmanProcessor();
        HangmanGame.addInputProcessor(hangmanProcessor);
        GameOverProcessor.clicked = false;
        CongratulationsProcessor.clicked = false;

        arrayword = new ArrayList<Letter>();
        arrayLettersWrong = new ArrayList<Letter>();
        arrayLettersPlayed = new ArrayList<String>();

        gameMusic = InitialScreen.assetManager.get("gameMusic.ogg", Music.class);
        gameMusic.setVolume(0.7f);
        gameMusic.setLooping(true);
        gameMusic.play();

        mainHangman = InitialScreen.assetManager.get("ForcaSemFundo.jpg", Texture.class);
        hangmanBackground = new HangmanBackground();
        puppet = new Puppet();
        puppetHangman = new PuppetHangman();
        BulletController.init();
        box = new Box();

        bullet = new BulletOrigin();

        PossibleWords ps = wordSelection();
        clue = ps.getDescription();
        word = ps.name();

        for (int i = 0; i < word.length(); i++) {
            Letter letter = new Letter();
            letter.letter = String.valueOf(word.charAt(i));
            arrayword.add(letter);
        }

        font = InitialScreen.assetManager.get("fonts/font.fnt", BitmapFont.class);

        bp = new BulletProcessor();

        camera = new OrthographicCamera(width, height); // dá pra modificar para mostrar que está funcionando
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);

        shapeRenderer = new ShapeRenderer();
    }

    public void update(final float delta) {
        for (int i = 0; i < word.length(); i++) {
            if (arrayword.get(i).letter.equals(hangmanProcessor.letter)) {
                Letter letter = arrayword.get(i);
                letter.showLetter = true;
                arrayword.add(i, letter);
                arrayword.remove(i + 1);
            } else {
                if (arrayLettersWrong.size() == 0 && hangmanProcessor.letter != null && hangmanProcessor.letter != "" && !word.contains(hangmanProcessor.letter)) {
                    Letter letter = new Letter();
                    letter.letter = hangmanProcessor.letter;
                    arrayLettersWrong.add(letter);
                } else if (hangmanProcessor.letter != null && hangmanProcessor.letter != "") {
                    boolean exists = false;
                    for (int j = 0; j < arrayLettersWrong.size(); j++) {
                        System.out.println("Letra:" + arrayLettersWrong.get(j).letter);
                        if (arrayLettersWrong.get(j).letter.equals(hangmanProcessor.letter)) {
                            exists = true;
                            break;
                            //System.out.println("entrou aqui e o J eh " + j);
                        }
                    }
                    if (!exists && !word.contains(hangmanProcessor.letter)) {
                        Letter letter = new Letter();
                        letter.letter = hangmanProcessor.letter;
                        arrayLettersWrong.add(letter);
                        //System.out.println("Letra: " + teste.letter + " nao existe na palavra" + word);
                    }
                }
            }
            if (arrayLettersPlayed.size() == 0 && hangmanProcessor.letter != null && hangmanProcessor.letter != "") {
                arrayLettersPlayed.add(hangmanProcessor.letter);
            } else {
                if (arrayLettersPlayed.size() > 0) {
                    boolean exists = false;
                    for (int l = 0; l < arrayLettersPlayed.size(); l++) {
                        if (arrayLettersPlayed.get(l).equals(hangmanProcessor.letter)) {
                            exists = true;
                            break;
                        }
                    }
                    if (!exists) {
                        arrayLettersPlayed.add(hangmanProcessor.letter);
                    }
                }
            }
        }
    }

        public void draw ( final SpriteBatch batch, final float delta){
            update(delta);
            if (attempts < 1) {
                HangmanGame.hangmanGame.setScreen(new GameOverScreen());
            }
        }

        @Override
        public void show () {
        }

        @Override
        public void render ( float delta){
            ScreenUtils.clear(1, 1, 1, 0);

            update(delta);

            spriteBatch.begin();
            hangmanBackground.draw(spriteBatch);
            puppet.draw(delta, spriteBatch);
            puppetHangman.draw(spriteBatch);
            BulletController.draw(spriteBatch, delta);
            font.draw(spriteBatch, "tentativas restantes:", 620, 730);
            font.draw(spriteBatch, String.valueOf(7 - arrayLettersWrong.size()), 980, 730);
            font.draw(spriteBatch, "dica: ", 620, 650);
            font.draw(spriteBatch, clue, 720, 650);
            drawLetters(arrayword.size(), 470, 60, 280);
            if (arrayLettersPlayed.size() != 0) {
                drawLettersPlayed(arrayLettersPlayed.size(), 150, 55, 110);
            }
            box.draw(spriteBatch,1000, 350);

            //bullet.draw(spriteBatch, delta);

            if (7 - arrayLettersWrong.size() == 0) {
                HangmanGame.hangmanGame.setScreen(new GameOverScreen());
                gameMusic.stop();
                gameOverSound = InitialScreen.assetManager.get("gameOverSound.mp3", Sound.class);
                long id = gameOverSound.play();
                gameOverSound.setVolume(id, 0.7f);
            }

            int aux = 0;
            for (int i = 0; i < arrayword.size(); i++) {
                if (arrayword.get(i).showLetter == true) {
                    aux++;
                }
            }
            if (arrayword.size() == aux) {
                gameMusic.stop();
                victorySound = InitialScreen.assetManager.get("victorySound.mp3", Sound.class);
                long id = victorySound.play();
                victorySound.setVolume(id, 0.7f);
                Timer.schedule(new Timer.Task(){
                    @Override
                    public void run() {
                        HangmanGame.hangmanGame.setScreen(new CongratulationsScreen());
                    }
                },delay);
            }
            spriteBatch.end();
            shapeRenderer.setColor(Color.BLACK);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.rect(35, 140, 1132, 7);
            shapeRenderer.end();
        }

        @Override
        public void resize ( int width, int height){

        }

        @Override
        public void pause () {

        }

        @Override
        public void resume () {

        }

        @Override
        public void hide () {

        }

        @Override
        public void dispose () {

        }

        private PossibleWords wordSelection () {
            return PossibleWords.values()[new Random().nextInt(PossibleWords.values().length)];
        }

        public void drawLetters ( int length, int xInitial, int x, int y){
            for (int i = 0; i < length; i++) {
                if (arrayword.get(i).showLetter) {
                    font.draw(spriteBatch, arrayword.get(i).letter, xInitial + (x * (i)), y);
                }
            }
        }

        public void drawLettersPlayed ( int length, int xInitial, int x, int y){
            for (int i = 0; i < length; i++) {
                font.draw(spriteBatch, arrayLettersPlayed.get(i) + "   -  ", xInitial + (x * (i)), y);
            }
        }
    }