package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import game.ControllerClickMenu;
import game.HangmanGame;
import sprite.Hangman;
import sprite.Initial;

public class InitialScreen implements Screen {
    SpriteBatch spriteBatch;
    public static AssetManager assetManager;
    public Initial initial;
    private Texture tituloForca;

    public static Music musicaPrincipal;

    private Texture texturaInicial;
    // private Texture btIniciar; // botão
    private Texture btConfiguracao; // botão

    private Stage stage;
    Skin skinBt = new Skin(Gdx.files.internal("bt/bt.json")); // pode ser aqui o problema, pegar pronta..
    private Button btIniciar = new TextButton("Play", skinBt);

    private Texture desativarSomGeral; // botão
    private Texture desativarEfeitosSonoros; // botão

    private static Game game;

    public InitialScreen(Game game) {
        this.game = game;
        ControllerClickMenu.init();
        stage = new Stage(new ScreenViewport());
        //Gdx.input.setInputProcessor(stage);
        HangmanGame.addInputProcessor(stage);
        int row_height = Gdx.graphics.getWidth() / 12;
        int col_width = Gdx.graphics.getWidth() / 12;
        btIniciar.setSize(col_width*4,row_height);
        btIniciar.setPosition(col_width*7,Gdx.graphics.getHeight()-row_height*3);
        btIniciar.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Press a Button");
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Press a Button 2");
                return true;
            }
        });
        stage.addActor(btIniciar);
    }

    public void carregaAssets() {
        assetManager = new AssetManager();

        assetManager.load("gameMusic.ogg", Music.class);
        assetManager.load("musicaPrincipal.mp3", Music.class);
        assetManager.load("gameOverSound.mp3", Sound.class);
        assetManager.load("TelaInicialForca.png", Texture.class);
        assetManager.load("btIniciar.png", Texture.class);
        assetManager.load("btConfiguracao.png", Texture.class);
        assetManager.load("tituloForca.png", Texture.class);
        assetManager.load("ForcaSemFundo.jpg", Texture.class);
        assetManager.load("desativarSomGeral.png", Texture.class);
        assetManager.load("desativarEfeitosSonoros.png", Texture.class);
        assetManager.load("puppet/puppet.png",  Texture.class);
        assetManager.load("victorySound.mp3", Sound.class);
        assetManager.load("puppet/char1.png", Texture.class);
        assetManager.load("bullet1.png", Texture.class);
        assetManager.load("game/box.png", Texture.class);
        assetManager.load("fonts/font.fnt", BitmapFont.class);

        assetManager.finishLoading();
    }

    @Override
    public void show() {
        carregaAssets();
        texturaInicial = assetManager.get("TelaInicialForca.png", Texture.class);
        //btIniciar = assetManager.get("btIniciar.png", Texture.class);
        btConfiguracao = assetManager.get("btConfiguracao.png", Texture.class);
        tituloForca = assetManager.get("tituloForca.png", Texture.class);
        desativarSomGeral = assetManager.get("desativarSomGeral.png", Texture.class);
        desativarEfeitosSonoros = assetManager.get("desativarEfeitosSonoros.png", Texture.class);

        musicaPrincipal = assetManager.get("musicaPrincipal.mp3", Music.class);
        musicaPrincipal.setVolume(0.7f);
        musicaPrincipal.setLooping(true);
        musicaPrincipal.play();

        spriteBatch = new SpriteBatch();
        initial = new Initial();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,0);
        Gdx.graphics.setTitle(Gdx.graphics.getFramesPerSecond() + " ");

        spriteBatch.begin();
        initial.draw(spriteBatch);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        spriteBatch.draw(tituloForca, 420, 630);
        //spriteBatch.draw(btIniciar, 560, 300);
        spriteBatch.draw(btConfiguracao, 560, 200);
        Gdx.graphics.setTitle(Gdx.graphics.getFramesPerSecond() + " ");

        if(Gdx.input.isTouched()) {
            // System.out.println("X: " + Gdx.input.getX() + " - Y: " + Gdx.input.getY());
            if (ControllerClickMenu.click.equals("INICIAR")) {
                musicaPrincipal.stop();

                game.setScreen(new Hangman());
                //dispose(); // Onde chamo o dispose antes de iniciar a outra tela?? Porque a próxima tela instancia um novo SpriteBatch

            } else if (ControllerClickMenu.click.equals("CONFIGURACAO")) {
                game.setScreen(new TelaConfiguracao());
                //System.out.println(ControladorClickMenu.click);
            }
        }
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

    public void dispose() {
        spriteBatch.dispose();
    }
}