package labor5_evkozi_vizsga.src;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        Termek termek1 = new Termek(10, "alma", 5);
        termek1.setArres(10);
        System.out.println(termek1);
        System.out.println();
        ArrayList<Termek> termekek = Raktar.readFromTermekektxtFile("termekek.txt");
        /*for (Termek termek : termekek) {
            System.out.println(termek);
        }*/
        Raktar.readFromRaktarTxtFile("raktar.txt", termekek);
        Raktar.printTermekek(termekek);
    }
}