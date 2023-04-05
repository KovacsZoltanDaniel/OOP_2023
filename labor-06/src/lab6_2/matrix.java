package lab6_2;

import java.util.Arrays;
import java.util.Random;

public class matrix {
    private double[][] data;
    private int rows;
    private int columns;

    public matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];
    }
    public matrix(double[][] array){
        this.data = Arrays.copyOf(array, array.length);
    }
    public matrix(matrix array){
        this.data = Arrays.copyOf(array.data, array.data.length);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void fillRandom(double a, double b){
        Random random =  new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = random.nextDouble(b-a)+a;
            }
        }
    }
    public matrix addmatrix(matrix a, matrix b){
        //teszteles
        matrix sum = new matrix(a.rows,a.columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum.data[i][j] = a.data[i][j] + b.data[i][j];
            }
        }
        return sum;
    }
}
