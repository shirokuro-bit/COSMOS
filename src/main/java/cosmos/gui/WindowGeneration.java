package cosmos.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowGeneration {
    public static String moviePath;
    public WindowGeneration(String FXMLPath, String CSSPath, String StageTitle, String moviePath) throws IOException {
        WindowGeneration.moviePath = moviePath;
        Parent root = FXMLLoader.load(getClass().getResource(FXMLPath));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource(CSSPath).toExternalForm());

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(StageTitle);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.show();
    }
}
