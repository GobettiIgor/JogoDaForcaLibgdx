package processor;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class PuppetProcessor extends InputAdapter {
    public boolean wPress;
    public boolean sPress;

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.W){
            wPress = true;
        }
        else if(keycode == Input.Keys.S){
            sPress = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.W){
            wPress = false;
        }
        else if(keycode == Input.Keys.S){
            sPress = false;
        }
        return false;
    }
}
