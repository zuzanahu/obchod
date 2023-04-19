package org.example;

import java.util.ArrayList;
import java.util.List;

public class Kosik {
    List<Polozka> polozky;


    public Kosik() {
        this.polozky = new ArrayList<Polozka>(); //ma to byt typu polozka nebo ne?
    }


    public int indexPolozky(Zbozi z)
    {
        int index = polozky.size()-1;
        while (index >= 0 && !z.equals(polozky.get(index).getZbozi()))
            index--;

        return index;
    }

    /**
     * zkontroluje jestli se "polozka" v "kosiku" vyskytuje a kdyz ano zvysi "mnozstvi" polozky, kdyz ne prida ji tam
     * @param p "polozka", kterou chci pridat do "kosiku"
     */
    public void pridejPolozku(Polozka p) { //deleguju, co to je?
        for (int i = 0; i < this.polozky.size(); i++) {
            Polozka aktualniPolozka = this.polozky.get(i);
            Zbozi aktualniZbozi = aktualniPolozka.getZbozi();
            Zbozi zboziNovePolozky = p.getZbozi();

            if (aktualniZbozi == zboziNovePolozky) {
                aktualniPolozka.setMnozstvi(aktualniPolozka.getMnozstvi() + p.getMnozstvi());
                return;
            }
        }

        polozky.add(p);
    }

    /**
     * vrati soucet vsech cen "polozek", ktere jsou v "kosiku", tzn. celkovou cenu, kterou bych zaplatila u pokladny
     * @return double
     */
    public double cena() {
        //polozky.forEach((polozka -> polozka.cena().reduce(0, Double::sum));
        double result = 0;
        for (Polozka p : polozky) {
            result += p.cena();

        }
        return result;
    }

    public void zvysMnozstvi(int index) {
        polozky.get(index).zvysMnozstvi();
    }

    public void snizMnozstvi(int index) {
        polozky.get(index).snizMnozstvi();
    }


    public void vyprazdni() {
        polozky.clear();
    }

    /**
     * da vsechny "Polozky" do sekvence Stringu
     * @return String sequence
     */
    @Override
    public String toString()
    {
        StringBuilder b = new StringBuilder();
        b.append("Seznam kosiku:\n");
        for (Polozka p : polozky)
        {
            // "append(p)" pripoji "Polozku" ve formatu ktery ovlivnuje metoda "toString()" ve tride "Polozka"
            b.append(p).append("\n");
        }

        return b.toString();
    }
    public String[] asStringArray() {
        String [] pole = new String[polozky.size()];
        for (int i = 0; i < polozky.size(); i++)
            pole[i] = polozky.get(i).toString();
        return pole;
    }
}
