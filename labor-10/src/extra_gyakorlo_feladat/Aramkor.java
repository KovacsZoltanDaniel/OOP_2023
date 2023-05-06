package extra_gyakorlo_feladat;

import java.util.ArrayList;


public class Aramkor {
    private final ArrayList<Alkatresz> alkatreszek = new ArrayList<>();

    public Aramkor() {

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
