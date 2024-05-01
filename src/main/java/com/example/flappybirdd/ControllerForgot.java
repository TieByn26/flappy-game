package com.example.flappybirdd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

public class ControllerForgot {
    @FXML
    private Button submitButton;
    @FXML
    private Button cancelButton;
    @FXML
    private PasswordField passwordField1;
    @FXML
    private PasswordField passwordField2;
    @FXML
    public void initialize(){
        submitButton.setOnAction(actionEvent -> changePass());
        cancelButton.setOnAction(this::cancelToLogin);
    }
    private void changePass(){

    }
    private void cancelToLogin(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ControllerCapcha.class.getResource("ViewLogin.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(root);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
