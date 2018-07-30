package com.evh98.vision.util;

import com.evh98.vision.util.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class RemoteServer extends Thread {

    private final int port = 3000;

    private ServerSocket serverSocket;

    public RemoteServer() {
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
        switch (request) {
            case "controller up":
                Controller.simulateUp();
                break;
            case "controller left":
                Controller.simulateLeft();
                break;
            case "controller right":
                Controller.simulateRight();
                break;
            case "controller down":
                Controller.simulateDown();
                break;
            case "controller confirm":
                Controller.simulateConfirm();
                break;
            case "controller back":
                Controller.simulateBack();
        }
    }

}
