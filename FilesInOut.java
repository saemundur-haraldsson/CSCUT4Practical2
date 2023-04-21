import java.io.*;
import java.util.*;

public class FilesInOut {
    public static void main(String[] args) throws IOException {

        String inputFileName = "";
        String outputFileName = "";
        boolean toUpperCase = false;
        boolean toHtml = false;

        // check if there are enough arguments
        if (args.length < 2) {
            System.out.println("Usage: java FilesInOut [-u] [-h] input_file output_file");
            System.exit(1);
        }

        // parse the command-line arguments
        int argIndex = 0;
        while (argIndex < args.length && args[argIndex].startsWith("-")) {
            String arg = args[argIndex++];

            switch (arg) {
                case "-u":
                    toUpperCase = true;
                    break;

                case "-h":
                    toHtml = true;
                    break;

                default:
                    System.out.println("Invalid option: " + arg);
                    System.out.println("Usage: java FilesInOut [-u] [-h] input_file output_file");
                    System.exit(1);
            }
        }

        // check if there are enough arguments
        if (argIndex + 1 >= args.length) {
            System.out.println("Usage: java FilesInOut [-u] [-h] input_file output_file");
            System.exit(1);
        }

        inputFileName = args[argIndex++];
        outputFileName = args[argIndex];

        // open the input file
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));

        // open the output file
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

        String line;

        // read each line from the input file and write it to the output file
        while ((line = reader.readLine()) != null) {
            String formattedLine = line;

            // apply formatting based on options
            if (toUpperCase) {
                formattedLine = formattedLine.toUpperCase();
            }

            if (toHtml) {
                formattedLine = "<p>" + formattedLine + "</p>";
            }

            writer.write(formattedLine);
            writer.newLine();
        }

        // close the files
        reader.close();
        writer.close();

        System.out.println("File formatted successfully.");
    }
}
