package processor;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import game.HangmanGame;

public class CongratulationsProcessor {
    public static boolean clicked;
    private static InputProcessor congratulationsProcessor;

    public static void init(){
        congratulationsProcessor = new InputAdapter(){
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                clicked = true;
                return false;
            }
        };
        HangmanGame.addInputProcessor(congratulationsProcessor);
    }
}
