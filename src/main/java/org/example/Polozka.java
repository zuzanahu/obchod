package org.example;

public class Polozka {
    //stejne jako zbozi ale bude tam i mnostvi

    private Zbozi zbozi;
    private int mnozstvi; // kolik mam nasobků jednotkoveho mnozstvi

    public Polozka(Zbozi zbozi, int mnozstvi) {
        this.zbozi = zbozi;
        this.mnozstvi = mnozstvi;
    }

    public Polozka(Zbozi zbozi) {
        this(zbozi, 1);
    }

    public void zvysMnozstvi() {
        this.mnozstvi += zbozi.getJednotkoveMnozstvi();
    }

    public void snizMnozstvi() {
        if (mnozstvi > zbozi.getJednotkoveMnozstvi()) {
            this.mnozstvi -= zbozi.getJednotkoveMnozstvi();
        }

    }
    public double cena()
    {
        return zbozi.getJednotkovaCena() * mnozstvi/zbozi.getJednotkoveMnozstvi();
    }

    @Override
    public String toString()
    {
        return String.format("%s * %d %s * %s", zbozi, mnozstvi*zbozi.getJednotkoveMnozstvi(), zbozi.getJednotka(), zbozi.getJednotkovaCena());
    }


    public Zbozi getZbozi() {
        return zbozi;
    }

    public int getMnozstvi() {
        return mnozstvi;
    }

    public void setZbozi(Zbozi zbozi) {
        this.zbozi = zbozi;
    }

    public void setMnozstvi(int mnozstvi) {
        this.mnozstvi = mnozstvi;
    }


}
