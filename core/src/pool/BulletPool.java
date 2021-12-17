package pool;

import com.badlogic.gdx.utils.Pool;
import sprite.Bullet;

public class BulletPool extends Pool<Bullet> {

    public BulletPool(int init, int max){
        super(init,max);
    }

    public BulletPool(){
        super();
    }

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}