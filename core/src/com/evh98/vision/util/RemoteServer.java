package com.evh98.vision.util;

import com.evh98.vision.Vision;
import com.evh98.vision.card.Card;
import com.evh98.vision.search.SearchEngine;
import com.evh98.vision.util.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class RemoteServer extends Thread {

    private final Vision vision;

    private final int port = 3000;

    private ServerSocket serverSocket;

    public RemoteServer(Vision vision) {
        this.vision = vision;

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Waiting for client...");
                Socket client = serverSocket.accept();
                System.out.println("Connected to " + client.getRemoteSocketAddress());
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                String input;
                while ((input = in.readLine()) != null) {
                    handleRequest(input);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleRequest(String request) {
        String[] arguments = request.split(" ");

        switch (arguments[0]) {
            case "controller":
                handleControllerRequest(arguments[1]);
                break;
            case "shortcut":
                handleShortcutRequest(arguments[1]);
                break;
            case "search":
                handleSearchRequest(arguments[1]);
                break;
        }
    }

    private void handleShortcutRequest(String argument) {
        SearchEngine searchEngine = new SearchEngine(vision);
        Card card = searchEngine.getSingleResult(argument.toLowerCase());

        if (card != null) {
            card.open();
        }
    }

    private void handleSearchRequest(String argument) {
        Controller.simulateSearch();
    }

    private void handleControllerRequest(String argument) {
        switch (argument) {
            case "up":
                Controller.simulateUp();
                break;
            case "left":
                Controller.simulateLeft();
                break;
            case "right":
                Controller.simulateRight();
                break;
            case "down":
                Controller.simulateDown();
                break;
            case "confirm":
                Controller.simulateConfirm();
                break;
            case "back":
                Controller.simulateBack();
        }
    }
}
