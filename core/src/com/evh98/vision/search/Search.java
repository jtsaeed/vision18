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
            // TODO: Check if null, if so, render some text or stn
            results.draw(spriteBatch);
        }

        spriteBatch.begin();
            spriteBatch.draw(Graphics.search, (Util.WIDTH - Graphics.search.getWidth()) / 2, topOffset);
            Graphics.drawText(spriteBatch, font, query,
                    Util.WIDTH / 2, topOffset + (Graphics.search.getHeight() / 2));
        spriteBatch.end();
    }

    public void update() {
        if (displayResults) {
            results.update();

            if (Controller.confirm()) {
                toggle();
            }

            if (Controller.back()) {
                displayResults = false;
                query = "";
            }
        } else {
            handleQueryInput();
        }
    }

    private void handleQueryInput() {
        if (query.length() <= maxCharacters) {
            query += Controller.textInput();
        }

        if (Controller.textInputBackspace() && query.length() > 0) {
            query = query.substring(0, query.length() - 1);
        }

        if (Controller.textInputConfirm()) {
            search(query);
        }
    }

    private void search(String query) {
        ArrayList<Card> pulledResults = searchEngine.getResults(query);

        if (pulledResults.size() > 0) {
            displayResults = true;
            results = new CardsManager(pulledResults);
        } else {
            // TODO: No results
        }
    }

    public void toggle() {
        isActive = !isActive;
        displayResults = false;
        query = "";
    }

    public boolean isActive() {
        return this.isActive;
    }
}
