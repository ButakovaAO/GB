/**
 * Java Core. Homework 5
 * 
 * @author Butakova A.O.
 * 16.12.2021
 */

import java.util.*;
import java.io.*;

public class HomeWork5 {
    public static void main(String args[]) {
        // File input path
        System.out.println("Starting....");
        //File file = new File("C:\Users\Anast\OneDrive\Рабочий стол\GB\Java Core для тестировщиков\HomeWork5\HomeWork5.csv");
		File file = new File("src/HomeWork5.csv");
        try {
            FileWriter output = new FileWriter(file);
            CSVWriter write = new CSVWriter(output);

            // Header column value
            String[] header = { "ID", "Name", "Address", "Phone Number" };
            write.writeNext(header);
            // Value
            String[] data1 = { "1", "First Name", "Address1", "12345" };
            write.writeNext(data1);
            String[] data2 = { "2", "Second Name", "Address2", "123456" };
            write.writeNext(data2);
            String[] data3 = { "3", "Third Name", "Address3", "1234567" };
            write.writeNext(data3);
            write.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        }

        System.out.println("End.");
    }
}
