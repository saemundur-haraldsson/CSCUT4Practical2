import java.io.*;
import java.util.Scanner;

public class FormatNamesm {

    public static void main(String[] args) throws IOException {
        boolean uppercase = false;
        String inputFileName = "";
        String outputFileName = "";

        // check for "-u" flag
        if (args.length > 0 && args[0].equals("-u")) {
            uppercase = true;
            inputFileName = args[1];
            outputFileName = args[2];
        } else {
            inputFileName = args[0];
            outputFileName = args[1];
        }

        // set up input scanner and output PrintWriter
        Scanner inputFileScanner = new Scanner(new File(inputFileName));
        PrintWriter outputFileWriter = new PrintWriter(outputFileName);

        // read and process each line of input
        while (inputFileScanner.hasNextLine()) {
            String line = inputFileScanner.nextLine();
            String[] parts = line.split(" ");

            // handle different name formats
            if (parts.length == 3) {
                String firstName = parts[0];
                String middleName = parts[1];
                String lastName = parts[2];

                // capitalize first and last name and add period to middle initial
                String formattedName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase() + " ";
                formattedName += middleName.substring(0, 1).toUpperCase() + ". ";
                formattedName += lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();

                // format the date as dd/mm/yyyy
                String date = parts[parts.length - 1];
                String formattedDate = date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4);

                // write the formatted line to the output file
                if (uppercase) {
                    outputFileWriter.println(formattedName.toUpperCase() + " " + formattedDate);
                } else {
                    outputFileWriter.println(formattedName + formattedDate);
                }
            } else if (parts.length == 2) {
                String firstName = parts[0];
                String lastName = parts[1];

                // capitalize first and last name
                String formattedName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase() + " ";
                formattedName += lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();

                // format the date as dd/mm/yyyy
                String date = parts[parts.length - 1];
                String formattedDate = date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4);

                // write the formatted line to the output file
                if (uppercase) {
                    outputFileWriter.println(formattedName.toUpperCase() + " " + formattedDate);
                } else {
                    outputFileWriter.println(formattedName + formattedDate);
                }
            } else {
                // skip lines that don't match the expected format
                continue;
            }
        }

        // close input and output files
        inputFileScanner.close();
        outputFileWriter.close();
    }
}
