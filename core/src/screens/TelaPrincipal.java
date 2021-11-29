/*package telas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import sprite.Forca;

public class TelaPrincipal implements Screen {
    SpriteBatch spriteBatch;
    public static Forca forca;

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1,1,1,1);
        Gdx.graphics.setTitle(Gdx.graphics.getFramesPerSecond() + " ");
        spriteBatch.begin();
        forca.desenhar(spriteBatch, delta);
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
        spriteBatch.dispose();
    }
}
*/