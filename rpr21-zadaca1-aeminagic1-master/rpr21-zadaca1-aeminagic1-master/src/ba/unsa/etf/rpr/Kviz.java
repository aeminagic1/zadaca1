package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Kviz {
    private String naziv;
    private ArrayList<Pitanje> pitanja;
    private SistemBodovanja sistemBodovanja;
    public Kviz(String naziv, SistemBodovanja sistemBodovanja){
        this.naziv=naziv;
        this.sistemBodovanja=sistemBodovanja;
        pitanja=new ArrayList<>();
    }
    public String getNaziv() {
        return naziv;
    }

    public ArrayList<Pitanje> getPitanja() {
        return pitanja;
    }

    public SistemBodovanja getSistemBodovanja() {
        return sistemBodovanja;
    }
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setPitanja(ArrayList<Pitanje> pitanja) {
        this.pitanja = pitanja;
    }
    public void setSistemBodovanja(SistemBodovanja sistemBodovanja){
        this.sistemBodovanja=sistemBodovanja;
    }
    public void dodajPitanje(Pitanje pitanje) throws IllegalArgumentException {
        for (Pitanje vrijednost : pitanja) {
            if (vrijednost.equals(pitanje)) {
                throw new IllegalArgumentException("Ne možete dodati pitanje sa tekstom koji već postoji");
            }
        }
        pitanja.add(pitanje);
    }

    @Override
    public String toString() {
        String s="Kviz "+"\""+naziv+"\""+" boduje se "+sistemBodovanja+". "+"Pitanja:";
        int i=1;
        for(Pitanje temp : pitanja){
            s=s+("\n"+i+". "+ temp.getTekst()+"("+ temp.getBrojPoena()+"b)");
            for(Map.Entry<String,Odgovor> o: temp.getOdgovori().entrySet()){
                s=s+("\n\t"+o.getKey().toString()+": "+o.getValue().toString());
                if(o.getValue().isTacno()) s=s+"(T)";
            }
            if(i!=pitanja.size()) s=s+"\n";
            i++;
        }
        return s;
    }
    public RezultatKviza predajKviz(Map<Pitanje, ArrayList<String>> odgovor){

        RezultatKviza rezultatKviza =new RezultatKviza(this);
        Map<Pitanje, Double> pomoc =new HashMap<>();
        double total=0.;
        for(Pitanje temp :pitanja){
            Double x2=0.0;
            for(Map.Entry<Pitanje,ArrayList<String>> z: odgovor.entrySet()){
                if(z.getKey().equals(temp)){
                    x2= temp.izracunajPoene(z.getValue(),sistemBodovanja);
                    break;
                }
            }
            pomoc.put(temp,x2);
            total=total+x2;
        }
        rezultatKviza.setBodovi(pomoc);
        rezultatKviza.setTotal(total);
        return rezultatKviza;
    }
}
