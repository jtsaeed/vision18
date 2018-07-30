package com.evh98.vision.util;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Icon {

    public static Icon browser;
    public static Icon cinema;
    public static Icon code;
    public static Icon game;
    public static Icon movie;
    public static Icon plane;
    public static Icon power;
    public static Icon settings;
    public static Icon store;
    public static Icon train;

    public static void loadAll() {
        browser = new Icon("browser");
        cinema = new Icon("cinema");
        code = new Icon("code");
        game = new Icon("game");
        movie = new Icon("movie");
        plane = new Icon("plane");
        power = new Icon("power");
        settings = new Icon("settings");
        store = new Icon("store");
        train = new Icon("train");
    }

    private final Sprite icon256;
    private final Sprite icon96;

    public Icon(String name) {
        this.icon256 = Graphics.createSprite("icons/" + name + "/256.png");
        this.icon96 = Graphics.createSprite("icons/" + name + "/256.png");
    }

    public Sprite getLarge() {
        return icon256;
    }

    public Sprite getSmall() {
        return icon96;
    }
}
