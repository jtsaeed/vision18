package com.evh98.vision.ui;

import com.badlogic.gdx.graphics.Color;

public class Palette {

    public static Color system = Color.valueOf("62C2A1");

    public static Color red = Color.valueOf("D1574A");
    public static Color blue = Color.valueOf("49ACE1");
    public static Color green = Color.valueOf("ACD150");
    public static Color yellow = Color.valueOf("E9BB49");
    public static Color purple = Color.valueOf("5E3F98");
    public static Color pink = Color.valueOf("C9489A");

    public static Color redPastel = Color.valueOf("E6DBDA");
    public static Color bluePastel = Color.valueOf("DAE1E6");
    public static Color greenPastel = Color.valueOf("E2E6DA");
    public static Color yellowPastel = Color.valueOf("E6E2DA");
    public static Color purplePastel = Color.valueOf("DEDAE6");
    public static Color pinkPastel = Color.valueOf("E6DAE1");

    public static Color blackPure = Color.valueOf("000000");
    public static Color black = Color.valueOf("0D0D0D");
    public static Color grayDark = Color.valueOf("595959");
    public static Color gray = Color.valueOf("808080");
    public static Color grayLight = Color.valueOf("A6A6A6");
    public static Color white = Color.valueOf("F2F2F2");
    public static Color whitePure = Color.valueOf("FFFFFF");

    public static Color[] reds = {red, redPastel};
    public static Color[] blues = {blue, bluePastel};
    public static Color[] greens = {green, greenPastel};
    public static Color[] yellows = {yellow, yellowPastel};
    public static Color[] purples = {purple, purplePastel};
    public static Color[] pinks = {pink, pinkPastel};
    public static Color[] grays = {blackPure, black, grayDark, gray, grayLight, white, whitePure};

    public static Color[] colorsFromText(String text) {
        switch (text) {
            case "red":
                return reds;
            case "blue":
                return blues;
            case "green":
                return greens;
            case "yellow":
                return yellows;
            case "purple":
                return purples;
            case "pink":
                return pinks;
            default:
                return grays;
        }
    }
}
