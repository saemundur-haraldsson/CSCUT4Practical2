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
public class FilesInOut {

    public static void main(String[] args) {
        // Replace this with statements to set the file name (input) and file name (output).
        // Initially it will be easier to hardcode suitable file names.
        File input = new File("input.txt");
        PrintWriter out = null;
        try {
            out = new PrintWriter("output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Set up a new Scanner to read the input file.
        // Processing line by line would be sensible here.
        // Initially, echo the text to System.out to check you are reading correctly.
        // Then add code to modify the text to the output format.
        Scanner in = null;
        try {
            in = new Scanner(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //While there are more lines, format the lines and add the formatted lines to the output
        while(in.hasNext())
        {
            out.println(in.nextLine());
            System.out.println(in.nextLine());
        }
        //Used to get last line
        out.println(in.nextLine());
        //Closing the scanner and the printwriter
        in.close();
        out.close();

        // Set up a new PrintWriter to write the output file.
        // Add suitable code into the above processing (because you need to do this line by line also.
        // That is, read a line, write a line, loop.



        // Finally, add code to read the filenames as arguments from the command line.


    } // main

} // FilesInOut
