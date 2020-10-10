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

    //ConnectDB connectDB = new ConnectDB();

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
/*
Task<Void> timer = new Task<Void>() {
    @Override
    protected Void call() throws Exception {
    try {
        Thread.sleep(1000 * 1 * 5);
    }catch (InterruptedException e) {

    }
    return null;
    }
};
new Thread(timer).start();
*/

