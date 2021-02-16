import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class FormatNames {

    public static void main(String[] args)
    {
        
        // Variable declaration.
    	boolean uFlag = false;
		String inputFileName = "";
		String outputFileName = "";
    	Scanner in = null;
    	PrintWriter out = null;
    	
    	// Check the number of arguments being passed through the command line.
		switch(args.length) {
			case 3:
				// Check for -u flag.
	    		if (args[0].equals("-u")) {
	    			uFlag = true;
	    		}
	    		// Set the file names.
	    		inputFileName = args[1];
	    		outputFileName = args[2];
	    		break;
			case 2:
				// Set the file names.
	    		inputFileName = args[0];
	    		outputFileName = args[1];
	    		break;
		}
    	
		// Validate the input file.
		try {
			//  Construct Scanner object for reading.
			File inputFile = new File(inputFileName);
			in = new Scanner (inputFile);
		} catch (IOException e) {
			System.err.println("IOException: " + e.getMessage () + " not found.");
		}
		
		// Validate the output file.
		try {
			// Construct the PrintWriter object for writing.
	    	File outputFile = new File(outputFileName);
	        out = new PrintWriter(outputFile);
		} catch (FileNotFoundException e) {
    		System.err.println("FileNotFoundException: " + e.getMessage() + 
    				" not openable.");
    		System.exit(0);
		}
        
        // Read the input and write the output line by line.
        while (in.hasNextLine())
        {
        	// Read the unformatted line.
        	String input = in.nextLine();
        	
        	// Find the index of the first digit
        	int fdIndex = 0;
        	while (!Character.isDigit(input.charAt(fdIndex))) {
        		fdIndex++;
        	}
        	
        	// Split the line into name and birth date.
        	String personName = input.substring(0,fdIndex);
        	String birthDate = input.substring(fdIndex);
        	
        	// Trim all the whitespace at the end of the name.
        	personName = personName.trim();
        	
        	if (uFlag) {
        		// Format name with uFlag.
        		personName = Formatter.titleCaseConverterU(personName);	
        	} else {
        		// Format name.
        		personName = Formatter.titleCaseConverter(personName);
        	}
        	
        	// Format birth date.
            birthDate = Formatter.dateConverter(birthDate);
            
            // Output the formatted line.
            out.printf("%-19s %10s\n", personName, birthDate);
        }
        in.close();
        out.close();
    }

}
