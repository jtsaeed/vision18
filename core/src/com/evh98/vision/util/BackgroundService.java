package com.evh98.vision.util;

import com.badlogic.gdx.utils.Timer;
import com.evh98.vision.Vision;

public class BackgroundService {

    private final Vision vision;
    private final RemoteServer remoteServer;

    private final int autoLockTimeout = 60;

    public BackgroundService(Vision vision) {
        this.vision = vision;
        this.remoteServer = new RemoteServer(vision);
    }

    public void start() {
        remoteServer.start();
        Timer.schedule(autoLockTask, autoLockTimeout);
        Timer.schedule(updateTimeAndDateTask, 0, 1);
    }

    public void stop() {
        autoLockTask.cancel();
        updateTimeAndDateTask.cancel();
        remoteServer.interrupt();
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

    private Timer.Task updateTimeAndDateTask = new Timer.Task() {
        @Override
        public void run() {
            Util.updateTimeAndDate();
        }
    };
}
