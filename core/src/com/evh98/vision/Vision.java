package com.evh98.vision;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.evh98.vision.card.CardsManager;
import com.evh98.vision.util.RemoteServer;
import com.evh98.vision.screen.HomeScreen;
import com.evh98.vision.screen.LockScreen;
import com.evh98.vision.screen.TestScreen;
import com.evh98.vision.screen.VisionScreen;
import com.evh98.vision.card.HomeCardsLoader;
import com.evh98.vision.util.BackgroundService;
import com.evh98.vision.util.Graphics;

import java.util.Stack;

public class Vision extends Game {

	public CardsManager cards;

	public BackgroundService backgroundService;
	private RemoteServer remoteServer;

	private Stack<VisionScreen> navigationController;
	private LockScreen lockScreen;
	public HomeScreen homeScreen;
	public TestScreen testScreen;

	@Override
	public void create() {
		initAssets();
		initMisc();
		initServices();
		initScreens();
	}

	private void initMisc() {
		Gdx.input.setCursorCatched(true);
		this.cards = new CardsManager(HomeCardsLoader.loadCards());
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
		this.backgroundService.stop();
		this.remoteServer.interrupt();
		Gdx.app.exit();
	}
}
