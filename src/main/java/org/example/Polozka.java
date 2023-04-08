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

    /**
     * vypocita cenu "polozky" tim ze vynasobi "mnozstvi Polozky"  a "cenu Zbozi"
     * @return double
     */
    public double cena()
    {
        return zbozi.getJednotkovaCena() * mnozstvi;
    }

    /**
     * vrati informace o "Zbozi" (cena/kusy = Kc/ks) a informace o "Polozce" ("mnozstvi", "cenu")
     * @return String
     */
    @Override
    public String toString()
    {
        return String.format("%s: mnozstvi: %d %s, cena = %s ks * %s Kc = " + this.zbozi.jednotkovaCena*mnozstvi + " Kc", zbozi, mnozstvi*zbozi.getJednotkoveMnozstvi(), zbozi.getJednotka(), mnozstvi, zbozi.getJednotkovaCena());
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
