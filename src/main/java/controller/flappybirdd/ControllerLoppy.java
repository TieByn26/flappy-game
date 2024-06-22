package controller.flappybirdd;

import ObjectGson.GsonForClient.CL_CheckLogin;
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

import java.io.IOException;

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
    private Pane mainPane;
    @FXML
    private Pane chatPane;
    public static CL_CheckLogin cl_checkLogin = ControllerLogin.cl_checkLogin;

    public static void kk(){
        System.out.println(cl_checkLogin);
    }

    @FXML
    public void initialize(){
        zoomIntroPane();
        scaleButton(playButton);
        scaleButton(rankButton);
        scaleButton(skinButton);
        scaleButton(settingButton);
        scaleButton(chatButton);
        playButton.setOnAction(this::playGame);
        chatButton.setOnAction(event -> chatGlobal());
        skinButton.setOnAction(event -> changeSkin());
        rankButton.setOnAction(event -> viewRank());
        settingButton.setOnAction(event -> setting());
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
    public void chatGlobal(){
        try {
            Pane chat = FXMLLoader.load(getClass().getResource("ViewChat.fxml"));
            mainPane.getChildren().add(chat);;
        } catch (Exception e){
            e.printStackTrace();
        }
        chatPane.setVisible(false);
    }
    public void changeSkin() {
        try {
            Pane skinPane = FXMLLoader.load(getClass().getResource("ViewSkin.fxml"));
            mainPane.getChildren().add(skinPane);
        }catch (Exception e){
            e.printStackTrace();
        }
        chatPane.setVisible(false);
    }
    public void viewRank(){
        try {
            Pane rankPane = FXMLLoader.load(getClass().getResource("ViewRank.fxml"));
            mainPane.getChildren().add(rankPane);
        } catch (Exception e){
            e.printStackTrace();
        }
        chatPane.setVisible(false);
    }
    public void setting(){
        try {
            Pane settingPane = FXMLLoader.load(getClass().getResource("ViewSetting.fxml"));
            mainPane.getChildren().add(settingPane);
        } catch (Exception e){
            e.printStackTrace();
        }
        chatPane.setVisible(false);
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
    public static void scaleButton(Button button) {
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