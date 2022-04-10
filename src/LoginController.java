package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;
import sample.Connect;


import java.io.File;
import java.util.ResourceBundle;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class LoginController implements Initializable {

    @FXML private Button cancelButton;
    @FXML private Label loginMessageLabel;
    @FXML private ImageView loginImageView;
    @FXML private ImageView lockImageView;
    @FXML private TextField usernameTextField;
    @FXML private PasswordField enterPasswordField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Tło + logo
        File loginFile = new File("img/login.png");
        Image loginImage = new Image(loginFile.toURI().toString());
        loginImageView.setImage(loginImage);
        //Ikona kłódki
        File lockFile = new File("img/login_icon.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);
    }

    //Przycisk login
    public void loginButtonOnAction(ActionEvent event) {
        int x=2;
        x=validateLogin();
        if(x==0){
            loginMessageLabel.setText("Błędny login lub hasło");
        }
        if (usernameTextField.getText().isBlank() == false && enterPasswordField.getText().isBlank() == false) {
        validateLogin();
        } else loginMessageLabel.setText("Podaj login i hasło");
    }
    //Przycisk cancel
    public void cancelButtonOnAction (ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    //Metoda połączona z bazą danych; weryfikacja query srery bajery sqlisko
    //Będzie korzystać z metody niżej (createAccountForm)
    public int validateLogin() {
        Connect temp = new Connect();
        List<User> lista_us=new LinkedList<User>();
        lista_us=temp.selectUsers();
        int temp_len_linked_list=0;
        int which_position=0;
        temp_len_linked_list=lista_us.size();
        String log = usernameTextField.getText();
        boolean flaga = false;
        boolean test = false;
        for(int i=0;i<temp_len_linked_list;i++){
            String s=lista_us.get(i).getLogin();
            test=s.equalsIgnoreCase(log);
            if(test==true){
                flaga = true;
                which_position = i;
            }
        }

        //Pomyślne zalogowanie
        if(flaga == true){
            if(lista_us.get(which_position).getPassword().equalsIgnoreCase(enterPasswordField.getText())){
                //loginSuccess();
                // TU SIĘ DWA RAZY OKIENKO WYWOŁUJE
                return 1;
            }
        }
        //Tu se to przeniosłam żeby łatwiej ogarniać sklep
       loginSuccess();
        return 0;
    }

    public void createAccountForm() {
        try{
    //Pierdyliard strasznego kodu który po prostu generuje nowe okienko:~D
            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 520, 483));
            registerStage.show();

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    //Przeniesienie do sklepu po zalogowaniu
    public void loginSuccess() {
        try{
            //Pierdyliard strasznego kodu który po prostu generuje nowe okienko:~D
            Parent root = FXMLLoader.load(getClass().getResource("gamestore.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 1291, 792));
            registerStage.show();

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
