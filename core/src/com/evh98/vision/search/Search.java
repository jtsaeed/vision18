package com.evh98.vision.search;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evh98.vision.Vision;
import com.evh98.vision.util.Palette;
import com.evh98.vision.card.Card;
import com.evh98.vision.card.CardsManager;
import com.evh98.vision.util.Controller;
import com.evh98.vision.util.Graphics;
import com.evh98.vision.util.Util;

import java.util.ArrayList;

public class Search {

    private final BitmapFont font;

    private String query;
    private boolean isActive;
    private boolean displayResults;

    private final SearchEngine searchEngine;
    private CardsManager results;

    private final int maxCharacters = 32;
    private final int topOffset = 1088;

    public Search(Vision vision) {
        this.font = Graphics.createFont(Graphics.systemFont, 96, Palette.whitePure);

        this.query = "";
        this.isActive = false;
        this.displayResults = false;

        this.searchEngine = new SearchEngine(vision);
    }

    public void draw(SpriteBatch spriteBatch) {
        if (displayResults) {
            this.results.draw(spriteBatch);
        }

        spriteBatch.begin();
            spriteBatch.draw(Graphics.search, (Util.WIDTH - Graphics.search.getWidth()) / 2, topOffset);
            Graphics.drawText(spriteBatch, font, query,
                    Util.WIDTH / 2, topOffset + (Graphics.search.getHeight() / 2));
        spriteBatch.end();
    }

    public void update() {
        if (displayResults) {
            this.results.update();

            if (Controller.confirm()) {
                toggle();
            }

            if (Controller.back()) {
                this.displayResults = false;
                this.query = "";
            }
        } else {
            handleQueryInput();
        }
    }

    private void handleQueryInput() {
        if (this.query.length() <= this.maxCharacters) {
            this.query += Controller.textInput();
        }

        if (Controller.textInputBackspace() && this.query.length() > 0) {
            this.query = this.query.substring(0, this.query.length() - 1);
        }

        if (Controller.textInputConfirm()) {
            search(query);
        }
    }

    private void search(String query) {
        ArrayList<Card> results = this.searchEngine.getResults(query);

        if (results.size() > 0) {
            this.displayResults = true;
            this.results = new CardsManager(results);
        } else {
            // TODO: No results
        }
    }

    public void toggle() {
        this.isActive = !this.isActive;
        this.displayResults = false;
        this.query = "";
    }

    public boolean isActive() {
        return this.isActive;
    }
}
