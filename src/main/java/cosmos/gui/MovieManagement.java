package cosmos.gui;

import cosmos.GetFileName;

import java.io.File;
import java.io.IOException;

public class MovieManagement {
    public MovieManagement() {
        try {
            File[] files = new GetFileName().getFiles();
            new WindowGeneration("/signage.fxml", "/styles.css", "JavaFX and Gradle", files[GUI.movieCount].toString());
            GUI.movieCount++;
            if (GUI.movieCount == files.length) {
                GUI.movieCount = 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
