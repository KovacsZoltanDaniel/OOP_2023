package extra_gyakorlo_feladat;

import java.util.Objects;

public class Ellenallas extends Alkatresz{
    private double ertek;

    public Ellenallas(double ar, double ertek) {
        super(ar);
        this.ertek = ertek;
    }

    public double getErtek() {
        return ertek;
    }

    @Override
    public String toString() {
        return "Ellenallas: " + " ar " + ar + ", ertek: " + ertek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellenallas that = (Ellenallas) o;
        return Double.compare(this.ertek, that.ertek) == 0 && Double.compare(this.ar, that.ar) == 0;
    }

}
