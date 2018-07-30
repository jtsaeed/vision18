package com.evh98.vision.util;

import com.badlogic.gdx.utils.Timer;
import com.evh98.vision.Vision;

public class BackgroundService {

    private final Vision vision;

    private final int autoLockTimeout = 60;

    public BackgroundService(Vision vision) {
        this.vision = vision;
    }

    public void start() {
        Timer.schedule(autoLockTask, autoLockTimeout);
    }

    public void update() {
        if (Controller.anyKey()) {
            autoLockTask.cancel();
            Timer.schedule(autoLockTask, autoLockTimeout);
        }
    }

    private Timer.Task autoLockTask = new Timer.Task() {
        @Override
        public void run() {
            vision.lock();
        }
    };
}
