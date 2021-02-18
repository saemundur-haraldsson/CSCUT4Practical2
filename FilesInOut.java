import java.io.*; //this package contains all the classes sed in file processing
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        //creates an input file and checks to see if it already exists
        try {
            File inputFile = new File("inputm.txt");
            if (inputFile.createNewFile()) {
                System.out.println("File " + inputFile.getName() + " created in: " + inputFile.getAbsolutePath());
            } else
                System.out.println("inputFile already exists");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        //creates an output file and checks to see if it already exists
        try {
            File outputFile = new File("formattedTCm4.txt");
            if (outputFile.createNewFile()) {
                System.out.println("File " + outputFile.getName() + " created in: " + outputFile.getAbsolutePath());
            } else
                System.out.println("outputFile already exists");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        // Initially, echo the text to System.out to check you are reading correctly.
        // Then add code to modify the text to the output format.

        String inFileName = "";
        String upperCaseFormat = "";
        String titleCaseFormat = "";
        String outFileName = "";

        if (args[0].equals("-u")) {
            upperCaseFormat = args[0];
            inFileName = args[1];
            outFileName = args[2];
        }
        else if (args[0].equals("-t")){
            titleCaseFormat = args[0];
            inFileName = args[1];
            outFileName = args[2];
        }
        else{
            inFileName = args[0];
            outFileName = args[1];
        }
        try {
            File inputFile = new File(inFileName);
            Scanner inFile = new Scanner(inputFile);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile)); //reads text fm a char-input stream
            String line = reader.readLine();
            Date d = null;
            while (line != null) { //separating dates from names
                SimpleDateFormat origFormat = new SimpleDateFormat("ddMMyyyy"); //formats what is currently in the file
                SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy"); //changes it to the format we want
                String value = line.replaceAll("[^0-9]", ""); //selects the date and removes any int (regular expression pattern finding)
                d = origFormat.parse(value); //parse date fm original to new format
                String name = line.replaceAll("[\\d.]", ""); //selects the name and erases any non-int (regular expression pattern finding)
                if (upperCaseFormat.equals("-u")) { //if the flag is '-u' then changes name to UPPER CASE
                    name = name.toUpperCase();
                }
                if (titleCaseFormat.equals("-t")){ //if the flag is '-t' then changes the name to TITLE CASE
                    String[] names = inFile.nextLine().split("\\s"); //splits the text at blank space
                    int numOfNames = names.length; //length of the array containing the names
                    if (numOfNames == 3) { //if there are 3 names in the array:
                        String fname = names[0];
                        String mname = names[1];
                        String sname = names[2];
                        fname = fname.substring(0, 1).toUpperCase() + fname.substring(1); //capitalises only the first character in the string
                        mname = mname.toUpperCase() + ".";
                        sname = sname.substring(0, 1).toUpperCase() + sname.substring(1); //capitalises only the first character in the string
                        name = fname + " " + mname + " " + sname + " "; //concatenates the 3 names together
                    } else {
                        String fname = names[0];
                        String sname = names[1];
                        fname = fname.substring(0, 1).toUpperCase() + fname.substring(1); //capitalises only the first character in the string
                        sname = sname.substring(0, 1).toUpperCase() + sname.substring(1);//capitalises only the first character in the string
                        name = fname + " " + sname + " "; //concatenates the 2 names together
                    }
                }
                appendData(name, outFileName, newFormat, d); //append the data to the new file
                line = reader.readLine(); //go to the nest line in the file
            }
        } catch (IOException | ParseException e) {
            System.err.println("IOException: " + e.getMessage() + "not found");
        }
    }
    public static void appendData(String name, String outFileName, SimpleDateFormat newFormat, Date d){
        try {
            FileWriter fw = new FileWriter(outFileName, true); //true will append new data
            fw.write(name + newFormat.format(d)); //appends the string to the file
            fw.write("\n"); //new line
            fw.close();
            //line = reader.readLine();
        } catch (IOException e){
            System.err.println("IOException: " + e.getMessage());
        }
        // Set up a new PrintWriter to write the output file.
        // Add suitable code into the above processing (because you need to do this line by line also.
        // That is, read a line, write a line, loop.
//        try {
//            File inputFile = new File(inputFileName);
//            if(inputFile.exists() ==false || inputFile.isDirectory() == true) {
//                System.out.println("Please provide a valid input file name.");
//                return;
//            }
//            Scanner sc = new Scanner(inputFile);
//            File outputFile = new File (outputFileName);
//            if(outputFile.exists() ==true && outputFile.isDirectory() == true) {
//                System.out.println("Please provide a valid output file name: A directory with same name exist");
//                return;
//            }
//            PrintWriter printWriter = new PrintWriter (outputFile);


            // Finally, add code to read the filenames as arguments from the command line.


    } // main

} // FilesInOut
