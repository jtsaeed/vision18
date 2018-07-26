package com.evh98.vision.screen;

import com.evh98.vision.Vision;
import com.evh98.vision.ui.Palette;
import com.evh98.vision.ui.StatusBar;
import com.evh98.vision.ui.card.CardsManager;
import com.evh98.vision.ui.card.HomeCardsLoader;
import com.evh98.vision.ui.search.Search;
import com.evh98.vision.util.Controller;

public class HomeScreen extends VisionScreen {

    private Search search;
    private CardsManager cards;
    private StatusBar statusBar;

    public HomeScreen(Vision vision) {
        super(vision);

        search = new Search();
        cards = new CardsManager(HomeCardsLoader.loadCards());
        statusBar = new StatusBar(Palette.grayDark);
    }

    @Override
    public void draw(float delta) {
        cards.draw(spriteBatch);
        statusBar.draw(spriteBatch);

        if (search.isActive()) {
            search.draw(spriteBatch);
        }
    }

    @Override
    public void update() {
        if (Controller.search()) {
            search.toggle();
        }

        if (search.isActive()) {
            search.update();
        } else {
            cards.update();
            statusBar.update();
        }
    }
}
