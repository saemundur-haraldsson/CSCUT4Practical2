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
            out.println( formatInput("-t", in.nextLine()) );
            //in.nextLine();
        }
        //Used to get last line
        //Closing the scanner and the printwriter
        in.close();
        out.close();

        // Set up a new PrintWriter to write the output file.
        // Add suitable code into the above processing (because you need to do this line by line also.
        // That is, read a line, write a line, loop.



        // Finally, add code to read the filenames as arguments from the command line.


    } // main

    static String formatInput(String flag, String input)
    {
        String formattedInput = input;
        switch(flag)
        {
            case "-u":
                formattedInput = toUpperCase(input);
                break;
            case "-t":
                formattedInput = toTitleCase(input);
                break;
            default:
                break;
        }
        formattedInput = formatDate(formattedInput);
        return formattedInput;
    }

    static String formatInput(String input)
    {
        String formattedInput = input;
        formattedInput = formatDate(formattedInput);
        return formattedInput;
    }

    static String formatDate(String input)
    {
        char[] charArray = input.toCharArray();
        char[] dateArray = new char[10];
        String output;
        boolean dateScanStarted = false;
        int dateIterator = 0;
        int end = 0;
        for (int i = 0; i < charArray.length; i++)
        {
            if(dateScanStarted)
            {
                if(dateIterator == 2 || dateIterator == 5)
                {
                    dateArray[dateIterator] = '/';
                    i--;
                }
                else
                {
                    dateArray[dateIterator] = charArray[i];
                }
                dateIterator++;
            }
            else if (Character.isDigit(charArray[i]))
            {
                dateScanStarted = true;
                end = i;
                dateArray[dateIterator] = charArray[i];
                dateIterator++;
            }
        }
        output = input.substring(0, end) + String.valueOf(dateArray);
        return output;
    }

    static String toTitleCase(String input){
        char[] charArray = input.toCharArray();
        String output;
        boolean shouldCapitalize = true;
        for (int i = 0; i < charArray.length; i++)
        {
            if(shouldCapitalize && !Character.isDigit(charArray[i]))
            {
                charArray[i] = Character.toUpperCase(charArray[i]);
                shouldCapitalize = false;
            }
            Character curr = charArray[i];
            if (curr.equals(' '))
            {
                shouldCapitalize = true;
            }
        }
        output = String.valueOf(charArray);
        return output;
    }

    static String toUpperCase(String input){
        return input.toUpperCase();
    }

} // FilesInOut


