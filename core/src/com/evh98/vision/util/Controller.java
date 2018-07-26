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
}
