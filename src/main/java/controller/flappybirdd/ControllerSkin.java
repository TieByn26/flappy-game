package controller.flappybirdd;

import ObjectGson.GsonForServer.SV_SkinOfUser;
import RequestToServer.PostData.RequestUpdateSkin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class ControllerSkin {
    @FXML
    private Button exitButton;
    @FXML
    private Button bird1Button;
    @FXML
    private Button bird2Button;
    @FXML
    private Button bird3Button;
    @FXML
    private Button pipe1Button;
    @FXML
    private Button pipe2Button;
    @FXML
    private Button pipe3Button;
    private SV_SkinOfUser sv_skinOfUser;
    @FXML
    public void initialize(){
        ControllerLoppy.scaleButton(exitButton);
        ControllerLoppy.scaleButton(bird1Button);
        ControllerLoppy.scaleButton(bird2Button);
        ControllerLoppy.scaleButton(bird3Button);
        ControllerLoppy.scaleButton(pipe1Button);
        ControllerLoppy.scaleButton(pipe2Button);
        ControllerLoppy.scaleButton(pipe3Button);
        exitButton.setOnAction(this::closeSkin);
        bird1Button.setOnAction(this::changeSkinBird);
        bird2Button.setOnAction(this::changeSkinBird);
        bird3Button.setOnAction(this::changeSkinBird);
        pipe1Button.setOnAction(this::changeSkinPipe);
        pipe2Button.setOnAction(this::changeSkinPipe);
        pipe3Button.setOnAction(this::changeSkinPipe);
    }
    public void closeSkin(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ControllerStartGame.class.getResource("ViewLoppy.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(root);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void changeSkinBird(ActionEvent event){
        Button src = (Button) event.getSource();
        if (src == bird1Button){
            sv_skinOfUser = new SV_SkinOfUser();
            sv_skinOfUser.setUserId(ControllerLoppy.cl_checkLogin.getIdUser());
            sv_skinOfUser.setBirdSkin("1");
            RequestUpdateSkin.updateSkin(sv_skinOfUser);
        } else if (src == bird2Button){
            sv_skinOfUser = new SV_SkinOfUser();
            sv_skinOfUser.setUserId(ControllerLoppy.cl_checkLogin.getIdUser());
            sv_skinOfUser.setBirdSkin("2");
            RequestUpdateSkin.updateSkin(sv_skinOfUser);
        } else {
            sv_skinOfUser = new SV_SkinOfUser();
            sv_skinOfUser.setUserId(ControllerLoppy.cl_checkLogin.getIdUser());
            sv_skinOfUser.setBirdSkin("3");
            RequestUpdateSkin.updateSkin(sv_skinOfUser);
        }
    }
    public void changeSkinPipe(ActionEvent event){
        Button src = (Button) event.getSource();
        if (src == pipe1Button){
            sv_skinOfUser = new SV_SkinOfUser();
            sv_skinOfUser.setUserId(ControllerLoppy.cl_checkLogin.getIdUser());
            sv_skinOfUser.setPipeSkin("4");
            RequestUpdateSkin.updateSkin(sv_skinOfUser);
        } else if (src == pipe2Button){
            sv_skinOfUser = new SV_SkinOfUser();
            sv_skinOfUser.setUserId(ControllerLoppy.cl_checkLogin.getIdUser());
            sv_skinOfUser.setPipeSkin("6");
            RequestUpdateSkin.updateSkin(sv_skinOfUser);
        } else {
            sv_skinOfUser = new SV_SkinOfUser();
            sv_skinOfUser.setUserId(ControllerLoppy.cl_checkLogin.getIdUser());
            sv_skinOfUser.setPipeSkin("5");
            RequestUpdateSkin.updateSkin(sv_skinOfUser);
        }
    }
}
