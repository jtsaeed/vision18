package com.evh98.vision.screen;

import com.evh98.vision.Vision;
import com.evh98.vision.ui.Card;
import com.evh98.vision.ui.Icon;
import com.evh98.vision.ui.Palette;
import com.evh98.vision.ui.StatusBar;
import com.evh98.vision.util.CardsManager;

public class HomeScreen extends VisionScreen {

    private StatusBar statusBar;
    private CardsManager cards;

    public HomeScreen(Vision vision) {
        super(vision);

        statusBar = new StatusBar(Palette.grayDark);

        Card one = new Card("SteamVR", Icon.game, Palette.red, Palette.redPastel);
        Card two = new Card("Plex", Icon.movie, Palette.yellow, Palette.yellowPastel);
        Card three = new Card("Trains", Icon.train, Palette.green, Palette.greenPastel);
        Card four = new Card("Flights", Icon.plane, Palette.blue, Palette.bluePastel);

        cards = new CardsManager(one, two, three, four);
    }

    @Override
    public void draw(float delta) {
        cards.draw(spriteBatch);
        statusBar.draw(spriteBatch);
    }

    @Override
    public void update() {
        cards.update();
        statusBar.update();
    }
}
