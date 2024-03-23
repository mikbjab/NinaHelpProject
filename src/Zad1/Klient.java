package Zad1;

import static java.lang.System.out;

public class Klient {
    private String id;
    private Koszyk koszyk;

    public Koszyk getKoszyk() {
        return koszyk;
    }

    public String getId() {
        return id;
    }

    public Klient(String id){
        this.id=id;
        this.koszyk=new Koszyk();
    }

    public void obsluzKlienta(){
        double sum=0;
        out.println("Zad1.Klient "+this.getId());
        out.println("Lista zakupów (nazwa,liczba,cena): ");
        while( this.koszyk.czyPusty()){
            ProduktWKoszyku temp=this.koszyk.wyjmijProdukt();
            sum=sum+temp.getCena()*temp.getLiczbaSztukProduktu();
            out.println(temp.getNazwa()+" "+temp.getLiczbaSztukProduktu()+" "+temp.getCena());
        }
        out.println("Wartość koszyka: "+ String.valueOf(sum));
    }
}
