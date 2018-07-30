package com.evh98.vision.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evh98.vision.util.Graphics;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StatusBar {

    private final BitmapFont font;

    public StatusBar(Color color) {
        this.font = Graphics.createFont(Graphics.systemFont, 128, color);
        Util.updateTimeAndDate();
    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.begin();
            Graphics.drawLeftAlignedText(spriteBatch, font, Util.time, 128, 1189);
            Graphics.drawRightAlignedText(spriteBatch, font, Util.date, 2560 - 128, 1189);
        spriteBatch.end();
    }
}
