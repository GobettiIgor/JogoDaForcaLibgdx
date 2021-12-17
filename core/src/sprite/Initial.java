package sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import screens.InitialScreen;

public class Initial extends Sprite {

    public Initial(){
        super(InitialScreen.assetManager.get("TelaInicialForca.png", Texture.class));
        this.setSize(1200,800);
    }

    public void draw(final SpriteBatch batch){
        super.draw(batch);
    }
}
