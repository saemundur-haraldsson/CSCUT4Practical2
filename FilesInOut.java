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

        boolean validInput = false;
        boolean validOutput = false;
        boolean upperCase = false;
        String inputFileName;
        String outputFileName;

        Scanner in = new Scanner(System.in);

        // attempts to read an input file
        do {
            System.out.println("supply filename for input:");
            try {
                inputFileName = in.nextLine();
                File inputFile = new File(inputFileName);
                Scanner inFile = new Scanner(inputFile);
                validInput = true;
                inFile.close();
                break;
            } catch (IOException e) {
                System.err.println("IOException: " + e.getMessage() + "not found");
            }
        } while (true);

        // attempts to read an output file
        do {
            System.out.println("supply filename for output:");
            try {
                outputFileName = in.nextLine();
                File outputFile = new File(outputFileName);
                PrintWriter printWriter = new PrintWriter(outputFileName);
                validOutput = true;
                printWriter.close();
                break;
            } catch (IOException e) {
                System.err.println("IOException: " + e.getMessage() + "not openable");
                System.exit(0);
            }
        } while (true);

        // checks if the user wants their output in uppercase
        System.out.println("Uppercase? (yes/no): ");
        String upperCaseResult = in.nextLine().toLowerCase();

        if (upperCaseResult.equals("yes")) {
            upperCase = true;
        }

        if (upperCase) {
            upperCase(inputFileName, outputFileName);
        } else {
            titleCase(inputFileName, outputFileName);
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
            in2.close();
        }
        in.close();
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
            in2.close();
        }
        in.close();
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
