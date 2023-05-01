package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


//testy - jednotkové testy pro kazdou tridu, kontakt, ulozit kosik do jsonu, vytisknout učtenku
public class ObchodImpl implements Obchod {
    private List<Zbozi> nabidka;
    private String majitel;

    public List<Zbozi> getNabidka() {
        return nabidka;
    }

    public ObchodImpl(List<Zbozi> nabidka, String majitel) {
        this.nabidka = nabidka;
        this.majitel = majitel;
    }

    public ObchodImpl() {
        this.nabidka = new ArrayList<Zbozi>(); // to Zbozi tam mit napsany nemusím si myslím, že se to tam stejně propíše
        this.majitel = ""; //tohle se ale stejně takhle samo zinicialuzuje
    }
    public void pridejZbozi(Zbozi z) {
        this.nabidka.add(z);
    }
    public boolean odstranZbozi(Zbozi z) {
        return nabidka.remove(z);
    }
    public boolean odstranZbozi(String nazev) {
        Zbozi z = najdi(nazev);
        if (z == null) {
            System.out.println("Zbozi" + nazev + "v nabidce neni");
            return false;
        } else {
            odstranZbozi(z);
        }

        return nabidka.remove(z);
    }
    /*public Zbozi najdiZbozi(String nazev) {
        int index = nabidka.indexOf(nazev);
        if (index == -1) {
            return  null;
        }
        return nabidka.get(index);
    }*/ //spatne

    /**
     * hleda v nabidce "Zbozi" podle "nazvu Zbozi"
     * @param nazev
     * @return Zbozi
     */
    public Zbozi najdi(String nazev) { //indexOf vyhledava na zaklade metody equals ktera je predefinovana ve Zbozi a nemusime pouzivat for loop a projizdet arrayList to je prasacky
        int index = nabidka.indexOf(new Zbozi("pomerance", "ks", 1, 2.5, 5));
        if (index == -1) {
            return null;
        } else {
            return nabidka.get(index);
        }

    }

    /*public void odstranZbozi(int index); //kdyby nabidka byla treba hash mapa nebo co */

    /**
     * Prepise atribut "nabidka" parameterem "nabidka"
     * @param nabidka
     */
    public void vytvorNovouNabidku(List<Zbozi> nabidka) {
        this.nabidka = nabidka;
    }
    public void ulozNabidku(String fileName) {
        try
        {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Zbozi z : nabidka)
                bufferedWriter.write(z.getNazev()+";" +z.getJednotkoveMnozstvi()+ ";"+ z.getJednotka() + ";" + z.getJednotkovaCena() + "\n");
            bufferedWriter.close();
        }
        catch(IOException ex)
        {
            System.out.format("Error writing to fileName '%s'", fileName);
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }

    public  void nactiNabidku(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            nabidka.clear();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String [] tokens = line.split(";");
                Zbozi z = new Zbozi (tokens[0],tokens[2],Integer.parseInt(tokens[1]),Double.parseDouble(tokens[3]), Integer.parseInt(tokens[4]));
                nabidka.add(z);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.format("Error reading from file '%s'", fileName);
        }

    }

    public void vymazNabidku() {
        nabidka.clear();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(); //tadyten retezec muzu menit neni to constanta
        stringBuilder.append("majitel:" + this.majitel + "\n");
        stringBuilder.append("dnesni nabidka:\n");
        for (Zbozi z : this.nabidka) {
            stringBuilder.append(z.toString() + "\n");
        }
        return stringBuilder.toString();
    }

    public String[] nabidkaAsStringArray() {
        String [] pole = new String[nabidka.size()];
        for (int i = 0; i < nabidka.size(); i++)
            pole[i] = nabidka.get(i).toString();
        return pole;
    }

    public int size()
    {
        return nabidka.size();
    }
    /**
     * vypise nabidku do konzole
     */
    public void vypisNabidku() {
        System.out.println("aktualni nabidka je: " + String.join(", ", this.nabidkaAsStringArray()));
    }
}
