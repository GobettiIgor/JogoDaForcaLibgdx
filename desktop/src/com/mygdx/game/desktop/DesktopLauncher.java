package com.mygdx.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import game.HangmanGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Hangman Game with LibGDX";
		config.pauseWhenBackground = true;
		config.pauseWhenMinimized = true;
		config.addIcon("forca.png", Files.FileType.Internal);
		config.foregroundFPS = 0;
		config.vSyncEnabled = false;
		new LwjglApplication(new HangmanGame(), config);
		Gdx.graphics.setResizable(true);
	}
}