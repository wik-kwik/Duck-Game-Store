package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import java.net.URL;

public class PageLoader {
    private Pane view;

    public Pane getPage(String fileName) {
        try {
            URL fileURL = AppController.class.getResource( fileName + ".fxml");
            if (fileURL == null) {
                throw new java.io.FileNotFoundException("FXML file not found");
            }
            view = new FXMLLoader().load(fileURL);
        } catch (Exception e) {
            System.out.printf("No suitable page!");
        }
        return view;
    }
}
