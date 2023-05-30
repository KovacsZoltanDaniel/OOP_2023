package oop.labor13;

public class Eszkoz {
    private String oprendszer;
    private int IP = -1;

    public Eszkoz(String oprendszer) {
        this.oprendszer = oprendszer;
    }

    public String getOprendszer() {
        return oprendszer;
    }

    public void setOprendszer(String oprendszer) {
        this.oprendszer = oprendszer;
    }

    @Override
    public String toString() {
        return "Eszkoz{" +
                "oprendszer='" + oprendszer + '\'' +
                ", IP=" + IP +
                '}';
    }

    public int getIP() {
        return IP;
    }

    public void setIP(int IP) {
        this.IP = IP;
    }
}
