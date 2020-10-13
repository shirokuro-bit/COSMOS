package cosmos.gui;

import cosmos.mariadb.ConnectDB;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    ConnectDB connectDB = new ConnectDB();

    @FXML
    private Label label;

    @FXML
    private Label label01;

    @FXML
    private Label label11;

    @FXML
    private Label label02;

    @FXML
    private Label label12;

    @FXML
    private Label label03;

    @FXML
    private Label label13;

    @FXML
    private Label label04;

    @FXML
    private Label label14;

    @FXML
    private Label label05;

    @FXML
    private Label label15;

    @FXML
    private Label label06;

    @FXML
    private Label label16;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            label01.setText(connectDB.getUser(0));
            label11.setText(connectDB.getZaishitu(0));

            label02.setText(connectDB.getUser(1));
            label12.setText(connectDB.getZaishitu(1));

            label03.setText(connectDB.getUser(2));
            label13.setText(connectDB.getZaishitu(2));

            label04.setText(connectDB.getUser(3));
            label14.setText(connectDB.getZaishitu(3));

            label05.setText(connectDB.getUser(4));
            label15.setText(connectDB.getZaishitu(4));

            label06.setText(connectDB.getUser(5));
            label16.setText(connectDB.getZaishitu(5));
        }catch (Exception e) {
            e.printStackTrace();
        }

        Timeline timer = new Timeline(
                new KeyFrame(Duration.seconds(15), event -> {
                    //現在表示されている画面を閉じる
                    Scene scene1 = (label.getScene());
                    Window window = scene1.getWindow();
                    window.hide();

                    //新しい画面を生成する
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("/signage.fxml"));

                        Scene scene = new Scene(root);
                        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setTitle("JavaFX and Gradle");
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
        );
        timer.play();
    }
}
