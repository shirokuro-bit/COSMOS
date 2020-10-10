package cosmos.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GenerateWindow {
    public GenerateWindow(String FXMLPath, String CSSPath, String StageTitle) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(FXMLPath));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource(CSSPath).toExternalForm());

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(StageTitle);
        stage.show();
    }
}
