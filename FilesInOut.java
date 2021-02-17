import java.io.*; //this package contains all the classes sed in file processing
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
public class FilesInOut {

    public static void main(String[] args) {
        // Replace this with statements to set the file name (input) and file name (output).
        // Initially it will be easier to hardcode suitable file names.

        //creates an input file and checks to see if it already exists
        try {
            File inputFile = new File ("input.txt");
            if (inputFile.createNewFile()){
                System.out.println("File " + inputFile.getName() + " created in: "+ inputFile.getAbsolutePath());
            } else
                System.out.println("inputFile already exists");
        } catch (IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        //creates an output file and checks to see if it already exists
        try {
            File outputFile = new File ("formatted.txt");
            if (outputFile.createNewFile()){
                System.out.println("File " + outputFile.getName() + " created in: "+ outputFile.getAbsolutePath());
            } else
                System.out.println("outputFile already exists");
        } catch (IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        // Set up a new Scanner to read the input file.
        // Processing line by line would be sensible here.
        // Initially, echo the text to System.out to check you are reading correctly.
        // Then add code to modify the text to the output format.



        // Set up a new PrintWriter to write the output file.
        // Add suitable code into the above processing (because you need to do this line by line also.
        // That is, read a line, write a line, loop.
//        System.out.println("supply filename for input:");
//        try {
//            inputFile= in.nextLine();
//            //File inputFile = new File(inputFile) ;
//            Scanner inFile = new Scanner(inputFile);
//        } catch (IOException e) {
//            System.err.println("IOException: " + e.getMessage() + “ not found”);
//        }
//
//        System.out.println("supply filename for output:");
//        try {
//            outputFile = new PrintWriter(filename);
//        } catch (FileNotFoundException e) {
//            System.err.println("FileNotFoundException: " + e.getMessage() + " not openable");
//            System.exit(0);
//        }

        // Finally, add code to read the filenames as arguments from the command line.


    } // main

} // FilesInOut
