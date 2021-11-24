package sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import processor.BonecoProcessor;
import telas.TelaInicial;

public class Boneco extends Sprite{
    private BonecoProcessor bonecoProcessor;
    private float elapsedTime;
    private int idRegion = 1;

    public Boneco(){
        super(TelaInicial.assetManager.get("boneco/idleCerto.png",Texture.class));

        bonecoProcessor = new BonecoProcessor();
        Forca.adicionarInputProcessor(bonecoProcessor);

        //this.setSize(this.getWidth()/4, this.getHeight()/4);
        // this.setRegion(87,0,50,65); // Não desenha certo, veja a imagem original
        this.setPosition(10,18);
        //this.setPosition(0,0);
    }

    public void update(final float delta){
        if(bonecoProcessor.wPress){
            this.setY(this.getY() + 200 * delta);
        }
        else if(bonecoProcessor.sPress){
            this.setY(this.getY() - 200 * delta);
        }
        elapsedTime += delta;
/*
        if(elapsedTime > 0.2){
            if(idRegion > 10){
                idRegion = 1;
            }else{
                idRegion ++;
            }
            this.setRegion(54 + (246*idRegion),0,246,260);
        }*/
    }

    public void draw(final float delta, final SpriteBatch batch){
        super.draw(batch);
        update(delta);
        this.animate(delta);
    }

    public void animate(float delta){
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
}
