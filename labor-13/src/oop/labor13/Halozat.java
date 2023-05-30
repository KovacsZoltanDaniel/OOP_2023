package oop.labor13;

import java.util.ArrayList;
import java.util.List;

public class Halozat {

    private List<Eszkoz> eszkozok;

    public Halozat() {
        this.eszkozok = new ArrayList<>();
    }

    public boolean teleVanE() {
        return eszkozok.size() >= 256;
    }

    public int elsoSzabad() {
        for (int i = 0; i < 256; i++) {
            boolean foglalt = false;
            for (Eszkoz eszkoz : eszkozok) {
                if (eszkoz.getIP() == i) {
                    foglalt = true;
                    break;
                }
            }
            if (!foglalt) {
                return i;
            }
        }
        return -1;
    }
    public void kapcsolodas(Eszkoz eszkoz) {
        if (teleVanE()) {
            System.out.println("A hálózat megtelt, nem lehet új eszközt csatlakoztatni.");
        } else {
            int ip = elsoSzabad();
            eszkoz.setIP(ip);
            eszkozok.add(eszkoz);
            System.out.println("Az eszköz sikeresen csatlakoztatva. IP: " + ip);
        }
    }

    public void levalasztas(Eszkoz eszkoz) {
        if (!eszkozok.contains(eszkoz)) {
            System.out.println("Az eszköz nem található a tárolóban.");
            return;
        }

        eszkoz.setIP(-1);
        eszkozok.remove(eszkoz);
        System.out.println("Az eszköz sikeresen leválasztva.");
    }

    public void listazas() {
        for (Eszkoz eszkoz : eszkozok) {
            System.out.println(eszkoz.toString());
        }
    }

    public void listazMobil() {
        for (Eszkoz eszkoz : eszkozok) {
            if (eszkoz instanceof Mobil) {
                System.out.println(eszkoz.toString());
            }
        }
    }

}
