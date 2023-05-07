package extra_gyakorlo_feladat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Aramkor {
    private final ArrayList<Alkatresz> alkatreszek ;

    public Aramkor() {
        this.alkatreszek = new ArrayList<>();
    }

    public Aramkor(String fileName) {
        this.alkatreszek = new ArrayList<>();
                try (Scanner scanner = new Scanner(new File(fileName))) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.isEmpty()) {
                            continue;
                        }
                        String[] items = line.split(",");
                        if(items[0].trim().equals("Ellenallas")){
                            double ar = Double.parseDouble(items[1].trim());
                            double ertek = Double.parseDouble(items[2].trim());
                            addAlkatresz(new Ellenallas(ar,ertek));
                        }
                        else if(items[0].trim().equals("Kondenzator")){
                            double ar = Double.parseDouble(items[1].trim());
                            double ertek = Double.parseDouble(items[2].trim());
                            addAlkatresz(new Kondenzator(ar, ertek));
                        }
                        else if(items[0].trim().equals("Tranzisztor")) {
                            double ar = Double.parseDouble(items[1].trim());
                            String kod = items[2].trim();
                            addAlkatresz(new Tranzisztor(ar, kod));
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
    public void addAlkatresz(Alkatresz alkatresz){
        alkatreszek.add(alkatresz);
    }
    public void removeAlkatresz(Alkatresz alkatresz){
        alkatreszek.remove(alkatresz);
    }
    public int numOfAlkatresz(){
        return alkatreszek.size();
    }
    public double osszAr(){
        double sum = 0 ;
        for (Alkatresz alkatresz : alkatreszek) {
            sum += alkatresz.ar;
        }
        return sum;
    }
    public boolean keresAlkatresz( Alkatresz alkatresz){
        for (int i = 0; i < numOfAlkatresz(); i++) {
            if(alkatreszek.get(i).equals(alkatresz)){
                return true;
            }
        }
        return false;
    }
    public boolean csakEllenallasok(){
        for (int i = 0; i < numOfAlkatresz(); i++) {
            if(!(alkatreszek.get(i).toString().contains("Ellenallas"))){
                return false;
            }
        }
        return true;
    }
    public double eredoEllenallas(){
            double sum = 0;
        if (csakEllenallasok()) {
           for (int i = 0; i < numOfAlkatresz(); i++) {
                sum += ((Ellenallas) alkatreszek.get(i)).getErtek();
           }
           return sum;
        }
        else {
            return -1;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Áramkör tartalma:\n");
        for (Alkatresz alkatresz : this.alkatreszek) {
            sb.append(alkatresz.toString()).append("\n");
        }
        sb.append("Áramkör összár: ").append(this.osszAr());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aramkor that = (Aramkor) o;

        for (int i = 0; i < that.alkatreszek.size(); i++) {
            for (int j = 0; j < this.alkatreszek.size(); j++) {
                if (this.alkatreszek.get(i).equals(that.alkatreszek.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
}
