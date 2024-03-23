package Zad1;

import java.util.*;
import java.util.stream.Collectors;

public class Koszyk {
    private Deque<ProduktWKoszyku> zakupy;
    public Koszyk(){
        this.zakupy=new ArrayDeque<>();
    }

    public void wlozProdukt(ProduktWKoszyku produktWKoszyku){
        this.zakupy.push(produktWKoszyku);
    }
    public void wlozProdukt(Produkt produkt, int ilosc){
        this.zakupy.push(new ProduktWKoszyku(produkt,ilosc));
    }

    public ProduktWKoszyku wyjmijProdukt(){
        return this.zakupy.pop();
    }

    public List<ProduktWKoszyku> pokazKoszyk(){
        return new ArrayList<>(this.zakupy);
    }

    public double policzWartosc(){
        return this.zakupy.stream().map(produktWKoszyku -> produktWKoszyku
                        .getLiczbaSztukProduktu()*produktWKoszyku.getCena())
                        .reduce(0.,Double::sum);
    }
    public boolean czyPusty(){
        return this.zakupy.peek() != null;
    }
}
