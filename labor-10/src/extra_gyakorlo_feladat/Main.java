package extra_gyakorlo_feladat;

public class Main {
    public static void main(String[] args) {
        Aramkor aramkor = new Aramkor();
        Kondenzator kondenzator1 = new Kondenzator(20,100);
        Kondenzator kondenzator2 = new Kondenzator(30, 200);
        Ellenallas ellenallas1 = new Ellenallas(18,220);
        Ellenallas ellenallas2 = new Ellenallas(15, 230);
        Tranzisztor tranzisztor1 = new Tranzisztor(22,"PNP");
        Tranzisztor tranzisztor2 = new Tranzisztor(23,"NPN");

        aramkor.addAlkatresz(kondenzator1);
        aramkor.addAlkatresz(kondenzator2);
        aramkor.addAlkatresz(ellenallas1);
        aramkor.addAlkatresz(ellenallas2);
        aramkor.addAlkatresz(tranzisztor1);
        aramkor.addAlkatresz(tranzisztor2);

        System.out.println(aramkor);

        aramkor.removeAlkatresz(kondenzator2);

        System.out.println();
        System.out.println(aramkor);

        System.out.println();
        System.out.println("Aramkor kereses " + tranzisztor1 + "  " + aramkor.keresAlkatresz(tranzisztor1));

        System.out.println();
        System.out.println("Csak ellenallasokbol all: " + aramkor.csakEllenallasok());

        System.out.println("Eredo ellenallas : " + aramkor.eredoEllenallas());

        Aramkor readFromFile = new Aramkor("aramkor.csv");
        System.out.println();
        System.out.println(readFromFile);
    }
}
