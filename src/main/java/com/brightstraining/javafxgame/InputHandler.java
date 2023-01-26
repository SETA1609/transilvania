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
            model.getPlayer().stopMovingDown();
            model.getPlayer().stopMovingUp();
            model.getPlayer().startMovingLeft();
        }
        else if (keyCode == KeyCode.RIGHT) {
            model.getPlayer().stopMovingDown();
            model.getPlayer().stopMovingUp();
            model.getPlayer().startMovingRight();
        }
        else if(keyCode == KeyCode.UP) {
            model.getPlayer().stopMovingLeft();
            model.getPlayer().stopMovingRight();
            model.getPlayer().startMovingUp();
        }else if(keyCode == KeyCode.DOWN) {
            model.getPlayer().stopMovingLeft();
            model.getPlayer().stopMovingRight();
            model.getPlayer().startMovingDown();
        }
    }

    /*public void onKeyReleased(KeyCode keyCode) {
        if (keyCode == KeyCode.LEFT) {
            model.getPlayer().stopMovingLeft();
        }
        else if (keyCode == KeyCode.RIGHT) {
            model.getPlayer().stopMovingRight();
        }
        else if (keyCode == KeyCode.UP) {
            model.getPlayer().stopMovingUp();
        }
        else if (keyCode == KeyCode.DOWN) {
            model.getPlayer().stopMovingDown();
        }
    }*/

    public void onMouseClicked(double x, double y) {

    }
}
