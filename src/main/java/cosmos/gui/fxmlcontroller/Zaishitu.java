package cosmos.gui.fxmlcontroller;

import cosmos.gui.MovieManagement;
import cosmos.mariadb.ConnectDB;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Window;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Zaishitu implements Initializable {

    ConnectDB connectDB = new ConnectDB();

    @FXML
    private Label label;

    @FXML
    private Label label00;

    @FXML
    private Label label01;

    @FXML
    private Label label10;

    @FXML
    private Label label11;

    @FXML
    private Label label20;

    @FXML
    private Label label21;

    @FXML
    private Label label30;

    @FXML
    private Label label31;

    @FXML
    private Label label40;

    @FXML
    private Label label41;

    @FXML
    private Label label50;

    @FXML
    private Label label51;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            label00.setText(connectDB.getUser(0));
            label01.setText(connectDB.getZaishitu(0));

            label10.setText(connectDB.getUser(1));
            label11.setText(connectDB.getZaishitu(1));

            label20.setText(connectDB.getUser(2));
            label21.setText(connectDB.getZaishitu(2));

            label30.setText(connectDB.getUser(3));
            label31.setText(connectDB.getZaishitu(3));

            label40.setText(connectDB.getUser(4));
            label41.setText(connectDB.getZaishitu(4));

            label50.setText(connectDB.getUser(5));
            label51.setText(connectDB.getZaishitu(5));

        }catch (Exception e) {
            e.printStackTrace();
        }

        Timeline timer = new Timeline(
                new KeyFrame(Duration.seconds(10), event -> {
                    //現在表示されている画面を閉じる
                    Scene scene1 = (label.getScene());
                    Window window = scene1.getWindow();
                    window.hide();

                    new MovieManagement();
                })
        );
        timer.play();
    }
}
