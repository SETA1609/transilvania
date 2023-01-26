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
    private static final String [] POISON_IMAGES = {"/img/ic_poison.png","/img/ic_ghost.png"};


    public Graphics(Canvas canvas) {
        this.canvas = canvas;
    }

    public void draw(Model model) {

        GraphicsContext context = canvas.getGraphicsContext2D();
        /**
         // draw sky
         context.setFill(Color.LIGHTBLUE);
         context.fillRect(0, 0, Graphics.WIDTH, Graphics.HEIGHT);
         */

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
        context.setFill(Color.RED);
        context.fillOval(food.getX() - Food.WIDTH * SCALING / 2,
                food.getY() - Food.HEIGHT * SCALING / 2, Food.WIDTH, Food.HEIGHT);

        //draw poisons
        List<Poison> poisons = model.getPoisons();
        context.setFill(Color.BLACK);
        if (ScoreBoard.score > 0) {
            for (Poison poison : poisons) {
                Image image = new Image(getClass().getResource("/img/bomb.png").toExternalForm());
                ImageView imageView = new ImageView(image);
                // :)
                context.drawImage(image, poison.getX(), poison.getY());
                //context.fillOval(poison.getX() - poison.WIDTH * SCALING / 2, poison.getY() - poison.HEIGHT * SCALING / 2, poison.WIDTH, poison.HEIGHT);
            }
        }

        // draw player
        Player player = model.getPlayer();
        context.setFill(Color.BLUEVIOLET);
        context.fillOval(player.getX() - Player.WIDTH * SCALING / 2,
                player.getY() - Player.HEIGHT * SCALING / 2, Player.WIDTH, Player.HEIGHT);
        //context.fillPolygon(new double[] {player.getX() - Player.WIDTH * SCALING / 2}, new double[]{player.getY() -Player.HEIGHT * SCALING / 2}, (int) Player.WIDTH);

        /*context.fillOval(
                player.getX() - Player.WIDTH * SCALING / 2,
                player.getY() - Player.HEIGHT * SCALING / 2,
                Player.WIDTH,
                Player.HEIGHT
        );*/
    }
}