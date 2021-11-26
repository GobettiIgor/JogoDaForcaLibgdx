package processor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class BulletProcessor extends InputAdapter {
    public boolean clicked;

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Buttons.LEFT || keycode == Input.Keys.SPACE || Gdx.input.isTouched()){
            clicked = true;
            System.out.println("entrou123");
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Buttons.LEFT || keycode == Input.Keys.SPACE){
            clicked = false;
            System.out.println("entrou2");
        }
        return false;
    }
}

