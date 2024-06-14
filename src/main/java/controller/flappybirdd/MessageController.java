package controller.flappybirdd;


import ObjectGson.GsonForServer.SV_ListUserInfor;
import ObjectGson.GsonForServer.SV_Message;
import ObjectGson.GsonForServer.SV_UserInfor;
import RequestToServer.GetData.GetAllUser;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MessageController {
    SV_ListUserInfor listUserInfor = GetAllUser.getAllUser();
    private SV_Message sv_message;
    @FXML
    private Label messLabel;
    @FXML
    private Label nameLabel;
    @FXML
    public void initialize(){
        sv_message = ControllerChat.sv_message1;
        for (SV_UserInfor sv_userInfor : listUserInfor.getListUserInfor()){
            if (sv_userInfor.getUserId() == sv_message.getUserId()){
                nameLabel.setText(sv_userInfor.getUsername());
            }
        }

        System.out.println("day"+sv_message);
        messLabel.setText(sv_message.getContent());
    }
}
