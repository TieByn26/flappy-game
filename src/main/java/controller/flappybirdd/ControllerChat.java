package controller.flappybirdd;

import ObjectGson.GsonForServer.SV_ListMessage;
import ObjectGson.GsonForServer.SV_Message;
import RequestToServer.GetData.GetAllMess;
import RequestToServer.PostData.RequestUpdate;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ControllerChat {
    @FXML
    private Button exitButton;
    @FXML
    private Button sendButton;
    @FXML
    private TextField messInput;
    @FXML
    private VBox containerMess;
    @FXML
    private ScrollPane scrollPane;
    private Boolean check = true;
    public static SV_Message sv_message1;

    @FXML
    public void initialize(){
        setMessOnScreen();
        exitButton.setOnAction(this::closeChat);
        sendButton.setOnAction(this::sendMessage);
        ControllerLoppy.scaleButton(exitButton);
        ControllerLoppy.scaleButton(sendButton);
    }
    public void closeChat(ActionEvent event){
        check = false;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ControllerChat.class.getResource("ViewLoppy.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(root);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setMessOnScreen() {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    while (check) {
                        SV_ListMessage list = GetAllMess.getAllMessage();
                        Platform.runLater(() -> {
                            try {
                                containerMess.getChildren().clear();
                                for (SV_Message sv_message : list.getListMess()) {
                                    sv_message1 = sv_message;
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewMessage.fxml"));
                                    Parent fxml = loader.load();
                                    containerMess.getChildren().add(fxml);

                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                        Thread.sleep(2000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }
    public void sendMessage(ActionEvent event){
        Button src = (Button) event.getSource();
        if (src == sendButton){
            SV_Message svMessage = new SV_Message();
            svMessage.setContent(messInput.getText());
            svMessage.setUserId(ControllerLoppy.cl_checkLogin.getIdUser());
            RequestUpdate.updateMessage(svMessage);
            ControllerLoppy.kk();
            System.out.println(svMessage);
            messInput.setText("");
        }
    }
}