package controller.flappybirdd;

import javafx.animation.AnimationTimer;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class ControllerLoppy {
    @FXML
    private Button playButton;
    @FXML
    private Button rankButton;
    @FXML
    private Button skinButton;
    @FXML
    private Button settingButton;
    @FXML
    private Button chatButton;
    @FXML
    private Pane introPane;

    @FXML
    public void initialize(){
        zoomIntroPane();
        scaleButton(playButton);
        scaleButton(rankButton);
        scaleButton(skinButton);
        scaleButton(settingButton);
        scaleButton(chatButton);
        playButton.setOnAction(this::playGame);
    }
    public void playGame(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ControllerStartGame.class.getResource("ViewStartGame.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(root);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void changeSkin(){

    }
    public void viewRank(){

    }
    public void chatGloble(){

    }
    public void setting(){

    }
    public void zoomIntroPane(){
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1),introPane);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.15);
        scaleTransition.setToY(1.15);
        scaleTransition.setCycleCount(ScaleTransition.INDEFINITE);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
    }
    public void scaleButton(Button button) {
        ScaleTransition scaleUp = new ScaleTransition(Duration.millis(200), button);
        scaleUp.setToX(1.1);
        scaleUp.setToY(1.1);

        ScaleTransition scaleDown = new ScaleTransition(Duration.millis(200), button);
        scaleDown.setToX(1.0);
        scaleDown.setToY(1.0);

        button.setOnMouseEntered(event -> {
            scaleDown.stop();
            scaleUp.playFromStart();
        });

        button.setOnMouseExited(event -> {
            scaleUp.stop();
            scaleDown.playFromStart();
        });
    }

}