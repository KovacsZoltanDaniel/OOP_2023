package lab4_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MyArray {
    private int length;
    private double[] elements;

    public  MyArray(int length){
        this.elements = new double[length];
        this.length = length;
    }
    public MyArray(double[] array ){
        this.elements = Arrays.copyOf(array, array.length);
    }
    public MyArray(MyArray array){
        this.elements = Arrays.copyOf(array.elements, array.elements.length);
    }
    public MyArray(String fileName){
        try (Scanner scanner = new Scanner(new File(fileName))) {
                String line = scanner.nextLine();
                String[] items = line.split(" ");
                length = Integer.parseInt(items[0]);
                line = scanner.nextLine();
                items = line.split(" ");
                elements = new double[length];
                for (int i = 0; i < this.length; i++) {
                    elements[i] = Double.parseDouble(items[i]);
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void fillRandom(double a, double b){
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            elements[i] = random.nextDouble()*(b-a)+a;
        }
    }
public void print(String array){
    DecimalFormat df = new DecimalFormat("0.00");
    System.out.println();
    System.out.print(array + ": ");
    for (double element : elements) {
        System.out.print(df.format(element) + " ");
    }
}
public double mean(){
        double total = 0;
    for (double element : elements) {
        total += element;
    }
    return total / elements.length;
}
public double stddev(){
        double sum = 0;
        double mean = mean();
        for (double element : elements) {
        sum += Math.pow(element- mean, 2);
    }
    return Math.sqrt(sum/elements.length);
}
public void sort(){
        Arrays.sort(elements);
}
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return Arrays.toString(df.format(elements).toCharArray());
    }
}
