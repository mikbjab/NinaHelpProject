package Zad1;

import Zad1.Produkt;

public class ProduktWKoszyku extends Produkt {
    private int liczbaSztukProduktu;

    public int getLiczbaSztukProduktu() {
        return liczbaSztukProduktu;
    }

    public void setLiczbaSztukProduktu(int liczbaSztukProduktu) {
        this.liczbaSztukProduktu = liczbaSztukProduktu;
    }

    public ProduktWKoszyku(String nazwa, double cena, int liczba) {
        super(nazwa, cena);
        this.liczbaSztukProduktu=liczba;
    }

    public ProduktWKoszyku(Produkt produkt, int liczbaSztukProduktu) {
        super(produkt.getNazwa(),produkt.getCena());
        this.liczbaSztukProduktu = liczbaSztukProduktu;
    }
}
