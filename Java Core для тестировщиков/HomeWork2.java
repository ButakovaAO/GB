/**
 * Java Core. Homework 2
 * 
 * @author Butakova A.O.
 * 08.12.2021
 */
 

public class HomeWork2 {

    public static void main(String[] args) {

    String[][] arr1 = new String[][]{{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}};
    String[][] arr2 = new String[][]{{"1", "1", "!", "1"}, {"b", "2", "%", "2"}, {"c", "3", "3", "3"}, {"d", "4", "4", "4"}};
    String[][] arr3 = new String[][]{{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4", "4"}};	
    execMethod(arr1);
    System.out.println();
    execMethod(arr2);
    System.out.println();
    execMethod(arr3);
    }

    public static void execMethod (String [][] arr){
        try {
            try {
                int result = method(arr);
                System.out.println(result);	
            } catch(MyArraySizeException e) {
                System.out.println("Некорректный размер массива.");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Неправильное значение элемента массива.");
            System.out.println("Ошибка в ячейке: " + e.i + "x" + e.j);
        }
    }

    public static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
           super(message);
       }
    }

    public static class MyArrayDataException extends Exception {
        public int i;
        public int j;
        MyArrayDataException(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static int method(String [][] arr) throws MyArraySizeException, MyArrayDataException {
    int count = 0;
    if (arr.length != 4) {
        throw new MyArraySizeException("Выскочил за массив");
    }
    for (int i = 0; i < arr.length; i++) {
        if (arr[i].length != 4) {
            throw new MyArraySizeException("Перебор, надо меньше");
        }
        for (int j = 0; j < arr[i].length; j++) {
            try {
                count = count + Integer.parseInt(arr[i][j]);
            }
			catch (NumberFormatException e) { 
                throw new MyArrayDataException(i, j);
            }
        }
    }
    return count;
    }
}