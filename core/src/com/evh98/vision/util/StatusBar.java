package com.evh98.vision.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evh98.vision.util.Graphics;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StatusBar {

    private final BitmapFont font;

    private String time;
    private String date;

    public StatusBar(Color color) {
        this.font = Graphics.createFont(Graphics.systemFont, 128, color);
        getDateAndTime();
    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.begin();
            Graphics.drawLeftAlignedText(spriteBatch, font, time, 128, 1189);
            Graphics.drawRightAlignedText(spriteBatch, font, date, 2560 - 128, 1189);
        spriteBatch.end();
    }

    public void update() {
        getDateAndTime();
    }

    private void getDateAndTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mma");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM");
        this.time = sdf.format(cal.getTime()).toLowerCase();
        if (this.time.toCharArray()[0] == '0') {
            this.time = this.time.substring(1, this.time.length());
        }
        this.date = sdf2.format(cal.getTime());
    }
}
