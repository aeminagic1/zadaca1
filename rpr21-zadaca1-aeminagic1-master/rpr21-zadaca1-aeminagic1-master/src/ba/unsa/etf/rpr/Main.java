package ba.unsa.etf.rpr;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Kviz milijunas =new Kviz("Ko zeli biti milijunas?", SistemBodovanja.BINARNO);
        Pitanje pitanjce =new Pitanje("Sto je sarma slana?",10);
        pitanjce.dodajOdgovor("a", "Zato",true);
        pitanjce.dodajOdgovor("b","Nema hljeba", false);
        pitanjce.dodajOdgovor("c","Zena nije gledala",false);
        milijunas.dodajPitanje(pitanjce);
        Pitanje p2=new Pitanje("Da li vanzemaljci vole burek?",25);
        p2.dodajOdgovor("a","Naravno", true);
        p2.dodajOdgovor("b","Ne, burek je otrovan za vanzemaljce.",false);
        milijunas.dodajPitanje(p2);
        Pitanje p3=new Pitanje("Od kojeg graha puca ekran na telfonu?",7);
        p3.dodajOdgovor("1","Sareni",true);
        p3.dodajOdgovor("2","Bijeli", false);
        milijunas.dodajPitanje(p3);
        igrajKviz(milijunas);
    }

    public static void igrajKviz(Kviz kviz){
        try {
            Map<Pitanje, ArrayList<String>> pitanjeIOdgovor = new HashMap<>();
            for (Pitanje kvescn : kviz.getPitanja()) {
                ArrayList<String> odgovoriJednogPitanja = new ArrayList<>();
                System.out.println(kvescn);
                System.out.println("\nUnesite Vaše odgovore odvojene sa ENTER(x za kraj): ");
                for (;;) {
                    Scanner ulaz = new Scanner(System.in);
                    String odg = ulaz.nextLine();
                    if (odg.equals("x")) break;
                    else odgovoriJednogPitanja.add(odg);
                }
                pitanjeIOdgovor.put(kvescn, odgovoriJednogPitanja);
            }
            System.out.println("\n The end!");
            RezultatKviza rezultatKviza = kviz.predajKviz(pitanjeIOdgovor);
            System.out.println(rezultatKviza);
            System.out.println("\nDa li želite pregled tacnih odgovora(Odgovorite sa DA/NE)? ");
            Scanner ulaz = new Scanner(System.in);
            String da = ulaz.nextLine();
            if (da.equals("DA")) System.out.println(kviz + "\nBitno je ucestvovati!");
            else if (da.equals("NE")) System.out.println("\nBitno je ucestvovati!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
