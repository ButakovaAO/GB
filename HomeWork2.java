/**
 * Java 1. Homework 2
 * 
 * @author Butakova A.O.
 * @version 13.10.2021
 */
class HomeWork2 {

    public static void main(String[] args) {
        System.out.println(within10and20(5, 15));
        System.out.println(within10and20(-10, 3));
        System.out.println("");
        isPositiveOrNegative(8);
        System.out.println("");
        System.out.println(isNegative(0));
        System.out.println(isNegative(-1));
        System.out.println("");
        printWordNTimes("Homework 2",5);
        System.out.println("");
        System.out.println(isLeapYear(2021));
        System.out.println(isLeapYear(2020));
        System.out.println(isLeapYear(2100));
        System.out.println(isLeapYear(2400));
    }

    static boolean within10and20(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    static void isPositiveOrNegative(int c) {
        System.out.println(c >= 0? "Положительное" : "Отрицательное");
    }

    static boolean isNegative(int d) {
        return d < 0;
    }

    static void printWordNTimes(String word, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(word);
        }
    }
	
    static boolean isLeapYear(int y) {
        return y % 4 == 0 && y % 100 != 0 || y % 400 == 0;
    }
}

