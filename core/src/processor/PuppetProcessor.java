package processor;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class PuppetProcessor extends InputAdapter {
    public boolean upPress;
    public boolean downPress;

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.UP){
            upPress = true;
        }
        else if(keycode == Input.Keys.DOWN){
            downPress = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.UP){
            upPress = false;
        }
        else if(keycode == Input.Keys.DOWN){
            downPress = false;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }
}
