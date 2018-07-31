package com.evh98.vision;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.evh98.vision.card.CardsManager;
import com.evh98.vision.notification.NotificationService;
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
	public NotificationService notificationService;

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
		cards = new CardsManager(HomeCardsLoader.loadCards());
	}

	private void initAssets() {
		Graphics.loadAll();
	}

	private void initServices() {
		backgroundService = new BackgroundService(this);
		backgroundService.start();

		notificationService = new NotificationService(this	);
	}

	private void initScreens() {
		navigationController = new Stack<VisionScreen>();

		lockScreen = new LockScreen(this);
		homeScreen = new HomeScreen(this);
		testScreen = new TestScreen(this);

		navigationController.push(lockScreen);
		navigationController.push(homeScreen);

		setScreen(navigationController.peek());
	}

	public void lock() {
		while (navigationController.size() > 1) {
			back();
		}
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
		backgroundService.stop();
		Gdx.app.exit();
	}
}
