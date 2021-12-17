package game;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

public abstract class ControllerClickMenu {
    private static InputProcessor processorClickMenu;
    public static String click;

    public static void init(){
        processorClickMenu = new InputAdapter(){
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                if(screenX >= 560 && screenX <= 730  && screenY >= 435 && screenY <= 497){
                    click = "INICIAR";
                }
                else if(screenX >= 560 && screenX <= 820  && screenY >= 533 && screenY <= 600){
                    click = "CONFIGURACAO";
                }
                return false;
            }
        };
        HangmanGame.addInputProcessor(processorClickMenu);
    }
}