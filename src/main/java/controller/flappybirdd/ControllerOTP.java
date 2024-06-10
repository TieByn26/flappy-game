package controller.flappybirdd;

import ObjectGson.GsonForClient.CL_CheckOtp;
import ObjectGson.GsonForClient.CL_GetOtp;
import RequestToServer.PostData.RequestOTP;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerOTP {
    @FXML
    private Button submitButton;
    @FXML
    private Button getcapchaButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    private CL_GetOtp cl_getOtp;
    private static String username;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @FXML
    public void initialize(){
        getcapchaButton.setOnAction(actionEvent -> getCapcha());
        submitButton.setOnAction(this::submit);
        cancelButton.setOnAction(this::cancelToLogin);
    }
    private void getCapcha(){
        CL_CheckOtp cl_checkOtp = new CL_CheckOtp();
        cl_checkOtp.setUsername(textField1.getText());
        try {
            if (textField1.getText() == null || textField1.getText().trim().isEmpty()) {
                alert.setTitle("Information Dialog");
                alert.setContentText("Username không được để trống");
                alert.showAndWait();
            } else {
                cl_getOtp = RequestOTP.getOtp(cl_checkOtp);
                alert.setTitle("Information Dialog");
                alert.setContentText("OTP đã được gửi đến mail");
                alert.showAndWait();
                getcapchaButton.setVisible(false);
                submitButton.setVisible(true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void submit(ActionEvent event){
        int check = Integer.parseInt(textField2.getText());
        if (check == cl_getOtp.getOtp()) {
            setUsername(textField1.getText());
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(ControllerOTP.class.getResource("ViewForgot.fxml"));
                Parent root = fxmlLoader.load();
                Scene scene = ((Node) event.getSource()).getScene();
                scene.setRoot(root);
            }catch (Exception e){
                e.printStackTrace();
            }
        } else {
            alert.setTitle("Information Dialog");
            alert.setContentText("Sai mã xác minh");
            alert.showAndWait();
        }
    }
    private void cancelToLogin(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ControllerOTP.class.getResource("ViewLogin.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(root);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
