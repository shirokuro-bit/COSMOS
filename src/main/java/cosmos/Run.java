package cosmos;

import cosmos.gui.GUI;
import javafx.application.Application;

public class Run {
    public static LoadConfig loadConfig = new LoadConfig();
    public static void main(String[] args){
        Application.launch(GUI.class);
    }
}
