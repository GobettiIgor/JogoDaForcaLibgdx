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
                if(screenX >= 260 && screenX <= 470  && screenY >= 213 && screenY <= 280){
                    click = "INICIAR";
                }
                else if(screenX >= 260 && screenX <= 560  && screenY >= 313 && screenY <= 380){
                    click = "CONFIGURACAO";
                }
                return false;
            }
        };
        HangmanGame.addInputProcessor(processorClickMenu);
    }
}