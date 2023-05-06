package extra_gyakorlo_feladat;

import java.util.Objects;

public class Kondenzator extends Alkatresz{
   private double ertek;

    public Kondenzator(double ar, double ertek) {
        super(ar);
        this.ertek = ertek;
    }

    @Override
    public String toString() {
        return "Kondenzator - ar: " + ar + ", ertek: " + ertek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kondenzator that = (Kondenzator) o;
        return Double.compare(this.ertek, that.ertek) == 0 && Double.compare(this.ar, that.ar) == 0;
    }

}
