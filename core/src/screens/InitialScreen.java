package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import game.ControllerClickMenu;
import sprite.Hangman;

public class InitialScreen implements Screen {
    SpriteBatch spriteBatch;
    public static AssetManager assetManager;

    public static Music musicaPrincipal;

    private Texture texturaInicial;
    private Texture btIniciar; // botão
    private Texture btConfiguracao; // botão
    private Texture tituloForca;

    private Texture desativarSomGeral; // botão
    private Texture desativarEfeitosSonoros; // botão

    private static Game game;

    public InitialScreen(Game game) {
        this.game = game;
        ControllerClickMenu.init();
    }

    public void carregaAssets() {
        assetManager = new AssetManager();

        assetManager.load("musicaJogo.mp3", Music.class);
        assetManager.load("musicaPrincipal.mp3",Music.class);
        assetManager.load("TelaInicialForca.png", Texture.class);
        assetManager.load("btIniciar.png", Texture.class);
        assetManager.load("btConfiguracao.png", Texture.class);
        assetManager.load("tituloForca.png", Texture.class);
        assetManager.load("ForcaSemFundo1.jpg", Texture.class);
        assetManager.load("desativarSomGeral.png", Texture.class);
        assetManager.load("desativarEfeitosSonoros.png", Texture.class);
        assetManager.load("puppet/idle.png", Texture.class);
        assetManager.load("puppet/run.png", Texture.class);
        assetManager.load("puppet/shoot.png", Texture.class);
        assetManager.load("game/box.png", Texture.class);
        assetManager.load("fonts/font.fnt", BitmapFont.class);

        assetManager.finishLoading();
    }

    @Override
    public void show() {
        carregaAssets();
        texturaInicial = assetManager.get("TelaInicialForca.png", Texture.class);
        btIniciar = assetManager.get("btIniciar.png", Texture.class);
        btConfiguracao = assetManager.get("btConfiguracao.png", Texture.class);
        tituloForca = assetManager.get("tituloForca.png", Texture.class);
        desativarSomGeral = assetManager.get("desativarSomGeral.png", Texture.class);
        desativarEfeitosSonoros = assetManager.get("desativarEfeitosSonoros.png", Texture.class);

        musicaPrincipal = assetManager.get("musicaPrincipal.mp3", Music.class);
        musicaPrincipal.setVolume(0.7f);
        musicaPrincipal.setLooping(true);
        musicaPrincipal.play();

        spriteBatch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,0);
        Gdx.graphics.setTitle(Gdx.graphics.getFramesPerSecond() + " ");

        spriteBatch.begin();
        spriteBatch.draw(texturaInicial, 0, 0);
        spriteBatch.draw(tituloForca, 210, 350);
        spriteBatch.draw(btIniciar, 260, 200);
        spriteBatch.draw(btConfiguracao, 260, 100);
        Gdx.graphics.setTitle(Gdx.graphics.getFramesPerSecond() + " ");

        if(Gdx.input.isTouched()) {
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