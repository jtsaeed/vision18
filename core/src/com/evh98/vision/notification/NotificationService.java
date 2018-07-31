package com.evh98.vision.notification;

import com.badlogic.gdx.utils.Timer;
import com.evh98.vision.Vision;

public class NotificationService {

    private final Vision vision;

    private final int refreshRate = 60;

    public NotificationService(Vision vision) {
        this.vision = vision;
    }

    public void start() {
        Timer.schedule(pullNotificationsTask, 0, refreshRate);
    }

    public void stop() {
        pullNotificationsTask.cancel();
    }

    private Timer.Task pullNotificationsTask = new Timer.Task() {
        @Override
        public void run() {

        }
    };
}
