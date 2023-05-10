package lab11_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<MyDate> dates = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int month = random.nextInt(12);
            int day = random.nextInt(31);
            dates.add(new MyDate(2023, month, day));
        }
        for (MyDate date : dates) {
            System.out.println(date);
        }
        System.out.println("********");
        Collections.sort(dates);
        for (MyDate date : dates) {
            System.out.println(date);
        }
    }
}
