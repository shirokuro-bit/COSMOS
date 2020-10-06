package cosmos.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUI extends Application {

    public static Stage stage;
    public static Scene scene1 = null;
    public static Scene scene2 = null;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("JavaFX and Gradle");

        roomScene(stage);
        signageScene(stage);

        stage.setScene(scene2);
        stage.show();
    }

    public void roomScene(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/scene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene1 = new Scene(root);
        scene1.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
    }

    public void signageScene(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/signage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene2 = new Scene(root);
        scene2.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
    }

    public static void setScene(Stage stage,Scene changeScene) {
        stage.setScene(changeScene);
        stage.show();
    }
}
