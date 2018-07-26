package com.evh98.vision.ui.card;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evh98.vision.util.Controller;

import java.util.ArrayList;
import java.util.Collections;

public class CardsManager {

    private ArrayList<Card> cards;
    private int position = 0;

    public CardsManager(ArrayList<Card> cards) {
        this.cards = cards;
        Collections.sort(this.cards);

        this.cards.get(this.position).select();
    }

    public CardsManager(Card...cards) {
        this.cards = new ArrayList<Card>();
        for (Card card : cards) {
            this.cards.add(card);
        }
        Collections.sort(this.cards);

        this.cards.get(this.position).select();
    }

    public void draw(SpriteBatch spriteBatch) {
        for (int i = 0; i < cards.size(); i++) {
            this.cards.get(i).draw(spriteBatch, i, position);
        }
    }

    public void update() {
        if (Controller.right()) {
            moveToNextCard();
        }
        if (Controller.left()) {
            moveToPreviousCard();
        }

        if (Controller.confirm()) {
            open();
        }
    }

    public void addCard(Card card) {
        this.cards.add(card);
        Collections.sort(this.cards);
    }

    private void moveToNextCard() {
        if (position < (cards.size() - 1)) {
            this.cards.get(this.position).deselect();
            this.position++;
            this.cards.get(this.position).select();
        }
    }

    private void moveToPreviousCard() {
        if (position > 0) {
            this.cards.get(this.position).deselect();
            position--;
            this.cards.get(this.position).select();
        }
    }

    private void open() {
        this.cards.get(this.position).open();
    }
}
