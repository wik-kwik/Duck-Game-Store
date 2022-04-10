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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;
import sample.Connect;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class ShopController implements Initializable {

    @FXML
    private ImageView logoImageView;
    @FXML
    private HBox logoHBox;
    @FXML
    private ImageView libraryImageView;
    @FXML
    private HBox libraryHBox;
    @FXML
    private Button libraryButton;
    @FXML
    private HBox shopHBox;
    @FXML
    private ImageView shopImageView;
    @FXML
    private Button shopButton;
    @FXML
    private HBox profileHBox;
    @FXML
    private ImageView profileImageView;
    @FXML
    private Button profileButton;

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

    }

}
