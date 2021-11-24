package sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import telas.TelaInicial;

public class FundoForca extends Sprite{

    public FundoForca(){
        super(TelaInicial.assetManager.get("ForcaSemFundo1.jpg", Texture.class));
    }

    public void desenhar(SpriteBatch batch){
        super.draw(batch);
        this.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
}