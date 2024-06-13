package controller.flappybirdd;

import ObjectGson.GsonForClient.CL_CheckLogin;
import ObjectGson.GsonForServer.SV_Score;
import RequestToServer.PostData.RequestUpdateScore;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class ControllerStartGame {
    @FXML
    private ImageView BirdImg;
    @FXML
    private ImageView imgBackground;
    @FXML
    private Pane gamePane;
    @FXML
    private Pane gameOver;
    @FXML
    private Button quit;
    @FXML
    private Button replay;
    @FXML
    private Label textLabel;
    private ImageView pipeTop;
    private ImageView pipeBottom;
    private int point = 0;
    private double initial_velocity = 0;
    private static final double gravity = 0.4;
    private static final double jump_v = -6;
    private static final int pipe_with = 100;
    private static final double pipe_gap = 150;
    private static final double pipe_v = 3;
    private ArrayList<ImageView> pipes = new ArrayList<>();
    private ArrayList<ImageView> points = new ArrayList<>();
    private CL_CheckLogin cl_checkLogin = ControllerLoppy.cl_checkLogin;

    @FXML
    public void initialize(){
        randomBack();
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
    public void updateScore(){
        SV_Score sv_score = new SV_Score();
        sv_score.setUserId(cl_checkLogin.getIdUser());
        sv_score.setScore(textLabel.getText());
        RequestUpdateScore.updateScore(sv_score);
    }
    public void getSkin(){

    }
    public void randomBack(){
        int ran = (int)(Math.random() * 4) + 1;
        if (ran == 1){
            Image image = new Image(getClass().getResource("/image/bg1.jpg").toExternalForm());
            imgBackground.setImage(image);
        } else if (ran == 2){
            Image image = new Image(getClass().getResource("/image/back2.png").toExternalForm());
            imgBackground.setImage(image);
        } else if (ran == 3) {
            Image image = new Image(getClass().getResource("/image/background3.jpg").toExternalForm());
            imgBackground.setImage(image);
        } else {
            Image image = new Image(getClass().getResource("/image/background4.png").toExternalForm());
            imgBackground.setImage(image);
        }
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
                score();
                initial_velocity += gravity;
                BirdImg.setLayoutY(BirdImg.getLayoutY()+initial_velocity);

                if (BirdImg.getLayoutY() > gamePane.getHeight() || BirdImg.getLayoutY() < 0 || checkCollision() )
                {
                    this.stop();
                    gameOver.setVisible(true);
                    updateScore();
                }
            }
        };
        timer.start();
        gamePane.requestFocus();
    }
    public void spawnPipe(){
        double heightTop = 60 + Math.random() * (gamePane.getHeight() - pipe_gap - 100);

        pipeTop = new ImageView(new Image(getClass().getResource("/image/PipeSkin3Top.png").toExternalForm()));
        pipeTop.setFitWidth(pipe_with);
        pipeTop.setFitHeight(heightTop);
        pipeTop.setLayoutY(0);
        pipeTop.setLayoutX(700);

        pipeBottom = new ImageView(new Image(getClass().getResource("/image/PipeSkin3Bottom.png").toExternalForm()));
        pipeBottom.setFitWidth(pipe_with);
        pipeBottom.setFitHeight(gamePane.getHeight() - heightTop - pipe_gap);
        pipeBottom.setLayoutY(heightTop + pipe_gap);
        pipeBottom.setLayoutX(700);

        gamePane.getChildren().addAll(pipeTop, pipeBottom);
        pipes.add(pipeTop);
        pipes.add(pipeBottom);
        points.add(pipeTop);
    }
    public void movePipe(){
        ArrayList<ImageView> pipesToRemove = new ArrayList<>();
        for (ImageView pipe : pipes){
            pipe.setTranslateX(pipe.getTranslateX() - pipe_v);
            if (pipe.getTranslateX() < -800){
                pipesToRemove.add(pipe);
            }
        }
        gamePane.getChildren().removeAll(pipesToRemove);
        pipes.removeAll(pipesToRemove);
    }
    public void score(){
        ArrayList<ImageView> pipesToRemove = new ArrayList<>();
        for (ImageView Point : points){
            if (Point.getTranslateX() < -650){
                point++;
                String temp = Integer.toString(point);
                textLabel.setText(temp);
                pipesToRemove.add(Point);
            }
        }
        points.removeAll(pipesToRemove);
    }
    public boolean checkCollision() {
        Bounds birdBounds = BirdImg.getBoundsInParent();
        double shrinkFactor = 7;
        Bounds smallerBirdBounds = new BoundingBox(
                birdBounds.getMinX() + shrinkFactor,
                birdBounds.getMinY() + shrinkFactor,
                birdBounds.getWidth() - 2 * shrinkFactor,
                birdBounds.getHeight() - 2 * shrinkFactor
        );
        double pipeShrink = 7;
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
            FXMLLoader fxmlLoader = new FXMLLoader(ControllerStartGame.class.getResource("ViewLoppy.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(root);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void replay(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ControllerStartGame.class.getResource("ViewStartGame.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(root);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
