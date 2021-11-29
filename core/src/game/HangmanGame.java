package game;

import com.badlogic.gdx.*;
import screens.InitialScreen;

public class HangmanGame extends Game {
	public static InputMultiplexer multiplexer;

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
	}

	@Override
	public void render () {
		super.render();
	}
}