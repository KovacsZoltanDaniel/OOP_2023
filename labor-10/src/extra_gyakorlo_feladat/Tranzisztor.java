package extra_gyakorlo_feladat;

public class Tranzisztor extends Alkatresz{
   private String kod;

   public Tranzisztor(double ar, String kod) {
      super(ar);
      this.kod = kod;
   }

   @Override
   public String toString() {
      return "Tranzisztor - ar: " + ar + ", kod: " + kod;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Tranzisztor that = (Tranzisztor) o;
      return this.kod.equals(that.kod) && Double.compare(this.ar, that.ar) == 0;
   }
}
