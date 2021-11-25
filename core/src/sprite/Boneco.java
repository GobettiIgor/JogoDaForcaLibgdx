package sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import processor.BonecoProcessor;
import telas.TelaInicial;

public class Boneco extends Sprite{
    private BonecoProcessor bonecoProcessor;
    private float elapsedTime;
    private int idRegion = 1;
    Texture textureRun;
    private Sprite run;

    public Boneco(){
        super(TelaInicial.assetManager.get("boneco/idle.png",Texture.class));
        textureRun = TelaInicial.assetManager.get("boneco/run8.png", Texture.class);
        run = new Sprite();
        run.setTexture(textureRun);

        bonecoProcessor = new BonecoProcessor();
        Forca.adicionarInputProcessor(bonecoProcessor);

        this.setPosition(10,18);
    }

    public void update(final float delta){
        if(bonecoProcessor.wPress){
            this.setY(this.getY() + 150 * delta);
            //this.animateRun(delta);
        }
        else if(bonecoProcessor.sPress){
            this.setY(this.getY() - 150 * delta);
            //this.animateRun(delta);
        }
        elapsedTime += delta;
    }

    public void draw(final float delta, final SpriteBatch batch){
        super.draw(batch);
        update(delta);
        this.animateRun(delta);
        //this.animateIdle(delta);

    }

    public void animateIdle(float delta){
        elapsedTime += delta;

        if(elapsedTime >= 0.2){
            elapsedTime -= 0.2;
            if (idRegion == 9) {
                idRegion = 1;
            } else {
                idRegion++;
            }
        }

        this.setSize(80, 68);
        this.setRegion(idRegion * (80),0,80, 68);
    }

    public void animateRun(float delta){
        elapsedTime += delta;

        this.setTexture(textureRun);
        run.setPosition(this.getX(),this.getY());

        if(elapsedTime >= 0.2){
            elapsedTime -= 0.2;
            if (idRegion == 7) {
                idRegion = 1;
            } else {
                idRegion++;
            }
        }

        this.setSize(80, 68);
        this.setRegion(idRegion * (80),0,80, 68);
    }
}
