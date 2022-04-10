package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;
import sample.Connect;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AppController implements Initializable {
    //Druga część zadymki
    private Main application;
    public void setApp(Main application) {
        this.application = application;
    }

    @FXML private ImageView logoImageView;
    @FXML private HBox logoHBox;
    @FXML private ImageView libraryImageView;
    @FXML private Button libraryButton;
    @FXML private HBox shopHBox;
    @FXML private ImageView shopImageView;
    @FXML private Button shopButton;
    @FXML private HBox profileHBox;
    @FXML private ImageView profileImageView;
    @FXML private Button profileButton;
    @FXML private Button logoutButton;
    @FXML private ImageView logoutImageView;
    @FXML private ImageView exitImageView;
    @FXML private BorderPane mainPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Logo
        File logoFile = new File("img/logo.png");
        Image logoImage = new Image(logoFile.toURI().toString());
        logoImageView.setImage(logoImage);
        //Ikona pada
        File libraryFile = new File("img/library.png");
        Image libraryImage = new Image(libraryFile.toURI().toString());
        libraryImageView.setImage(libraryImage);
        //Ikona sklepu
        File shopFile = new File("img/shop.png");
        Image shopImage = new Image(shopFile.toURI().toString());
        shopImageView.setImage(shopImage);
        //Ikona profilu
        File profileFile = new File("img/profile.png");
        Image profileImage = new Image(profileFile.toURI().toString());
        profileImageView.setImage(profileImage);
        //Ikona wylogowania
        File logoutFile = new File("img/logout.png");
        Image logoutImage = new Image(logoutFile.toURI().toString());
        logoutImageView.setImage(logoutImage);
        //Ikona wyłączenia aplikacji
        File exitFile = new File("img/exit.png");
        Image exitImage = new Image(exitFile.toURI().toString());
        exitImageView.setImage(exitImage);
    }

    public void libraryButtonOnAction(ActionEvent event) {
        PageLoader object = new PageLoader();
        Pane view = object.getPage("library");
        mainPane.setRight(view);
    }
    public void shopButtonOnAction(ActionEvent event) {
        PageLoader object = new PageLoader();
        Pane view = object.getPage("shop");
        mainPane.setRight(view);
    }
    public void profileButtonOnAction(ActionEvent event) {
        PageLoader object = new PageLoader();
        Pane view = object.getPage("profile");
        mainPane.setRight(view);
    }

    //Wylogowanie
    public void logoutButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
    }

    //Wyjście z aplikacji
    public void exitApp() {
        System.exit(0);
    }
}
