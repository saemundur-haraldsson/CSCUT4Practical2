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
     *
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
                /* capitalise the first character if it is a letter, or add forward slashes if
                    a number is spotted*/
                if (Character.isLetter(lineInput.charAt(0))) {
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
     *
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
                /* capitalise the whole input if it is a letter, or add forward slashes if
                    a number is spotted*/
                if (Character.isLetter(lineInput.charAt(0))) {
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

} // FilesInOut
