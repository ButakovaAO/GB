/**
 * Java 1. Homework 3
 * 
 * @author Butakova A.O.
 * @version 18.10.2021
 */
 import java.util.Arrays;
 
class HomeWork3 {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        arrayInverter();
        System.out.println();
        System.out.println("Задание 2");
        sequentialArray();
        System.out.println();
        System.out.println("Задание 3");
        changeArray();
        System.out.println();
        System.out.println("Задание 4");
        diagonalArray();
        System.out.println();
        System.out.println("Задание 5");
        initialValueArray(8, 5);
        initialValueArray(3, -5);
    }

    static void arrayInverter() {
        int[] arr = { 1, 1, 1, 0, 0, 1 };
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0)? 1 : 0;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void sequentialArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void changeArray() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void diagonalArray() {
        int[][] arr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = (i == j || j == (4 - i - 1))? 1 : 0;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void initialValueArray(int len,int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
    }
}

