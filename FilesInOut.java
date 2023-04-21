import java.io.*;
import java.util.*;

/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FilesInOut {

    public static void main(String[] args) {
        String inputFileName, outputFileName;
        boolean isUpperCase = false;

        // Check command line arguments.
        if (args.length < 2 || args.length > 3) {
            System.err.println("Usage: java FilesInOut [-u] input.txt output.txt");
            System.exit(1);
        }

        int argIndex = 0;
        if (args.length == 3 && args[argIndex].equals("-u")) {
            isUpperCase = true;
            argIndex++;
        }
        inputFileName = args[argIndex++];
        outputFileName = args[argIndex];

        // Set up a new Scanner to read the input file.
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(inputFileName));
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + inputFileName);
            System.exit(1);
        }

        // Set up a new PrintWriter to write the output file.
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new File(outputFileName));
        } catch (FileNotFoundException e) {
            System.err.println("Output file not found: " + outputFileName);
            System.exit(1);
        }

        // Process the input file line by line.
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            // Format the name.
            StringBuilder formattedName = new StringBuilder();
            for (int i = 0; i < parts.length - 1; i++) {
                String part = parts[i];
                if (isUpperCase) {
                    formattedName.append(part.toUpperCase().charAt(0));
                    formattedName.append(part.substring(1).toUpperCase());
                } else {
                    formattedName.append(part.substring(0, 1).toUpperCase());
                    formattedName.append(part.substring(1).toLowerCase());
                }
                formattedName.append(" ");
            }

            // Format the date.
            String date = parts[parts.length - 1];
            String formattedDate = date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4);

            // Write the formatted line to the output file.
            writer.println(formattedName.toString().trim() + " " + formattedDate);
        }

        // Clean up resources.
        scanner.close();
        writer.close();

    } // main

} // FilesInOut
