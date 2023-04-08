package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Vítejte na stránkách obchodu");
        ObchodImpl obchod = new ObchodImpl(new ArrayList<Zbozi>(), "Beda Travnicek");
        Zbozi z = new Zbozi("noviny", "ks", 1, 15);
        List<Zbozi> zbozi = new ArrayList(Arrays.asList(
                new Zbozi("rohliky1", "ks", 1, 2.5),
                new Zbozi("rohliky2", "ks", 1, 2.5),
                new Zbozi("rohliky3", "ks", 1, 2.5),
                new Zbozi("rohliky4", "ks", 1, 2.5),
                new Zbozi("rohliky5", "ks", 1, 2.5)
        ));
        obchod.vypisNabidku();
        obchod.vytvorNovouNabidku(zbozi);
        obchod.vypisNabidku();
        obchod.pridejZbozi(z);
        obchod.vypisNabidku();
        //obchod.ulozNabidku("nabidka.csv");
        obchod.pridejZbozi(new Zbozi("rohliky", "ks", 1, 2.5));
        obchod.pridejZbozi(new Zbozi("chleb", "ks", 1, 50));
        obchod.pridejZbozi(new Zbozi("pomerance", "kg", 1, 45));
        obchod.pridejZbozi(new Zbozi("mleko", "l", 1, 35));
        obchod.pridejZbozi(new Zbozi("maslo", "g", 250, 65));
        obchod.pridejZbozi(new Zbozi("kofola", "l", 2, 28));
        obchod.vypisNabidku();


        //obchod.nactiNabidku("nabidka.csv");
        Zbozi hledaneZbozi = obchod.najdi("pomernace");
        obchod.vypisNabidku();


        obchod.odstranZbozi("pomerance");
        obchod.vypisNabidku();

        //obchod.ulozNabidku("nabidka.csv");


        List<Zbozi> seznamProduktu = obchod.getNabidka();
        Kosik kosik = new Kosik();
        for (int i = 0; i < seznamProduktu.size(); i++) {
            kosik.pridejPolozku(new Polozka(seznamProduktu.get(i)));

        }
        System.out.println(kosik);
        System.out.println("celkova cena = " + kosik.cena());

        kosik.pridejPolozku(new Polozka(seznamProduktu.get(5), 3));
        kosik.pridejPolozku(new Polozka(seznamProduktu.get(9), 1));
        System.out.println(kosik);
        System.out.println("celkova cena = " + kosik.cena());
    }
}