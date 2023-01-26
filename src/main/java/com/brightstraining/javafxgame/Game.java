package com.brightstraining.javafxgame;

import com.brightstraining.javafxgame.model.Model;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static com.brightstraining.javafxgame.Music.backGroundMusic;
import static com.brightstraining.javafxgame.Music.gameOverSound;

public class Game extends Application {

    @Override
    public void start(Stage stage) {
        //Background Music
        backGroundMusic(MusicFlag.ON);



        // Model contains the state of our game
        Model model = new Model();
        stage.setTitle("Mein Spiel");
        stage.setResizable(false);



        // Create group and scene (Window content)
        Group root = new Group();
        Scene scene = new Scene(root);



        // Create canvas and add to group
        Canvas canvas = new Canvas(Graphics.WIDTH,Graphics.HEIGHT);
        root.getChildren().addAll(canvas);
        stage.setScene(scene);
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
