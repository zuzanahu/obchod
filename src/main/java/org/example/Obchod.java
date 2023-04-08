package org.example;

public interface Obchod {
    public void pridejZbozi(Zbozi z);
    public boolean odstranZbozi(Zbozi z) ;

    /*public boolean odstranZbozi(int index); //kdyby nabidka byla treba hash mapa nebo co */

    public void ulozNabidku(String fileName);
    public  void nactiNabidku(String fileName);

    public void vymazNabidku();

    public String[] nabidkaAsStringArray();

}
