package oop.labor02;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println(DateUtil.isValidDate(2000, 2, 29));
        System.out.println(!DateUtil.isValidDate(2000, 2, 30));
        System.out.println(!DateUtil.isValidDate(1900, 2, 29));
        System.out.println(DateUtil.isValidDate(1900, 2, 28));
        System.out.println(!DateUtil.isValidDate(-1900, 2, 28));
        System.out.println(!DateUtil.isValidDate(0, 2, 28));
        System.out.println(!DateUtil.isValidDate(2021, 2, 29));
        System.out.println(DateUtil.isValidDate(2020, 2, 29));
        System.out.println(!DateUtil.isValidDate(2020, 1, 32));
        System.out.println(!DateUtil.isValidDate(2020, 1, 0));
        System.out.println(!DateUtil.isValidDate(2020, 0, 0));
        System.out.println(!DateUtil.isValidDate(2020, 4, 31));
        System.out.println(DateUtil.isValidDate(2020, 1, 31));

        MyDate date1 = new MyDate(2023, 3, 1);
        System.out.println(date1);

        // b.
        Random rand = new Random();


        MyDate[] dates = new MyDate[1000];
        int invalidDates = 0;
        int valid = 0;
        for (int i = 0; i < dates.length; i++) {

            int year = 1 + rand.nextInt(2023);
            int month = 1 + rand.nextInt(12);
            int day = 1 + rand.nextInt(31);

            dates[i] = new MyDate(year, month, day);

            if (!DateUtil.isValidDate(dates[i].getYear(), dates[i].getMonth(), dates[i].getDay())) {
                invalidDates++;
            }
            else valid++;
        }
        for (int i = 0; i < dates.length; i++) {
            if (DateUtil.isValidDate(dates[i].getYear(), dates[i].getMonth(), dates[i].getDay())){
                System.out.println(dates[i]);
            }
        }
        System.out.println("number of invalid dates: "+invalidDates);
        System.out.println("number of valid dates: "+valid);

    }
}
