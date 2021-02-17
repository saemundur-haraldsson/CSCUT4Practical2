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

    public static void main(String[] args) throws FileNotFoundException {

        // checks if the args array contains the -u flag
        boolean hasUFlag = Arrays.stream(args).anyMatch("-u"::equals);

        if (hasUFlag) {
            upperCase(args[1], args[2]);
        } else {
            titleCase(args[0], args[1]);
        }
        
    } // main

    /**
     * If the -u flag is not spotted as a parameter, this method is called to capitalise the first
     * letter of every word, modify middle initials, as well as to turn dates into their proper format
     * @param inputFile - File to be read from
     * @param outputFile - File to be written to
     * @throws FileNotFoundException
     */
    public static void titleCase(String inputFile, String outputFile) throws FileNotFoundException {
        File input = new File(inputFile);
        File output = new File(outputFile);
        PrintWriter printWriter = new PrintWriter(output);

        Scanner in = new Scanner(input);
        while (in.hasNextLine()) {
            Scanner in2 = new Scanner(in.nextLine());
            // read all the inputs in a line
            while (in2.hasNext()) {
                String lineInput = in2.next();
                /* modify the middle initial if a letter is spotted on its own,
                   capitalise the first character if it is a letter of a word,
                   or add forward slashes if a number is spotted*/
                if (Character.isLetter(lineInput.charAt(0)) && lineInput.length() == 1) {
                    lineInput = handleMiddleInitial(lineInput);
                } else if (Character.isLetter(lineInput.charAt(0))) {
                    lineInput = Character.toUpperCase(lineInput.charAt(0)) + lineInput.substring(1);
                } else {
                    lineInput = lineInput.substring(0, 2) + "/" + lineInput.substring(2, 4) + "/" + lineInput.substring(4, 8);
                }
                printWriter.print(lineInput + " ");
            }
            printWriter.println();
        }
        printWriter.close();
    }

    /**
     * If the -u flag is passed on as an argument, then this method is called to turn every input
     * that is a word into uppercase, modify middle initials, as well as to turn dates into their proper
     * format
     * @param inputFile - File to be read from
     * @param outputFile - File to be written to
     * @throws FileNotFoundException
     */
    public static void upperCase(String inputFile, String outputFile) throws FileNotFoundException {
        File input = new File(inputFile);
        File output = new File(outputFile);
        PrintWriter printWriter = new PrintWriter(output);

        Scanner in = new Scanner(input);
        while (in.hasNextLine()) {
            Scanner in2 = new Scanner(in.nextLine());
            // read all the inputs in a line
            while (in2.hasNext()) {
                String lineInput = in2.next();
                /* modify the middle initial if a letter is spotted on its own,
                   capitalise the whole input if it is a letter of a word,
                   or add forward slashes if a number is spotted*/
                if (Character.isLetter(lineInput.charAt(0)) && lineInput.length() == 1) {
                    lineInput = handleMiddleInitial(lineInput);
                } else if (Character.isLetter(lineInput.charAt(0))) {
                    lineInput = lineInput.toUpperCase();
                } else {
                    lineInput = lineInput.substring(0, 2) + "/" + lineInput.substring(2, 4) + "/" + lineInput.substring(4, 8);
                }
                printWriter.print(lineInput + " ");
            }
            printWriter.println();
        }
        printWriter.close();
    }

    /**
     * Handles middle initials by turning them into uppercase and adding a full stop after them
     * @param initial - The initial to be modified
     * @return - The initial capitalised along with a full stop after it
     */
    public static String handleMiddleInitial(String initial) {
        String modifiedInitial = initial.toUpperCase() + ".";
        return modifiedInitial;
    }

} // FilesInOut
