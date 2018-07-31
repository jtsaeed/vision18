package com.evh98.vision.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Controller {

    public static boolean up() {
        return (Gdx.input.isKeyJustPressed(Input.Keys.UP) || Gdx.input.isKeyJustPressed(Input.Keys.W));
    }

    public static boolean left() {
        return (Gdx.input.isKeyJustPressed(Input.Keys.LEFT) || Gdx.input.isKeyJustPressed(Input.Keys.A));
    }

    public static boolean down() {
        return (Gdx.input.isKeyJustPressed(Input.Keys.DOWN) || Gdx.input.isKeyJustPressed(Input.Keys.S));
    }

    public static boolean right() {
        return (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) || Gdx.input.isKeyJustPressed(Input.Keys.D));
    }

    public static boolean confirm() {
        return (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.isKeyJustPressed(Input.Keys.ENTER));
    }

    public static boolean back() {
        return (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE));
    }

    public static boolean search() {
        return (Gdx.input.isKeyJustPressed(Input.Keys.TAB));
    }

    public static boolean anyKey() {
        return (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY));
    }

    public static boolean terminate() {
        return (Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE));
    }

    public static void simulateUp() {
        simulateKey(KeyEvent.VK_W);
    }

    public static void simulateLeft() {
        simulateKey(KeyEvent.VK_A);
    }

    public static void simulateDown() {
        simulateKey(KeyEvent.VK_S);
    }

    public static void simulateRight() {
        simulateKey(KeyEvent.VK_D);
    }

    public static void simulateConfirm() {
        simulateKey(KeyEvent.VK_ENTER);
    }

    public static void simulateBack() {
        simulateKey(KeyEvent.VK_ESCAPE);
    }

    public static void simulateSearch() {
        simulateKey(KeyEvent.VK_TAB);
    }

    private static void simulateKey(int key) {
        try {
            Robot robot = new Robot();
            // Simulate a key press
            robot.keyPress(key);
            robot.keyRelease(key);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /*
     * Checks what letter character is entered
     */
    public static String textInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            return "a";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.B)) {
            return "b";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.C)) {
            return "c";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
            return "d";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
            return "e";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.F)) {
            return "f";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.G)) {
            return "g";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.H)) {
            return "h";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.I)) {
            return "i";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.J)) {
            return "j";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.K)) {
            return "k";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.L)) {
            return "l";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
            return "m";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.N)) {
            return "n";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.O)) {
            return "o";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            return "p";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            return "q";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            return "r";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            return "s";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.T)) {
            return "t";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.U)) {
            return "u";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.V)) {
            return "v";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            return "w";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.X)) {
            return "x";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.Y)) {
            return "y";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.Z)) {
            return "z";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            return " ";
        } else {
            return "";
        }
    }

    public static boolean textInputBackspace() {
        return Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE);
    }

    public static boolean textInputConfirm() {
        return Gdx.input.isKeyJustPressed(Input.Keys.ENTER);
    }
}
