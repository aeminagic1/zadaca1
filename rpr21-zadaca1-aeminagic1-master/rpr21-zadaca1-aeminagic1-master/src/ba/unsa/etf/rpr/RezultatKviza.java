package ba.unsa.etf.rpr;

import java.util.HashMap;
import java.util.Map;

public class RezultatKviza {
    private Kviz kviz;
    private double total;
    private Map<Pitanje,Double> bodovi;
    public RezultatKviza(Kviz kviz){
        this.kviz=kviz;
        bodovi=new HashMap<>();
        total=0;
    }

    public Kviz getKviz() {
        return kviz;
    }

    public double getTotal() {
        return total;
    }

    public Map<Pitanje, Double> getBodovi() {
        return bodovi;
    }

    public void setKviz(Kviz kviz) {
        this.kviz = kviz;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setBodovi(Map<Pitanje, Double> bodovi) {
        this.bodovi = bodovi;
    }

    @Override
    public String toString() {
        String str;
        str ="Na kvizu \""+kviz.getNaziv()+"\" ostvarili ste ukupno ";
        str = str +(total+" poena. Raspored po pitanjima:");
        for(Map.Entry<Pitanje, Double> b:bodovi.entrySet()){
            str = str +("\n"+b.getKey().getTekst()+" - "+b.getValue().toString()+"b");
        }
        return str;
    }
}
