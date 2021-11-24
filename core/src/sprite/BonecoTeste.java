package sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import processor.BonecoProcessor;
import telas.TelaInicial;

public class BonecoTeste extends Sprite{
    private BonecoProcessor bonecoProcessor;
    Animation<TextureRegion> animation;
    TextureRegion currentFrame;

    private float elapsedTime;

    public BonecoTeste(){
        super(TelaInicial.assetManager.get("boneco/idle.png",Texture.class));

        bonecoProcessor = new BonecoProcessor();
        Forca.adicionarInputProcessor(bonecoProcessor);

        TextureRegion[][] regionAlternate = new TextureRegion[10][1];
        regionAlternate = TextureRegion.split(this.getTexture(),10,1);
        TextureRegion[] walkFrame = new TextureRegion[10];

        int indexAnimation = 0;

        for (int i=0; i < 1; i++){
            for (int j = 0; j < 10; j++){
                walkFrame[indexAnimation++] = regionAlternate[i][j];
            }
        }
        elapsedTime = 0f;

        this.setPosition(0,0);
    }

    public void update(final float delta){
        if(bonecoProcessor.wPress){
            this.setY(this.getY() + 200 * delta);
        }
        else if(bonecoProcessor.sPress){
            this.setY(this.getY() - 200 * delta);
        }

        elapsedTime += delta;

        if(elapsedTime >= 0.2){
            currentFrame = animation.getKeyFrame(elapsedTime, true);
            //currentFrame.setRegion();
        }
    }

    public void desenhar(final SpriteBatch batch, final float delta){
        update(delta);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
        batch.draw(currentFrame,0,0);
        //super.draw(batch);
    }

    public void animation(float delta){

    }
}
