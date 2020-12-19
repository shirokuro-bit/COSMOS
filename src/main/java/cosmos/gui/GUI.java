package cosmos.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class GUI extends Application {
    public static int movieCount = 0;
    @Override
    public void start(Stage stage) throws Exception {
        new WindowGeneration("/zaishitu.fxml", "/styles.css", "JavaFX and Gradle", null);
        //new MovieManagement();
    }
}
