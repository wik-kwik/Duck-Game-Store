package sample;

import java.lang.reflect.Array;
import java.util.ArrayList;




class Gra {
    private int time_spend;
    private ArrayList <Opinia> lista_opinii= new ArrayList<>();
    private String opis;
    private String nazwa;

    public Gra(String name, String description){    //konstruktor obiektu
        this.opis=description;
        this.nazwa=name;
        this.time_spend=0;                          //ilość godzin spędzonych w grze standardowo jest ustawiana na zero
    }


    public void dodaj_opinie(Opinia x){         //jak w nazwie
        this.lista_opinii.add(x);
    }
    public int get_IloscGodzin(){               //getter ilości godzin spędzonych przez użytkownika w grze;
        return this.time_spend;
    }
    public void Zmień_Opis(String nowy_opis){   //zmienia opis gry
        this.opis=nowy_opis;
    }
    public String getNazwa(){                   //getter nazwy
        return nazwa;
    }
}

