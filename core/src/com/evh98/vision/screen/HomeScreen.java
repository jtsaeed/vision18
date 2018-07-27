package com.evh98.vision.screen;

import com.evh98.vision.Vision;
import com.evh98.vision.ui.Palette;
import com.evh98.vision.ui.StatusBar;
import com.evh98.vision.ui.card.CardsManager;
import com.evh98.vision.ui.card.HomeCardsLoader;
import com.evh98.vision.ui.search.Search;
import com.evh98.vision.util.Controller;

public class HomeScreen extends VisionScreen {

    private CardsManager cards;
    private StatusBar statusBar;

    public HomeScreen(Vision vision) {
        super(vision);

        this.cards = new CardsManager(HomeCardsLoader.loadCards());
        this.statusBar = new StatusBar(Palette.grayDark);
    }

    @Override
    public void draw(float delta) {
        this.cards.draw(spriteBatch);
        this.statusBar.draw(spriteBatch);
    }

    @Override
    public void update() {
        this.cards.update();
        this.statusBar.update();
    }
}
