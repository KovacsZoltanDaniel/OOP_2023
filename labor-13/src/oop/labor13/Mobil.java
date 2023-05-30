package oop.labor13;

public class Mobil extends Eszkoz{
    private boolean Sim;

    public Mobil(String oprendszer, boolean Sim) {
        super(oprendszer);
        this.Sim = Sim;
    }

    public boolean isSim() {
        return Sim;
    }

    @Override
    public String toString() {
        return "Mobil{" +
                "Sim=" + Sim +
                '}';
    }

    public void setSim(boolean sim) {
        Sim = sim;
    }
}
