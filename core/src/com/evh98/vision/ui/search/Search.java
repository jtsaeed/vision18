package com.evh98.vision.ui.search;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evh98.vision.util.Graphics;

public class Search {

    private String query;
    private boolean isActive;

    public Search() {
        this.isActive = false;
    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.begin();
            spriteBatch.draw(Graphics.search, 0, 0);
        spriteBatch.end();
    }

    public void update() {

    }

    public void toggle() {
        this.isActive = !this.isActive;
    }

    public boolean isActive() {
        return this.isActive;
    }
}
