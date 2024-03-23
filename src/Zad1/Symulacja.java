package Zad1;

import Zad1.Klient;
import Zad1.Produkt;

import java.util.*;

public class Symulacja {
    public static void main(String[] args) {
        Random rand=new Random();

        List<Produkt> listaProduktow=new ArrayList<>();
        List<Klient> listaKlientow=new ArrayList<>();

        listaProduktow.add(new Produkt("Maslo",5.5));
        listaProduktow.add(new Produkt("Maka",3.2));
        listaProduktow.add(new Produkt("Mleko",2.1));
        listaProduktow.add(new Produkt("Dzem",7.8));
        listaProduktow.add(new Produkt("Czekolada",4));
        listaProduktow.add(new Produkt("Platki",10));
        listaProduktow.add(new Produkt("Kakao",8.9));
        listaProduktow.add(new Produkt("cebula",0.81));
        listaProduktow.add(new Produkt("Ziemniak",0.2));
        listaProduktow.add(new Produkt("Bulka",0.33));
        listaProduktow.add(new Produkt("Woda",1.5));
        listaProduktow.add(new Produkt("Piwo",6));
        listaProduktow.add(new Produkt("Wino",20));
        listaProduktow.add(new Produkt("Olej",6));

        for(int i =0;i<14;i++){
            Klient tempKlient=new Klient(String.valueOf(i));
            for(int j=0;j<6;j++){
                int produktIndex=rand.nextInt(listaProduktow.size());
                int produktLiczba=1+rand.nextInt(5);
                tempKlient.getKoszyk().wlozProdukt(listaProduktow.get(produktIndex),produktLiczba);
            }
            listaKlientow.add(tempKlient);
        }

        Queue<Klient> kolejka = new LinkedList<>(listaKlientow);

        while(kolejka.peek()!=null){
            Klient k=kolejka.poll();
            k.obsluzKlienta();
        }
    }
}
