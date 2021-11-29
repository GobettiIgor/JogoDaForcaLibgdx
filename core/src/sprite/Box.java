package sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import screens.InitialScreen;

public class Box extends Sprite {
    public Box() {
        super(InitialScreen.assetManager.get("game/box.png", Texture.class));
        this.setSize(this.getWidth() * 0.8f, this.getHeight() * 0.8f);
    }

    public void draw(final SpriteBatch batch, int posX, int posY) {
        super.draw(batch);
        this.setPosition(posX, posY);
    }
}
