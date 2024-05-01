package com.example.flappybirdd;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class ControllerStartGame {
    @FXML
    private ImageView BirdImg;
    @FXML
    private Pane gamePane;
    @FXML
    private Pane gameOver;
    @FXML
    private Button quit;
    @FXML
    private Button replay;
    private ImageView pipeTop;
    private ImageView pipeBottom;
    private double initial_velocity = 0;
    private static final double gravity = 0.4;
    private static final double jump_v = -6;
    private static final int pipe_with = 100;
    private static final double pipe_gap = 150;
    private static final double pipe_v = 2;
    private ArrayList<ImageView> pipes = new ArrayList<>();

    @FXML
    public void initialize(){
        gamePane.setFocusTraversable(true);
        gamePane.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE){
                initial_velocity = jump_v;
                this.spawnPipe();
                this.jumpV();
            }
        });
        quit.setOnAction(this::quit);
        replay.setOnAction(this::replay);

    }
    public void jumpV(){
        gamePane.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE){
                initial_velocity = jump_v;
            }
        });
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (!pipes.isEmpty() && (pipes.get(pipes.size() - 1).getTranslateX() < -250)) {
                    spawnPipe();
                }
                movePipe();
                initial_velocity += gravity;
                BirdImg.setLayoutY(BirdImg.getLayoutY()+initial_velocity);

                if (BirdImg.getLayoutY() > gamePane.getHeight() || BirdImg.getLayoutY() < 0 || checkCollision() )
                {
                    this.stop();
                    gameOver.setVisible(true);
                }
            }
        };
        timer.start();
        gamePane.requestFocus();
    }
    public void spawnPipe(){
        double heightTop = 60 + Math.random() * (gamePane.getHeight() - pipe_gap - 100);

        pipeTop = new ImageView("C:\\Users\\ADMIN\\IdeaProjects\\FlappyBirdd\\src\\main\\resources\\com\\example\\flappybirdd\\image\\PipeTop.png");
        pipeTop.setFitWidth(pipe_with);
        pipeTop.setFitHeight(heightTop);
        pipeTop.setLayoutY(0);
        pipeTop.setLayoutX(700);

        pipeBottom = new ImageView("C:\\Users\\ADMIN\\IdeaProjects\\FlappyBirdd\\src\\main\\resources\\com\\example\\flappybirdd\\image\\PipeBottom.png");
        pipeBottom.setFitWidth(pipe_with);
        pipeBottom.setFitHeight(gamePane.getHeight() - heightTop - pipe_gap);
        pipeBottom.setLayoutY(heightTop + pipe_gap);
        pipeBottom.setLayoutX(700);

        gamePane.getChildren().addAll(pipeTop, pipeBottom);
        pipes.add(pipeTop);
        pipes.add(pipeBottom);
    }
    public void movePipe(){
        ArrayList<ImageView> pipesToRemove = new ArrayList<>();
        for (ImageView pipe : pipes){
            pipe.setTranslateX(pipe.getTranslateX() - pipe_v);
            if (pipe.getTranslateX() < -900){
                pipesToRemove.add(pipe);
            }
        }
        gamePane.getChildren().removeAll(pipesToRemove);
        pipes.removeAll(pipesToRemove);
    }
    public boolean checkCollision() {
        Bounds birdBounds = BirdImg.getBoundsInParent();
        double shrinkFactor = 10;
        Bounds smallerBirdBounds = new BoundingBox(
                birdBounds.getMinX() + shrinkFactor,
                birdBounds.getMinY() + shrinkFactor,
                birdBounds.getWidth() - 2 * shrinkFactor,
                birdBounds.getHeight() - 2 * shrinkFactor
        );
        double pipeShrink = 10;
        for (ImageView pipe : pipes) {
            Bounds pipeBounds = pipe.getBoundsInParent();
            Bounds smallerPipeBounds = new BoundingBox(
                    pipeBounds.getMinX() + pipeShrink,
                    pipeBounds.getMinY() + pipeShrink,
                    pipeBounds.getWidth() - 2 * pipeShrink,
                    pipeBounds.getHeight() - 2 * pipeShrink
            );
            if (smallerBirdBounds.intersects(smallerPipeBounds)) {
                return true;
            }
        }
        return false;
    }
    public void quit(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ControllerLogin.class.getResource("ViewLoppy.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(root);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void replay(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ControllerLogin.class.getResource("ViewStartGame.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(root);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
