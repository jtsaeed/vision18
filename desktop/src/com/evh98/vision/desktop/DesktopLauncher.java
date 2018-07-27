package com.evh98.vision.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.evh98.vision.Vision;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 1280;
		config.height = 720;
		config.fullscreen = false;
		config.useHDPI = true;
		config.title = "Vision";

		new LwjglApplication(new Vision(), config);
	}
}
