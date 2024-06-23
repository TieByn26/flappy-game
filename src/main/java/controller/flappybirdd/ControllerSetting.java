package controller.flappybirdd;

import ObjectGson.GsonForClient.CL_IdUser;
import ObjectGson.GsonForServer.SV_Level;
import ObjectGson.GsonForServer.SV_Sound;
import RequestToServer.GetData.GetLevel;
import RequestToServer.GetData.GetSound;
import RequestToServer.PostData.RequestUpdateLevel;
import RequestToServer.PostData.RequestUpdateSound;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class ControllerSetting {
    @FXML
    private Button exitButton;
    @FXML
    private Button easyButton;
    @FXML
    private Button mediumButton;
    @FXML
    private Button hardButton;
    @FXML
    private Button logoutButton;
    @FXML
    private RadioButton muteRadio;
    @FXML
    private RadioButton unmuteRadio;

    private int idUser = ControllerLoppy.cl_checkLogin.getIdUser();
    private SV_Level sv_level;
    private SV_Sound sv_sound;
    @FXML
    public void initialize(){
        setSoundOnScreen();
        setLevelOnScreen();
        ControllerLoppy.scaleButton(exitButton);
        ControllerLoppy.scaleButton(easyButton);
        ControllerLoppy.scaleButton(mediumButton);
        ControllerLoppy.scaleButton(hardButton);
        ControllerLoppy.scaleButton(logoutButton);
        easyButton.setOnAction(this::chooseLevel);
        mediumButton.setOnAction(this::chooseLevel);
        hardButton.setOnAction(this::chooseLevel);
        exitButton.setOnAction(this::exitSetting);
        logoutButton.setOnAction(this::logout);
        muteRadio.setOnAction(this::settingSound);
        unmuteRadio.setOnAction(this::settingSound);
    }
    public void setLevelOnScreen(){
        CL_IdUser cl_idUser = new CL_IdUser();
        cl_idUser.setIdUser(idUser);
        sv_level = GetLevel.getLevel(cl_idUser);
        if (sv_level.getLevel() == 1){
            easyButton.setStyle("-fx-background-color:  #FFFF33; -fx-border-color: green;");
            mediumButton.setStyle("-fx-background-color:  #33FF99; -fx-border-color: green;");
            hardButton.setStyle("-fx-background-color:  #33FF99; -fx-border-color: green;");
        } else if (sv_level.getLevel() == 2) {
            easyButton.setStyle("-fx-background-color:  #33FF99; -fx-border-color: green;");
            mediumButton.setStyle("-fx-background-color: #FFFF33; -fx-border-color: green;");
            hardButton.setStyle("-fx-background-color:  #33FF99; -fx-border-color: green;");
        } else {
            easyButton.setStyle("-fx-background-color:  #33FF99; -fx-border-color: green;");
            mediumButton.setStyle("-fx-background-color:  #33FF99; -fx-border-color: green;");
            hardButton.setStyle("-fx-background-color:  #FFFF33; -fx-border-color: green;");
        }
    }
    public void chooseLevel(ActionEvent event){
        Button src = (Button) event.getSource();
        sv_level = new SV_Level();
        sv_level.setIdUser(idUser);
        if (src == easyButton) {
            easyButton.setStyle("-fx-background-color:  #FFFF33; -fx-border-color: green;");
            mediumButton.setStyle("-fx-background-color:  #33FF99; -fx-border-color: green;");
            hardButton.setStyle("-fx-background-color:  #33FF99; -fx-border-color: green;");
            sv_level.setLevel(1);
            RequestUpdateLevel.updateLevel(sv_level);
        } else if (src == mediumButton){
            easyButton.setStyle("-fx-background-color:  #33FF99; -fx-border-color: green;");
            mediumButton.setStyle("-fx-background-color: #FFFF33; -fx-border-color: green;");
            hardButton.setStyle("-fx-background-color:  #33FF99; -fx-border-color: green;");
            sv_level.setLevel(2);
            RequestUpdateLevel.updateLevel(sv_level);
        } else {
            easyButton.setStyle("-fx-background-color:  #33FF99; -fx-border-color: green;");
            mediumButton.setStyle("-fx-background-color:  #33FF99; -fx-border-color: green;");
            hardButton.setStyle("-fx-background-color:  #FFFF33; -fx-border-color: green;");
            sv_level.setLevel(3);
            RequestUpdateLevel.updateLevel(sv_level);
        }
    }
    public void settingSound(ActionEvent event){
        sv_sound = new SV_Sound();
        sv_sound.setIdUser(idUser);
        RadioButton src = (RadioButton) event.getSource();
        if (src == muteRadio) {
            sv_sound.setSound(1);
            RequestUpdateSound.updateSound(sv_sound);
        } else {
            sv_sound.setSound(0);
            RequestUpdateSound.updateSound(sv_sound);
        }
    }
    public void setSoundOnScreen(){
        ToggleGroup group = new ToggleGroup();
        muteRadio.setToggleGroup(group);
        unmuteRadio.setToggleGroup(group);
        CL_IdUser cl_idUser = new CL_IdUser(idUser);
        sv_sound = GetSound.getSound(cl_idUser);
        if (sv_sound.getSound() == 1) {
            muteRadio.setSelected(true);
        } else {
            unmuteRadio.setSelected(true);
        }
    }
    public void exitSetting(ActionEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewLoppy.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(root);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void logout(ActionEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewLogin.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(root);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}