package com.evh98.vision.screen;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.evh98.vision.Vision;
import com.evh98.vision.util.Palette;
import com.evh98.vision.util.StatusBar;
import com.evh98.vision.util.Controller;
import com.evh98.vision.util.Graphics;

import java.util.Random;

public class LockScreen extends VisionScreen {

    private StatusBar statusBar;
    private Sprite screensaver;

    public LockScreen(Vision vision) {
        super(vision);

        this.statusBar = new StatusBar(Palette.white);
        chooseRandomScreensaver();
    }

    @Override public void show() {
        chooseRandomScreensaver();
    }

    @Override
    public void render(float delta) {
        initGL();
        syncCamera();

        drawScreensaver();

        statusBar.draw(spriteBatch);

        update();
    }

    private void drawScreensaver() {
        spriteBatch.begin();
            spriteBatch.draw(this.screensaver, 0, 0);
        spriteBatch.end();
    }

    private void chooseRandomScreensaver() {
        this.screensaver = Graphics.screensavers.get(new Random().nextInt(Graphics.screensavers.size()));
    }

    @Override
    public void update() {
        if (Controller.confirm()) {
            unlock();
        }
    }

    private void unlock() {
        vision.goToScreen(vision.homeScreen);
    }
}
