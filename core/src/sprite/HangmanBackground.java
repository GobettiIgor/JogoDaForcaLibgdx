package sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import screens.InitialScreen;

public class HangmanBackground extends Sprite{

    public HangmanBackground(){
        super(InitialScreen.assetManager.get("ForcaSemFundo.jpg", Texture.class));
    }

    public void draw(SpriteBatch batch){
        super.draw(batch);
        this.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
}