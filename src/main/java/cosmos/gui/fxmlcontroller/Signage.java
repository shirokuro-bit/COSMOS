package cosmos.gui.fxmlcontroller;

import cosmos.gui.GenerateWindow;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Signage implements Initializable {

    @FXML
    private MediaView mediaView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Media media = new Media("https://nompor.com/wp-content/uploads/2018/01/sample2.mp4");
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
        mediaPlayer.setOnEndOfMedia(() ->{
            //現在表示されている画面を閉じる
            Scene scene1 = (mediaView.getScene());
            Window window = scene1.getWindow();
            window.hide();

            //新しい画面を生成する
            try {
                new GenerateWindow("/zaishitu.fxml", "/styles.css", "JavaFX and Gradle");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
