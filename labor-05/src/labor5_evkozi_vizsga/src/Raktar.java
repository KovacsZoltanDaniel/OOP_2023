package labor5_evkozi_vizsga.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Raktar {


    public static ArrayList<Termek> readFromTermekektxtFile(String fileName) {
        ArrayList<Termek> termekek = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int i = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(" ");
                int azonosito = Integer.parseInt(items[0].trim());
                String elnevezes = items[1].trim();
                double beszerzesiAr = Double.parseDouble(items[2].trim());
                double szazalek = Double.parseDouble(items[3].trim());
                termekek.add(new Termek(azonosito, elnevezes, beszerzesiAr));
                termekek.get(i).setArres(szazalek);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return termekek;
    }

    public static void readFromRaktarTxtFile(String fileName, ArrayList<Termek> termekek) {
        int hibasAzonositok = 0;
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                int flag = 0;
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(" ");
                for (Termek termek : termekek) {
                    if (termek.getAzonosito() == Integer.parseInt(items[0].trim())) {
                        termek.setDarab(Integer.parseInt(items[1].trim()));
                        flag = 1;
                    }
                }
                if (flag == 0) {
                    hibasAzonositok++;
                }
            }
            System.out.println("a hibas azonositok szama: " + hibasAzonositok);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printTermekek(ArrayList<Termek> termekek) {
        for (Termek termek : termekek) {
            System.out.println(termek);
        }
    }

    public static double osszBeszerzesiar(ArrayList<Termek> termekek) {
        double ossz = 0;
        for (Termek termek : termekek) {
            ossz += termek.getBeszerzesiAr()*termek.getDarab();
        }
        return ossz;
    }

    public static void kulonbseg(ArrayList<Termek> termekek) {
       //ArrayList<Termek> termeks = new ArrayList<>();
        double max = termekek.get(0).getFogyasztoiAr() - termekek.get(0).getBeszerzesiAr();
        for (int i = 1; i < termekek.size(); i++) {
            if (termekek.get(i).getFogyasztoiAr() - termekek.get(i).getBeszerzesiAr() > max) {
                max = termekek.get(i).getFogyasztoiAr() - termekek.get(i).getBeszerzesiAr();
            }
        }
        for (Termek termek : termekek) {
            if (max == termek.getFogyasztoiAr() - termek.getBeszerzesiAr()) {
                // termeks.get(i) = termekek.get(i);
                System.out.println(termek);
            }
        }
    }
}
