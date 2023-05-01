package org.example;
public  class Zbozi {

    String nazev;

    String jednotka;

    int jednotkoveMnozstvi;
    double jednotkovaCena;

    public int baleni;

    public Zbozi(String nazev, String jednotka, int jednotkoveMnozstvi, double jednotkovaCena, int baleni) {
        this.jednotka = jednotka;
        this.nazev = nazev;
        this.jednotkoveMnozstvi = jednotkoveMnozstvi;
        this.jednotkovaCena = jednotkovaCena;
        this.baleni = baleni;
    }

    public void setJednotkovaCena(double jednotkovaCena) {
        this.jednotkovaCena = jednotkovaCena;
    }

    public void zlevni(double relFaktor) {
        this.jednotkovaCena *= (1.0 - relFaktor);
    }

    /*public void equals() { // můžeme porovnávat název, ale v e-shopu jsou unikatni ID atd.

    }*/

    @Override
    public boolean equals (Object obj) {
        return (((Zbozi) obj).nazev.equals(this.nazev)); //pretypuju obj na Zbozi a porovnam nazev proti nazvu zbozi
    }

    @Override
    public String toString() {
        return String.format("%s [%5.2f Kč/%s]", nazev, jednotkovaCena, (jednotkoveMnozstvi == 1 ? jednotka : (jednotkoveMnozstvi + jednotka))); // slepit retezec
    }

    public String getNazev() {
        return nazev;
    }

    public String getJednotka() {
        return jednotka;
    }

    public int getJednotkoveMnozstvi() {
        return jednotkoveMnozstvi;
    }

    public double getJednotkovaCena() {
        return jednotkovaCena;
    }
}