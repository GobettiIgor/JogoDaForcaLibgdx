package com.mygdx.game;

import com.badlogic.gdx.*;
import telas.TelaInicial;

public class JogoDaForca extends Game {
	public static InputMultiplexer multiplexer;

	public static void adicionarInputProcessor(InputProcessor inputProcessor){
		if(multiplexer == null){
			multiplexer = new InputMultiplexer();
			Gdx.input.setInputProcessor(multiplexer);
		}
		multiplexer.addProcessor(inputProcessor);
	}

	@Override
	public void create() {
		this.setScreen( new TelaInicial(this));
	}

	@Override
	public void render () {
		super.render();
	}
}