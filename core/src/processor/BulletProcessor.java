package processor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import sprite.Hangman;

public class BulletProcessor extends InputAdapter {
    public boolean clicked;

    @Override
    public boolean keyDown(int keycode) {/*
        if(keycode == Input.Buttons.LEFT || keycode == Input.Keys.SPACE || Gdx.input.isTouched()){
            clicked = true;
        }
        if(keycode == Input.Keys.A){
            letter = 'A';
        }
        else if(keycode == Input.Keys.B){
            letter = 'B';
        }
        else if(keycode == Input.Keys.C){
            letter = 'C';
        }
        else if(keycode == Input.Keys.D){
            letter = 'D';
        }
        else if(keycode == Input.Keys.E){
            letter = 'E';
        }
        else if(keycode == Input.Keys.F){
            letter = 'F';
        }
        else if(keycode == Input.Keys.G){
            letter = 'G';
        }
        else if(keycode == Input.Keys.H){
            letter = 'H';
        }
        else if(keycode == Input.Keys.I){
            letter = 'I';
        }
        else if(keycode == Input.Keys.J){
            letter = 'J';
        }
        else if(keycode == Input.Keys.K){
            letter = 'K';
        }
        else if(keycode == Input.Keys.L){
            letter = 'L';
        }
        else if(keycode == Input.Keys.M){
            letter = 'M';
        }
        else if(keycode == Input.Keys.N){
            letter = 'N';
        }
        else if(keycode == Input.Keys.O){
            letter = 'O';
        }
        else if(keycode == Input.Keys.P){
            letter = 'P';
        }
        else if(keycode == Input.Keys.Q){
            letter = 'Q';
        }
        else if(keycode == Input.Keys.R){
            letter = 'R';
        }
        else if(keycode == Input.Keys.S){
            letter = 'S';
        }
        else if(keycode == Input.Keys.T){
            letter = 'T';
        }
        else if(keycode == Input.Keys.U){
            letter = 'U';
        }
        else if(keycode == Input.Keys.V){
            letter = 'V';
        }
        else if(keycode == Input.Keys.W){
            letter = 'W';
        }
        else if(keycode == Input.Keys.X){
            letter = 'X';
        }
        else if(keycode == Input.Keys.Y){
            letter = 'Y';
        }
        else if(keycode == Input.Keys.Z){
            letter = 'Z';
        }*/
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Buttons.LEFT || keycode == Input.Keys.SPACE){
            clicked = false;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }
}

