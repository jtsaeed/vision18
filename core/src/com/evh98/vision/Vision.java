package com.evh98.vision;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.evh98.vision.net.RemoteServer;
import com.evh98.vision.screen.HomeScreen;
import com.evh98.vision.screen.LockScreen;
import com.evh98.vision.screen.TestScreen;
import com.evh98.vision.screen.VisionScreen;
import com.evh98.vision.ui.card.Card;
import com.evh98.vision.ui.card.HomeCardsLoader;
import com.evh98.vision.util.BackgroundService;
import com.evh98.vision.util.Graphics;

import java.util.ArrayList;
import java.util.Stack;

public class Vision extends Game {

	public BackgroundService backgroundService;
	private RemoteServer remoteServer;

	private Stack<VisionScreen> navigationController;
	private LockScreen lockScreen;
	public HomeScreen homeScreen;
	public ArrayList<Card> homeCards;
	public TestScreen testScreen;

	@Override
	public void create() {
		initAssets();
		initServices();
		initScreens();
	}

	private void initAssets() {
		Graphics.loadAll();
	}

	private void initServices() {
		this.remoteServer = new RemoteServer();
		this.remoteServer.start();
		this.backgroundService = new BackgroundService(this);
		this.backgroundService.start();
	}

	private void initScreens() {
		this.navigationController = new Stack<VisionScreen>();

		this.lockScreen = new LockScreen(this);
		this.homeScreen = new HomeScreen(this);
		this.homeCards = HomeCardsLoader.loadCards();
		this.testScreen = new TestScreen(this);

		this.navigationController.push(lockScreen);
		this.navigationController.push(homeScreen);

		setScreen(this.navigationController.peek());
	}

	public void lock() {
		while (this.navigationController.size() > 1) {
			back();
		}
	}

	public void back() {
		this.navigationController.pop();
		setScreen(this.navigationController.peek());
	}

	public void goToScreen(VisionScreen screen) {
		this.navigationController.push(screen);
		setScreen(this.navigationController.peek());
	}

	public void terminate() {
		this.remoteServer.interrupt();
		Gdx.app.exit();
	}
}
