package sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import telas.TelaInicial;

public class Forca implements Screen {

    public static Music musicaJogo;

    SpriteBatch spriteBatch;
    private static Texture forcaPrincipal;
    private FundoForca fundoForca;
    public Boneco boneco;

    public static InputMultiplexer multiplexer;

    public static void adicionarInputProcessor(InputProcessor inputProcessor){
        if(multiplexer == null){
            multiplexer = new InputMultiplexer();
            Gdx.input.setInputProcessor(multiplexer);
        }
        multiplexer.addProcessor(inputProcessor);
    }

    public Forca() {
        spriteBatch = new SpriteBatch();

        musicaJogo = TelaInicial.assetManager.get("musicaJogo.mp3", Music.class);
        musicaJogo.setVolume(0.7f);
        musicaJogo.setLooping(true);
        musicaJogo.play();

        forcaPrincipal = TelaInicial.assetManager.get("ForcaSemFundo1.jpg", Texture.class);
        fundoForca = new FundoForca();
        boneco = new Boneco();
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
        fundoForca.desenhar(spriteBatch);
        boneco.draw(delta, spriteBatch);
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