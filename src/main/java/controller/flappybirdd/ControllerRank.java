package controller.flappybirdd;

import ObjectGson.GsonForServer.SV_ListGetSkin;
import ObjectGson.GsonForServer.SV_ListScore;
import ObjectGson.GsonForServer.SV_ListUserInfor;
import RequestToServer.GetData.GetScoreInformation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControllerRank {
    @FXML
    private Button exitButton;
    @FXML
    private ImageView imageTop1;
    @FXML
    private ImageView imageTop2;
    @FXML
    private ImageView imageTop3;
    @FXML
    private Label nameTop1;
    @FXML
    private Label nameTop2;
    @FXML
    private Label nameTop3;
    @FXML
    private Label scoreTop1;
    @FXML
    private Label scoreTop2;
    @FXML
    private Label scoreTop3;

    @FXML
    public void initialize(){
        setDataOnScreen();
        exitButton.setOnAction(this::closeRank);
    }
    public void closeRank(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ControllerStartGame.class.getResource("ViewLoppy.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(root);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void setDataOnScreen(){
        SV_ListScore sv_listScore = GetScoreInformation.getScoreRank();
        SV_ListUserInfor sv_listUserInfor= GetScoreInformation.getScoreOfUser();
        SV_ListGetSkin sv_listGetSkin = GetScoreInformation.getSkinForRank();
        //set hinh anh bird
        Image image1 = new Image(getClass().getResource(sv_listGetSkin.getListGetSkin().get(0).getSkinBird()).toExternalForm());
        Image image2 = new Image(getClass().getResource(sv_listGetSkin.getListGetSkin().get(1).getSkinBird()).toExternalForm());
        Image image3 = new Image(getClass().getResource(sv_listGetSkin.getListGetSkin().get(2).getSkinBird()).toExternalForm());
        imageTop1.setImage(image1);
        imageTop2.setImage(image2);
        imageTop3.setImage(image3);
        //set name
        nameTop1.setText(sv_listUserInfor.getListUserInfor().get(0).getUsername());
        nameTop2.setText(sv_listUserInfor.getListUserInfor().get(1).getUsername());
        nameTop3.setText(sv_listUserInfor.getListUserInfor().get(2).getUsername());
        //set score
        scoreTop1.setText(sv_listScore.getListScore().get(0).getScore());
        scoreTop2.setText(sv_listScore.getListScore().get(1).getScore());
        scoreTop3.setText(sv_listScore.getListScore().get(2).getScore());
    }
}
