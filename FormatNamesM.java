import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FormatNamesM {

    public static void main(String[] args) throws FileNotFoundException
    {
        
        // Construct Scanner and PrinterWriter objects for reading and writing
        
    	
    	//File inputFile = new File("inputm.txt");
    	//File outputFile = new File ("formattedm.txt");
    	//Scanner console = new Scanner(System.in);
    	//String inputFileName = console.next();
    	//String outputFileName = console.next();
    	
    	boolean uFlag = false;
		String inputFileName = "";
		String outputFileName = "";
    	if (args.length == 3) {
    		if (args[0].equals("-u")) {
    			uFlag = true;
    		}
    		inputFileName = args[1];
    		outputFileName = args[2];
    	} else if (args.length == 2) { 
    		inputFileName = args[0];
    		outputFileName = args[1];
    	}
    	
    	File inputFile = new File(inputFileName);
    	File outputFile = new File(outputFileName);
    	
        Scanner in = new Scanner (inputFile);
        PrintWriter out = new PrintWriter(outputFile);
        
        // Read the input and write the output
        
        
        while (in.hasNextLine())
        {
        	String input = in.nextLine();
        	int i = 0;
        	while (!Character.isDigit(input.charAt(i))) {
        		i++;
        	}
        	String personName = input.substring(0,i);
        	String birthDate = input.substring(i);
        	personName = personName.trim();
        	if (uFlag) {
        		personName = Formatter.titleCaseConverterMU(personName);
        	} else {
        		personName = Formatter.titleCaseConverterM(personName);
        	}
        	birthDate = birthDate.trim();
            birthDate = Formatter.dateConverter(birthDate);
            
            out.printf("%-22s %10s\n", personName, birthDate);
        }
        in.close();
        out.close();
        
        
    	// Replace this with statements to set the file name (input) and file name (output).
        // Initially it will be easier to hardcode suitable file names.

        // Set up a new Scanner to read the input file.
        // Processing line by line would be sensible here.
        // Initially, echo the text to System.out to check you are reading correctly.
        // Then add code to modify the text to the output format.

        // Set up a new PrintWriter to write the output file.
        // Add suitable code into the above processing (because you need to do this line by line also.
        // That is, read a line, write a line, loop.

        // Finally, add code to read the filenames as arguments from the command line.

    } // main

} // FilesInOut
