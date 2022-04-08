import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FormatNamesm {
	public static void main(String[] args) {
    	String currentLine = ""; // variable for storing the line currently read by scanner
    	String name = ""; // variable for storing the name in the current line
    	String date = ""; // variable for storing the date in the current line
    	ArrayList<String> names = new ArrayList<String>(); // ArrayList for the formatted names
    	ArrayList<String> dates = new ArrayList<String>(); // ArrayList for the formatted date
    	
    	try {
    	String inputFileName = args[0];
    	System.out.println("Input from file " + inputFileName);
    	File inputFile = new File(inputFileName);
        Scanner inFile = new Scanner(inputFile);
        
        while (inFile.hasNextLine()) {
            currentLine = inFile.nextLine(); // current line read from file
        	String[] splitData = currentLine.split("(?=\\d)(?<!\\d)"); // splits the string into a name and a date string, stores in an array
        	name = splitData[0];
        	date = splitData[1];
            
        	if (args.length == 3 && args[2].compareTo("-u") == 0) { // if there is a -u flag
        		names.add(allCaps(name)); // calls the method for turning names to upper case
        		dates.add(formatDate(date)); // calls for a method that formats the date
        	}
        	
        	else {
        	names.add(formatName(name)); // calls a method that turns the first letters of the names to upper case
        	dates.add(formatDate(date)); // calls for a method that formats the date
        	}
        }
        inFile.close();
    	}
    	catch (IOException e) {
    	System.err.println("IOException: " + e.getMessage() + "not found");
    	}
    	
    	try {
    	String filename = args[1];
    	System.out.println("Writing to file " + filename);
    	File outFile = new File(filename);
    	PrintWriter writer = new PrintWriter(filename);
    	
    	for (int i = 0; i < names.size(); i++) {
        	writer.printf("%-20s%20s\n", names.get(i), dates.get(i)); // writes the data to the file
    	}

    	writer.close();
    	}
    	catch (FileNotFoundException e) {
    	System.err.println("FileNotFoundException: " + e.getMessage() + " not openable");
    	System.exit(0); 
    	}
    } // main
    
	public static String formatName(String name) {
    	
    	String splitName[] = name.split(" "); // splits the name into first and last names for easier capitalization
    	String upperCase = "";
    
    	for (int i = 0; i < splitName.length; i++) {
    		if (splitName[i].length() == 1) {
    			splitName[i] = splitName[i] + ".";
    		}
    		
    		char firstLetter = splitName[i].charAt(0); // gets the first letter of each array element
    		char big = Character.toUpperCase(firstLetter); // capitalizes the first letter
    		upperCase += big + splitName[i].substring(1) + " "; // adds the capitalized first and last name back together
    	}
    	upperCase = upperCase.trim(); // removes the trailing space behind the name
		
		return upperCase;
	}
	
	public static String formatDate(String date) {
		date = date.replaceAll("(\\d{2})(\\d{2})(\\d{4})", "$1/$2/$3"); // adds slashes to the dates
		return date;
	}
	
	public static String allCaps (String data) {
		String splitName[] = data.split(" "); // splits the name into first and last names for easier capitalization
		String upperCase = "";
	    
    	for (int i = 0; i < splitName.length; i++) {
    		if (splitName[i].length() == 1) { // if a middle initial is found
    			splitName[i] = splitName[i] + "."; // adds a period after the middle name
    		}
    		upperCase += splitName[i] +  " "; // adds the capitalized first and last name back together
    	}
    	upperCase = upperCase.trim(); // removes the trailing space behind the name
		
		data = upperCase.toUpperCase(); // turns the data to all upper case
		return data;
	}
}
