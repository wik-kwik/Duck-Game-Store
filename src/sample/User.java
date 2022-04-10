package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

class User extends Biblioteka{
    private String login;
    private String password;
    private ArrayList <Opinia> dodane_opinie = new ArrayList<>();



    public User(String log, String passw){          //Konstruktor obiektu, lista gier standardowo jest pusta
        this.login=log;
        this.password=passw;
    }

    public String getLogin() {
        return login;
    }
    public String getPassword(){
        return password;
    }
}


