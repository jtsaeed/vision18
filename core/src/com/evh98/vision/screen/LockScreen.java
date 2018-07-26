package com.evh98.vision.screen;

import com.evh98.vision.Vision;
import com.evh98.vision.ui.Palette;
import com.evh98.vision.ui.StatusBar;
import com.evh98.vision.util.Controller;
import com.evh98.vision.util.Graphics;

public class LockScreen extends VisionScreen {

    private StatusBar statusBar;

    public LockScreen(Vision vision) {
        super(vision);

        statusBar = new StatusBar(Palette.white);
    }

    @Override public void show() {

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
            spriteBatch.draw(Graphics.wallpapers.get(0), 0, 0);
        spriteBatch.end();
    }

    @Override
    public void update() {
        if (Controller.confirm()) {
            unlock();
        }

        statusBar.update();
    }

    private void unlock() {
        vision.goToScreen(vision.homeScreen);
    }
}
