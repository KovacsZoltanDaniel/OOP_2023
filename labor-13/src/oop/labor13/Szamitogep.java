package oop.labor13;

public class Szamitogep extends  Eszkoz{
    private double HDmeret;
    public Szamitogep(String oprendszer, double HDmeret) {
        super(oprendszer);
        this.HDmeret = HDmeret;
    }

    public double getHDmeret() {
        return HDmeret;
    }

    public void setHDmeret(double HDmeret) {
        this.HDmeret = HDmeret;
    }
}
