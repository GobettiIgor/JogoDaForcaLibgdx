package game;

import com.badlogic.gdx.*;
import screens.InitialScreen;
import screens.Teste;

public class HangmanGame extends Game {
	public static InputMultiplexer multiplexer;
	public static HangmanGame hangmanGame;

	public static void addInputProcessor(InputProcessor inputProcessor){
		if(multiplexer == null){
			multiplexer = new InputMultiplexer();
			Gdx.input.setInputProcessor(multiplexer);
		}
		multiplexer.addProcessor(inputProcessor);
	}

	@Override
	public void create() {
		this.setScreen( new InitialScreen(this));
		hangmanGame = this;
	}

	@Override
	public void render () {
		super.render();
	}
}