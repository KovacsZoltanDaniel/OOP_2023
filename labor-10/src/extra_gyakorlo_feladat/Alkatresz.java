package extra_gyakorlo_feladat;

abstract class Alkatresz {
    protected double ar;

    protected Alkatresz(double ar) {
        this.ar = ar;
    }

    @Override
    public String toString() {
        return "Alkatresz{" +
                "ar=" + ar +
                '}';
    }
}
