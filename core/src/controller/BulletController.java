package controller;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import game.HangmanGame;
import sprite.BulletOrigin;
import sprite.Hangman;

import java.util.ArrayList;

public abstract class BulletController {
    static ArrayList<BulletOrigin> bullets = new ArrayList<BulletOrigin>();
    static ArrayList<BulletOrigin> inactiveBullets = new ArrayList<BulletOrigin>();
    private static InputProcessor bulletProcessor;
    static BulletOrigin bullet;

    public static void init(){
        System.out.println("passou123");
        bulletProcessor = new InputAdapter(){
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                System.out.println("passou");
                if(inactiveBullets.size() > 0){
                    bullet = inactiveBullets.remove(0);
                }
                else{
                    bullet = new BulletOrigin();
                }

                /*Sound soundTiro = Gdx.audio.newSound(Gdx.files.internal("tiro.mp3"));
                soundTiro.play();*/

                bullet = new BulletOrigin();
                bullet.init(Hangman.puppet.getX() + Hangman.puppet.getWidth()/2,
                        Hangman.puppet.getY() + Hangman.puppet.getHeight()/2);
                bullets.add(bullet);
                return false;
            }
        };
        HangmanGame.addInputProcessor(bulletProcessor);
    }

    public static void draw(final SpriteBatch spriteBatch, float delta) {
        for(BulletOrigin bullet : bullets) {
            if(!bullet.active){
                bullets.remove(bullet);
                inactiveBullets.add(bullet);
            }
            bullet.draw(spriteBatch, delta);
        }
    }
}
