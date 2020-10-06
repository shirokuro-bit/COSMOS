package cosmos.gui;

import cosmos.mariadb.ConnectDB;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    //ConnectDB connectDB = new ConnectDB();

    @FXML
    private Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText("Hello, JavaFX\nRunning on Java.");

        /*try {
            wait(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        GUI.setScene(GUI.stage, GUI.scene2);
    }
}
