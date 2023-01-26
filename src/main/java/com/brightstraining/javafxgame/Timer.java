package com.brightstraining.javafxgame;

import com.brightstraining.javafxgame.model.Model;
import javafx.animation.AnimationTimer;

public class Timer extends AnimationTimer {

    private long timestamp;
    private Model model;
    private Graphics graphics;

    public Timer(Model model, Graphics graphics) {
        this.graphics = graphics;
        this.model = model;
        this.timestamp = -1;
    }

    @Override
    public void handle(long l) {
        if (timestamp == -1) {
            // this is the first tick of the timer
            // save the current timestamp and wait for next tick
            timestamp = l;
        }
        else {
            // not the first tick. we know how much time has passed
            // and can update the model accordingly.
            // Model expects milliseconds, timestamp is nanoseconds
            model.update((l - timestamp) / 1000);
            timestamp = l;
        }

        graphics.draw(model);
    }
}
