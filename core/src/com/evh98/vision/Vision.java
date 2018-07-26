package com.evh98.vision;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.evh98.vision.screen.HomeScreen;
import com.evh98.vision.screen.LockScreen;
import com.evh98.vision.screen.VisionScreen;
import com.evh98.vision.util.Graphics;

import java.util.Stack;

public class Vision extends Game {

	Stack<VisionScreen> navigationController;

	LockScreen lockScreen;
	public HomeScreen homeScreen;

	@Override
	public void create() {
		initServer();
		initAssets();
		initServices();
		initScreens();
	}

	private void initServer() {

	}

	private void initAssets() {
		Graphics.loadAll();
	}

	private void initServices() {

	}

	private void initScreens() {
		navigationController = new Stack<VisionScreen>();

		lockScreen = new LockScreen(this);
		homeScreen = new HomeScreen(this);

		navigationController.push(lockScreen);
		navigationController.push(homeScreen);

		setScreen(navigationController.peek());
	}

	public void back() {
		navigationController.pop();
		setScreen(navigationController.peek());
	}

	public void goToScreen(VisionScreen screen) {
		navigationController.push(screen);
		setScreen(navigationController.peek());
	}

	public void terminate() {
		Gdx.app.exit();
	}
}
