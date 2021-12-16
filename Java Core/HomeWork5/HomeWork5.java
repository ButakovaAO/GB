/**
 * Java Core. Homework 5
 * 
 * @author Butakova A.O.
 * 16.12.2021
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.IOException;

public class HomeWork5 {
     public static void main(String[] args) {

    try (PrintWriter writer = new PrintWriter(new File("HomeWork5.csv"))) {

        StringBuilder sb = new StringBuilder();
        sb.append("Value 1");
        sb.append(';');
        sb.append("Value 2");
        sb.append(';');
        sb.append("Value 3");
        sb.append('\n');

        sb.append("100");
        sb.append(';');
        sb.append("200");
        sb.append(';');
        sb.append("123");
        sb.append('\n');

        sb.append("300");
        sb.append(';');
        sb.append("400");
        sb.append(';');
        sb.append("500");
        sb.append('\n');

        writer.write(sb.toString());

        System.out.println("done!");

    } catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
    }
    }
}