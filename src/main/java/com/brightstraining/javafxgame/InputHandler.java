package com.brightstraining.javafxgame;

import com.brightstraining.javafxgame.model.Model;
import javafx.scene.input.KeyCode;

public class InputHandler {

    private Model model;

    public InputHandler(Model model) {
        this.model = model;
    }

    public void onKeyPressed(KeyCode keyCode) {
        if (keyCode == KeyCode.LEFT) {
            model.getPlayer().startMovingLeft();
        }
        else if (keyCode == KeyCode.RIGHT) {
            model.getPlayer().startMovingRight();
        }
        else if(keyCode == KeyCode.SPACE) {
            model.getPlayer().jump();
        }
    }

    public void onKeyReleased(KeyCode keyCode) {
        if (keyCode == KeyCode.LEFT) {
            model.getPlayer().stopMovingLeft();
        }
        else if (keyCode == KeyCode.RIGHT) {
            model.getPlayer().stopMovingRight();
        }
    }

    public void onMouseClicked(double x, double y) {

    }
}
