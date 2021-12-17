package sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import screens.InitialScreen;

public class BulletOrigin extends Sprite {
    float x, y = 100;
    public boolean active = true;

    public BulletOrigin() {
        super(InitialScreen.assetManager.get("bullet1.png",Texture.class));
        this.active = false;
        this.setSize(12,12);
        this.setPosition(200,90);
    }

    public void init(float x, float y) {
        this.x = x;
        this.y = y;
        active = true;
    }

    private void update(float delta) {
        // x += delta * 100;
        if (estaForaDaTela()) {
            System.out.println("saiu");
            active = false;
        }
    }

    public void draw(final SpriteBatch batch, float delta) {
        this.setRegion(280, 215, 13, 10);

        if (estaForaDaTela()) {
            active = false;
        }
        update(delta);
        super.draw(batch);
    }

    public boolean estaForaDaTela() {
        return (this.x > Gdx.graphics.getWidth());
    }
}