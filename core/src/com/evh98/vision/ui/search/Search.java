package com.evh98.vision.ui.search;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evh98.vision.ui.Palette;
import com.evh98.vision.util.Controller;
import com.evh98.vision.util.Graphics;
import com.evh98.vision.util.Util;

public class Search {

    private final BitmapFont font;

    private String query;
    private boolean isActive;

    private final int maxCharacters = 32;
    private final int topOffset = 1088;

    public Search() {
        this.font = Graphics.createFont(Graphics.systemFont, 96, Palette.whitePure);

        this.query = "";
        this.isActive = false;
    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.begin();
            spriteBatch.draw(Graphics.search, (Util.WIDTH - Graphics.search.getWidth()) / 2, topOffset);
            Graphics.drawText(spriteBatch, font, query,
                    Util.WIDTH / 2, topOffset + (Graphics.search.getHeight() / 2));
        spriteBatch.end();
    }

    public void update() {
        handleQueryInput();
    }

    private void handleQueryInput() {
        if (this.query.length() <= this.maxCharacters) {
            this.query += Controller.textInput();
        }

        if (Controller.textInputBackspace() && this.query.length() > 0) {
            this.query = this.query.substring(0, this.query.length() - 1);
        }

        if (Controller.textInputConfirm()) {

        }
    }

    public void toggle() {
        this.isActive = !this.isActive;
        this.query = "";
    }

    public boolean isActive() {
        return this.isActive;
    }
}
