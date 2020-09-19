package cosmos.gui;

import cosmos.mariadb.ConnectDB;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    ConnectDB connectDB = new ConnectDB();

    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        label.setText(connectDB.getDate(0)+"\n"+connectDB.getUser(0)+"\n"+connectDB.getZaishitu(0));
        //label.setText("Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion + ".");
    }
}
