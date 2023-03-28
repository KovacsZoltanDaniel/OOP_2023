package labor5_evkozi_vizsga.src;

public class Termek {
    private int azonosito;
    private String elnevezes;
    private double beszerzesiAr;
    private double fogyasztoiAr;
    private int darab;

    public Termek(int azonosito, String elnevezes, double beszerzesiAr){
        this.azonosito = azonosito;
        this.elnevezes = elnevezes;
        this.beszerzesiAr = beszerzesiAr;
        this.fogyasztoiAr = beszerzesiAr;
    }

    public int getAzonosito() {
        return azonosito;
    }

    public String getElnevezes() {
        return elnevezes;
    }

    public double getBeszerzesiAr() {
        return beszerzesiAr;
    }

    public double getFogyasztoiAr() {
        return fogyasztoiAr;
    }

    public void setArres(double szazalek){

        this.fogyasztoiAr = (beszerzesiAr*szazalek)/100 + beszerzesiAr;
    }

    public void setDarab(int darab) {
        this.darab += darab;
    }

    @Override
    public String toString() {
        return "Termek{" +
                "azonosito=" + azonosito +
                ", elnevezes='" + elnevezes + '\'' +
                ", beszerzesiAr=" + beszerzesiAr +
                ", fogyasztoiAr=" + fogyasztoiAr + " darab: " + darab +
                '}' ;
    }
}
