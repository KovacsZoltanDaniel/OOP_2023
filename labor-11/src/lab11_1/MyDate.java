package lab11_1;

public class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day){
        if(DateUtil.isValidDate(year,month,day)){
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return
                "year= " + year +
                " month= " + month +
                " day= " + day ;
    }

    @Override
    public int compareTo( MyDate that) {
        if(this.year != that.year){
            return Integer.compare(this.year, that.year); //visszateri 1 et vagy -1 et attol fugg melyik nagyobb
        }
        if(this.month != that.month){
            return Integer.compare(this.month, that.month);
        }
        return Integer.compare(this.day, that.day);
    }
}
