package com.evh98.vision.card;

import com.evh98.vision.Vision;
import com.evh98.vision.screen.VisionScreen;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class CardAction {

    private final String type;
    private final Object action;
    private Vision vision;

    public CardAction(String type, Object action, Vision vision) {
        this.type = type;
        this.action = action;
        this.vision = vision;
    }

    public CardAction(String type, String action) {
        this.type = type;
        this.action = action;
    }

    public void perform() {
        switch (type) {
            case "app":
                app();
                break;
            case "program":
                program();
                break;
            case "web":
                web();
                break;
        }
    }

    private void app() {
        vision.setScreen((VisionScreen) action);
    }

    private void program() {
        try {
            Desktop desktop = Desktop.getDesktop();
            File file = new File((String) action);
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void web() {
        try {
            URI uri = new URI((String) action);
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}