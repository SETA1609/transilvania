package com.brightstraining.javafxgame;

import com.brightstraining.javafxgame.model.Model;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.Media;

public class Game extends Application {
public boolean isRunning;
    @Override
    public void start(Stage stage) {



        // Model contains the state of our game
        Model model = new Model();
        stage.setTitle("Mein Spiel");
        stage.setResizable(false);



        // Create group and scene (Window content)
        Group root = new Group();
        Scene scene = new Scene(root);
        // StarScreen scene
        Group start= new Group ();
        Scene starScreen = new Scene (start,Model.HEIGHT, Model.WIDTH);
        //GameOver Scene
        Group gameOver= new Group ();
        Scene gameOverScreen = new Scene (gameOver,Model.HEIGHT, Model.WIDTH);
        //Titel
        Text titel=new Text ();
        titel.setFont (Font.font ("Blackadder ITC"));
        titel.setFill (Color.RED);
        titel.setText ("TRANCYVANIA");
        titel.setX (200);
        titel.setY (200);
        //titel.setsti
        start.getChildren ().add (titel);
        //Buttons from Startscreen
        Button play=new Button ();
        play.setLayoutX (150);
        play.setLayoutY (300);
        play.setText ("Play");
        play.setOnAction (e->stage.setScene (scene));
        Button exit=new Button ();
        exit.setLayoutX (300);
        exit.setLayoutY (300);
        exit.setText ("Exit");
        exit.setOnAction (e->stage.setScene (gameOverScreen));
        start.getChildren ().add (play);
        start.getChildren ().add (exit);

        //gameOverScreen

        // Create canvas and add to group
        Canvas canvas = new Canvas(Graphics.HEIGHT, Graphics.WIDTH);
        root.getChildren().addAll(canvas);
        stage.setScene(starScreen);
        stage.sizeToScene();

        InputHandler inputHandler = new InputHandler(model);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {
                inputHandler.onKeyPressed(keyEvent.getCode());
            }
        });
        /*scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                inputHandler.onKeyReleased(keyEvent.getCode());
            }
        });*/
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                inputHandler.onMouseClicked(mouseEvent.getX(), mouseEvent.getY());
            }
        });

        Graphics graphics = new Graphics(canvas);

        Timer timer = new Timer(model, graphics);
        timer.start();

        stage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
