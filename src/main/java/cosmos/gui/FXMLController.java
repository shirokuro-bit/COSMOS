package cosmos.gui;

import cosmos.mariadb.ConnectDB;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    ConnectDB connectDB = new ConnectDB();

    @FXML
    private Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText("Hello, JavaFX\nRunning on Java.");

        Timeline timer = new Timeline(
                new KeyFrame(Duration.seconds(5), event -> {
                    //現在表示されている画面を閉じる
                    Scene scene1 = (label.getScene());
                    Window window = scene1.getWindow();
                    window.hide();

                    //新しい画面を生成する
                    try {
                        new GenerateWindow("/signage.fxml","/styles.css","JavaFX and Gradle");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
        );
        timer.play();
    }
}
