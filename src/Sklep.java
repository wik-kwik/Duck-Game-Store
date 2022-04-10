package sample;

import java.util.ArrayList;


class Sklep {
    private ArrayList <Gra>lista_najnowszych_gier=new ArrayList<>();
    private ArrayList <Gra>lista_popular_gry=new ArrayList<>();
    private ArrayList <Gra>polecane_gry=new ArrayList<>();
    private ArrayList <Gra>pelna_lista_gier= new ArrayList<>();
    //Bez konstruktora bo wszystkie listy są na początku puste dopiero jak się rozwinie projekt i dodamy jakieś obiekty to zrobimy konstruktor
    public void Dodaj_grę(Gra x){       //dodaje gier do pełnej listy gier
        this.pelna_lista_gier.add(x);

    }




}



