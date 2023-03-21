package oop.labor02;

public class DateUtil {
    public static boolean leapYear(int year){
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }
    public static boolean isValidDate(int year, int month, int day){
        if(year > 0){
            if(month >= 1 && month <= 12){
                if(month == 2 && leapYear(year)){
                    return (day >= 1 && day <= 29);
                }
                else if(month == 2 && !leapYear(year)){
                    return (day >= 1 && day <= 28);
                }
                else if(day >= 1 && month % 2 == 0 && day <= 30){
                    return true;
                }
                else return (day >= 1 && month % 2 != 0 && day <= 31);
            }
        }
        return false;
    }
}
