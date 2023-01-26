package com.brightstraining.javafxgame;

import com.brightstraining.javafxgame.model.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class Graphics {

    private Canvas canvas;

    // Model-coordinates are the same as screen coordinates.
    // For games with less granular coordinates (chess, game of life)
    // this should not be the case.
    public static final double SCALING = 1d;
    public static final double HEIGHT = Model.HEIGHT * SCALING;
    public static final double WIDTH = Model.WIDTH * SCALING;

    public Graphics(Canvas canvas) {
        this.canvas = canvas;
    }

    public void draw(Model model) {

        GraphicsContext context = canvas.getGraphicsContext2D();

        for (int i = 0; i < Model.ROWS; i++) {
            for (int j = 0; j < Model.COLUMNS; j++) {
                if ((i + j) % 2 == 0) {
                    context.setFill(Color.web("AAD751"));
                } else {
                    context.setFill(Color.web("A2D149"));
                }
                context.fillRect(i * Model.SQUSIZE, j * Model.SQUSIZE, Model.SQUSIZE, Model.SQUSIZE);
            }
        }

        //draw ScoreBoard
        ScoreBoard scoreBoard = model.getScoreBoard();
        context.setFill(Color.BLACK); //color
        context.setFont(Font.font(25)); // Font und Große
        context.strokeText(scoreBoard.toString(), 20, 20); // Wo wird gestellt und String

        //draw food
        Food food = model.getFood();
        context.drawImage(Food.icon, food.getX(), food.getY());

        //draw poisons
        List<Poison> poisons = model.getPoisons();
        context.setFill(Color.BLACK);
        if (ScoreBoard.score > 0) {
            for (Poison poison : poisons) {
                context.drawImage(Poison.icon, poison.getX(), poison.getY());
            }
        }

        // draw player
        Player player = model.getPlayer();
        context.drawImage(Player.icon, player.getX(), player.getY());
    }
}
