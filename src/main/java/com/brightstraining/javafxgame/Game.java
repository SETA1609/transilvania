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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.brightstraining.javafxgame.Music.*;

public class Game extends Application {
public boolean isRunning;
    @Override
    public void start(Stage stage) {
        //Background Music
        backGroundMusic(MusicFlag.ON);



        // Model contains the state of our game
        Model model = new Model();
        stage.setTitle("TRANCYVANIA");
        stage.setResizable(false);



        // Create group and scene (Window content)
        Group root = new Group();
        Scene scene = new Scene(root);

        // StartScreen scene
        Group start= new Group ();
        Scene starScreen = new Scene (start, Model.WIDTH,Model.HEIGHT);

        //GameOver Scene
        Group gameOver= new Group ();
        Scene gameOverScreen = new Scene (gameOver, Model.WIDTH,Model.HEIGHT);

        //Titel
        Text titel=new Text ();
        titel.setFont (Font.font ("Blackadder ITC"));
        titel.setFill (Color.RED);
        titel.setText ("TRANCYVANIA");
        titel.setX (Model.WIDTH/2-50);
        titel.setY (Model.HEIGHT/2-50);
        titel.setScaleX(4);
        titel.setScaleY(4);
        start.getChildren ().add (titel);

        //Buttons from Startscreen
        Button play=new Button ();
        play.setLayoutX (Model.WIDTH/2-120);
        play.setLayoutY (Model.HEIGHT/2+50);
        play.setText ("Play");
        play.setOnAction (e->stage.setScene (scene));
        Button exit=new Button ();
        exit.setLayoutX (Model.WIDTH/2+120);
        exit.setLayoutY (Model.HEIGHT/2+50);
        exit.setText ("Exit");
        exit.setOnAction (e ->stage.close ());

        start.getChildren ().add (play);
        start.getChildren ().add (exit);

        //gameOverScreen
        Text gameVerloren=new Text ();
        gameVerloren.setFont (Font.font ("Blackadder ITC"));
        gameVerloren.setFill (Color.RED);
        gameVerloren.setText ("Game Over \n Where did you learn to fly?");
        gameVerloren.setX (Model.WIDTH/2-50);
        gameVerloren.setY (Model.HEIGHT/2-50);
        gameVerloren.setScaleX(4);
        gameVerloren.setScaleY(4);
        gameOver.getChildren ().add (gameVerloren);
        Button retry=new Button ();
        retry.setLayoutX (Model.WIDTH/2-120);
        retry.setLayoutY (Model.HEIGHT/2+50);
        retry.setText ("Retry");
        retry.setOnAction (e->stage.setScene (scene));
        Button exit2=new Button ();
        exit2.setLayoutX (Model.WIDTH/2+120);
        exit2.setLayoutY (Model.HEIGHT/2+50);
        exit2.setText ("Exit");
        exit2.setOnAction (e ->stage.close ());
        gameOver.getChildren ().add (retry);
        gameOver.getChildren ().add (exit2);

        // Create canvas and add to group
        Canvas canvas = new Canvas(Graphics.WIDTH,Graphics.HEIGHT);
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
