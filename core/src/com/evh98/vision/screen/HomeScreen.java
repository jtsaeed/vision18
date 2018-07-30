package com.evh98.vision.screen;

import com.evh98.vision.Vision;
import com.evh98.vision.util.Icon;
import com.evh98.vision.util.Palette;
import com.evh98.vision.util.StatusBar;
import com.evh98.vision.card.Card;
import com.evh98.vision.card.CardAction;
import com.evh98.vision.card.CardsManager;
import com.evh98.vision.card.HomeCardsLoader;

public class HomeScreen extends VisionScreen {

    private CardsManager cards;
    private StatusBar statusBar;

    public HomeScreen(Vision vision) {
        super(vision);

        this.cards = new CardsManager(HomeCardsLoader.loadCards());
        this.cards.addCard(new Card("Email", Icon.browser, Palette.blues, new CardAction("app", vision.testScreen, vision)));
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
