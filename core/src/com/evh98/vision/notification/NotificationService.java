package com.evh98.vision.notification;

import com.badlogic.gdx.utils.Timer;
import com.evh98.vision.Vision;

public class NotificationService {

    private final int refreshRate = 60;

    public NotificationService(Vision vision) {

    }

    public void start() {

    }

    private Timer.Task pullNotificationsTask = new Timer.Task() {
        @Override
        public void run() {

        }
    };
}
