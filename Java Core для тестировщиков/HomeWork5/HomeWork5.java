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
import java.io.BufferedReader;

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
	
	ReadCSV.run();
    }
	
    public class ReadCSV {
 
    public void main(String[] args) {
 
	ReadCSV obj = new ReadCSV();
	obj.run();
 
  }
 
  public static run() {
 
	String csvFile = "HomeWork5.csv";
	BufferedReader br = null;
	String line = "";
	String csvSplitBy = ";";
 
	try {
 
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
 
		     
			String[] text = line.split(csvSplitBy);
 
			System.out.println("Value 1 = " + text[1] 
                                 + " , value 2 =" + text[2] + ", value 3 ="+ text[3]);
 
		}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
	System.out.println("Done");
  }
 
}
}