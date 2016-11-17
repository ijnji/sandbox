import java.io.*;
import java.util.*;

class RotateMatrix {
    public static void main(String[] args) {
        int[][] m;
        int size;

        // 5x5
        m = new int[][] {
            {1, 2, 3, 4 , 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };
        printMatrix(m);
        rotateMatrix(m);
    }
    static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int val : row) {
                System.out.print(val + ", ");
            }
            System.out.println();
        }
    }
    static void rotateMatrix(int[][] m) {

    }
}