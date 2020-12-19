package cosmos.gui.fxmlcontroller;

import cosmos.gui.WindowGeneration;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Signage implements Initializable {

    @FXML
    private MediaView mediaView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file1 = new File(WindowGeneration.moviePath);
        Media media = new Media(file1.toURI().toString());
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
                new WindowGeneration("/zaishitu.fxml", "/styles.css", "JavaFX and Gradle", null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
