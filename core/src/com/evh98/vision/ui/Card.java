package com.evh98.vision.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evh98.vision.util.Graphics;

public class Card implements Comparable<Card> {

    private final String title;
    private final int fontSize;
    private final BitmapFont font;

    private final Sprite icon;

    private final Color primaryColor;
    private final Color secondaryColor;
    private Color topColor;
    private Color bottomColor;
    private Color iconColor;

    private final int topOffset;
    private final int leftOffset;
    private final int padding;
    private final int cardsInOneView;

    public Card(String title, Icon icon, Color primaryColor, Color secondaryColor) {
        this.title = title;
        this.fontSize = 96;
        this.font = Graphics.createFont(Graphics.systemFont, fontSize, Palette.white);

        this.icon = icon.getLarge();

        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        deselect();

        this.topOffset = 234;
        this.leftOffset = 128;
        this.padding = 192;
        this.cardsInOneView = 3;
    }

    public void draw(SpriteBatch spriteBatch, int index, int position) {
        float x = calculateX(index, position);

        spriteBatch.begin();
            Graphics.drawTintedSprite(spriteBatch, Graphics.cardTopSprite, x, topOffset, topColor);
            Graphics.drawTintedSprite(spriteBatch, Graphics.cardBottomSprite,
                    x, topOffset + Graphics.cardTopSprite.getHeight(), bottomColor);
            Graphics.drawTintedSprite(spriteBatch, icon,
                    x + (Graphics.cardTopSprite.getWidth() / 2) - (icon.getWidth() / 2),
                topOffset + (Graphics.cardTopSprite.getHeight() / 2) - (icon.getHeight() / 2), iconColor);
            Graphics.drawText(spriteBatch, font, title, x + (Graphics.cardBottomSprite.getWidth() / 2),
                    topOffset + Graphics.cardTopSprite.getHeight() + (Graphics.cardBottomSprite.getHeight() / 2));
        spriteBatch.end();
    }

    private float calculateX(int index, int position) {
        return leftOffset
                + ((padding + Graphics.cardTopSprite.getWidth()) * index)
                - ((position / cardsInOneView) * ((Graphics.cardTopSprite.getWidth() + padding) * cardsInOneView));
    }

    public void select() {
        this.topColor = secondaryColor;
        this.bottomColor = primaryColor;
        this.iconColor = primaryColor;
    }

    public void deselect() {
        this.topColor = Palette.grayDark;
        this.bottomColor = Palette.grayLight;
        this.iconColor = Palette.white;
    }

    @Override
    public int compareTo(Card other) {
        return title.compareTo(other.title);
    }
}
