package com.evh98.vision.screen;

import com.evh98.vision.Vision;
import com.evh98.vision.ui.Card;
import com.evh98.vision.ui.Icon;
import com.evh98.vision.ui.Palette;
import com.evh98.vision.ui.StatusBar;
import com.evh98.vision.util.Controller;

import java.util.ArrayList;

public class HomeScreen extends VisionScreen {

    private StatusBar statusBar;
    private ArrayList<Card> cards;

    int position = 0;

    public HomeScreen(Vision vision) {
        super(vision);

        statusBar = new StatusBar(Palette.grayDark);

        cards = new ArrayList<Card>();
        cards.add(new Card("SteamVR", Icon.game, Palette.red, Palette.redPastel));
        cards.add(new Card("Plex", Icon.movie, Palette.yellow, Palette.yellowPastel));
        cards.add(new Card("Trains", Icon.train, Palette.green, Palette.greenPastel));
        cards.add(new Card("Flights", Icon.plane, Palette.blue, Palette.bluePastel));

        cards.get(position).select();
    }

    @Override
    public void draw(float delta) {
        for (int i = 0; i < cards.size(); i++) {
            cards.get(i).draw(spriteBatch, i, position);
        }

        statusBar.draw(spriteBatch);
    }

    @Override
    public void update() {
        if (Controller.right()) {
            moveToNextCard();
        }
        if (Controller.left()) {
            moveToPreviousCard();
        }

        if (Controller.confirm()) {

        }

        statusBar.update();
    }

    private void moveToNextCard() {
        if (position < (cards.size() - 1)) {
            cards.get(position).deselect();
            position++;
            cards.get(position).select();
        }
    }

    private void moveToPreviousCard() {
        if (position > 0) {
            cards.get(position).deselect();
            position--;
            cards.get(position).select();
        }
    }
}
