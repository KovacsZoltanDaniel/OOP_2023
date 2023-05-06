package extra_gyakorlo_feladat;

import java.util.ArrayList;


public class Aramkor {
    private ArrayList<Alkatresz> alkatreszek = new ArrayList<>();;

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
        for (int i = 0; i < alkatreszek.size(); i++) {
            sum += alkatreszek.get(i).ar;
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
            if((!alkatreszek.get(i).toString().contains("Ellenalas"))){
                return false;
            }
        }
        return true;
    }
    public double eredoEllenallas(){
        if (csakEllenallasok()) {
            double sum = 0;
            for (int i = 0; i < numOfAlkatresz(); i++) {
                Alkatresz copy = alkatreszek.get(i);
                sum +=
            }
            return sum;
        } else {
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
        if (this.numOfAlkatresz() != that.numOfAlkatresz()) {
            return false;
        }
        for (int i = 0; i < this.numOfAlkatresz(); i++) {
            if (!this.alkatreszek.get(i).equals(that.alkatreszek.get(i))) {
                return false;
            }
        }
        return true;
    }


}
