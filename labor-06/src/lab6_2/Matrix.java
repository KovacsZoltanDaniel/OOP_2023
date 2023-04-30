package lab6_2;

import java.util.Random;

public class Matrix {
    private double[][] data;
    private int rows;
    private int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];
    }

    public Matrix(double[][] data) {
        this.rows = data.length;
        this.columns = data[0].length;
        this.data = data;
    }

    public Matrix(Matrix matrix) {
        this.rows = matrix.rows;
        this.columns = matrix.columns;
        this.data = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.data[i][j] = matrix.data[i][j];
            }
        }
    }

    public void fillRandom(double a, double b) {
        Random r = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = r.nextDouble() * (b - a) + a;
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%6.2f", data[i][j]);
            }
            System.out.println();
        }
    }

    public static Matrix add(Matrix matrix1, Matrix matrix2) {
        if (matrix1.rows == matrix2.rows && matrix1.columns == matrix2.columns) {
            Matrix resultMatrix = new Matrix(matrix1.rows, matrix1.columns);

            for (int i = 0; i < resultMatrix.rows; i++) {
                for (int j = 0; j < resultMatrix.columns; j++) {
                    resultMatrix.data[i][j] = matrix1.data[i][j] + matrix2.data[i][j];
                }
            }
            return resultMatrix;
        } else {
            System.out.println("Matrices should have the same dimension!");
            return null;
        }
    }

    public static Matrix multiply(Matrix matrix1, Matrix matrix2) {
        if (matrix1.columns != matrix2.rows) {
            System.out.println("Wrong dimensions!");
            return null;
        }
        Matrix productMatrix = new Matrix(matrix1.rows, matrix2.columns);
        for(int i = 0; i < matrix1.rows; i++) {
            for (int j = 0; j < matrix2.columns; j++) {
                for (int k = 0; k < matrix1.columns; k++) {
                    productMatrix.data[i][j] += matrix1.data[i][k] * matrix2.data[k][j];
                }
            }
        }
        return productMatrix;
    }

    public static Matrix transpose(Matrix matrix) {
        Matrix transposedMatrix = new Matrix(matrix.columns, matrix.rows);
        for (int i = 0; i < matrix.columns; i++) {
            for (int j = 0; j < matrix.rows; j++) {
                transposedMatrix.data[i][j] = matrix.data[j][i];
            }
        }
        return transposedMatrix;
    }
}
