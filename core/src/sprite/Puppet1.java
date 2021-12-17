package sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import processor.BulletProcessor;
import processor.PuppetProcessor;
import screens.InitialScreen;

public class Puppet1 extends Sprite{
    private PuppetProcessor puppetProcessor;
    private BulletProcessor bulletProcessor;
    private float elapsedTime;
    private int idRegion = 1;
    Texture textureIdle;
    Texture textureRun;
    Texture textureShoot;
    public String letter;

    public Puppet1(){
        super(InitialScreen.assetManager.get("puppet/idle.png",Texture.class));
        textureIdle = InitialScreen.assetManager.get("puppet/idle.png", Texture.class);
        textureRun = InitialScreen.assetManager.get("puppet/run.png", Texture.class);
        textureShoot = InitialScreen.assetManager.get("puppet/shoot.png", Texture.class);

        puppetProcessor = new PuppetProcessor();
        bulletProcessor = new BulletProcessor();
        //Hangman.addInputProcessor(puppetProcessor);
        //Hangman.addInputProcessor(bulletProcessor);

        this.setPosition(30,18);
    }

    public void update(final float delta){
        if(puppetProcessor.upPress){
            this.setY(this.getY() + 150 * delta);
        }
        else if(puppetProcessor.downPress){
            this.setY(this.getY() - 150 * delta);
        }

        if (bulletProcessor.clicked){
            this.animate(textureShoot, delta, 3);
            //System.out.println("entrou");
        }
        elapsedTime += delta;
    }

    public void draw(final float delta, final SpriteBatch batch){
        super.draw(batch);
        update(delta);

        if(puppetProcessor.upPress || puppetProcessor.downPress){
            this.animate(textureRun, delta, 7);
            System.out.println("entrou 1");
        }else if(!puppetProcessor.upPress || !puppetProcessor.downPress){
            this.animate(textureIdle, delta, 8);
            System.out.println("entrou 2");
        }else if(bulletProcessor.clicked){
            this.animate(textureShoot, delta, 3);
        }
    }

/*
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
    }*/

    public void animate(Texture texture, float delta, int maxIdRegion){
        elapsedTime += delta;

        //this.setPosition(this.getX(),this.getY());
        this.setTexture(texture);

        if(elapsedTime >= 0.2){
            elapsedTime -= 0.2;
            if (idRegion >= maxIdRegion) {
                idRegion = 1;
            } else {
                idRegion++;
            }
        }

        this.setSize(80, 68);
        this.setRegion(idRegion * (80),0,80, 68);
    }
/*
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
    }*/
}
