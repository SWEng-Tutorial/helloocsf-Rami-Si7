/**
 * Sample Skeleton for 'login.fxml' Controller Class
 */

package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.loginMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML // fx:id="buttonForLogin"
    private Button buttonForLogin; // Value injected by FXMLLoader

    @FXML // fx:id="passwordText"
    private TextField passwordText; // Value injected by FXMLLoader

    @FXML // fx:id="usernameText"
    private TextField usernameText; // Value injected by FXMLLoader

    @FXML
    void login(ActionEvent event) throws IOException
    {
        Message msg = new Message("Login",null);
        msg.setUsername(usernameText.getText());
        msg.setPassword(passwordText.getText());
        System.out.println("ffff");
        SimpleClient.sendToServer(msg);
    }

    @FXML
    void passwordAction(ActionEvent event)
    {

    }

    @FXML
    void usernameAction(ActionEvent event)
    {

    }

}
