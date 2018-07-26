package com.evh98.vision.ui.card;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class CardAction {

    private final String type;
    private final String action;

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

    }

    private void program() {
        try {
            Desktop desktop = Desktop.getDesktop();
            File file = new File(this.action);
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void web() {
        try {
            URI uri = new URI(this.action);
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}