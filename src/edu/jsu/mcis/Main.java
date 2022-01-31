package edu.jsu.mcis;

import java.io.*;

public class Main {
    
    /*
    
        This is a simple program for testing the "csvToJson()" and "jsonToCsv()"
        conversion methods in the Converter class.  You should not need to make
        any modifications to this file; instead, complete the conversion methods
        in the Converter class, and run the unit tests in the ConerterTest.java
        unit test file to check your work.

    */
    
    public static void main(String[] args) {
        
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        
        // Get CSV Data
        
        StringBuilder csvFile = new StringBuilder();
        
        try {
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(loader.getResourceAsStream("resources" + File.separator + "grades.csv")));
            String line;
            
            while((line = reader.readLine()) != null) {
                csvFile.append(line).append('\n');
            }
            
        }
        catch(IOException e) { e.printStackTrace(); }
        
        String csvFileString = csvFile.toString().trim();
        
        // Get JSON Data
        
        StringBuilder jsonFile = new StringBuilder();
        
        try {
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(loader.getResourceAsStream("resources" + File.separator + "grades.json")));            
            String line;
            
            while((line = reader.readLine()) != null) {
                jsonFile.append(line).append('\n');
            }
            
        }
        catch(IOException e) { e.printStackTrace(); }
        
        String jsonFileString = jsonFile.toString().trim();
        
        // Convert CSV to JSON; Print Results to Console
        
        System.out.println("CONVERSION RESULTS (CSV to JSON)");
        System.out.println("================================");

        String json = Converter.csvToJson(csvFileString);
        System.out.println(json);
        
        // Convert JSON to CSV; Print Results to Console
        
        System.out.println("\nCONVERSION RESULTS (JSON to CSV)");
        System.out.println("================================");
        
        String csv = Converter.jsonToCsv(jsonFileString);
        System.out.println(csv);
		
    }
    
}