import java.io.*;
import java.util.*;

public class FilesInOut {

    public static void main(String[] args) throws IOException {

        // define input and output file paths
        String inputFile = args[args.length - 2];
        String outputFile = args[args.length - 1];

        // define flags
        boolean uFlag = false; // for upper case output
        boolean hFlag = false; // for HTML output

        // check for uFlag and hFlag in args array
        for (int i = 0; i < args.length - 2; i++) {
            if (args[i].equals("-u")) {
                uFlag = true;
            } else if (args[i].equals("-h")) {
                hFlag = true;
            }
        }

        // create input and output file objects
        File input = new File(inputFile);
        File output = new File(outputFile);

        // create scanner to read input file
        Scanner scanner = new Scanner(input);

        // create writer to write output file
        FileWriter writer = new FileWriter(output);

        // create HTML header if hFlag is true
        if (hFlag) {
            writer.write("<html>\n<head>\n<title>Formatted Names</title>\n</head>\n<body>\n");
        }

        // read each line of input file and write formatted name to output file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] nameParts = line.split(" ");

            // get first and last name
            String firstName = nameParts[0];
            String lastName = nameParts[nameParts.length - 1];

            // get middle initial, if it exists
            String middleInitial = "";
            if (nameParts.length > 2) {
                middleInitial = nameParts[1].substring(0, 1).toUpperCase() + ". ";
            }

            // format date of birth as dd/mm/yyyy
            String dob = nameParts[nameParts.length - 2];
            dob = dob.substring(0, 2) + "/" + dob.substring(2, 4) + "/" + dob.substring(4);

            // format name with or without middle initial, depending on middleInitial value
            String formattedName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1) + " ";
            if (!middleInitial.equals("")) {
                formattedName += middleInitial;
            }
            formattedName += lastName.substring(0, 1).toUpperCase() + lastName.substring(1);

            // write formatted name to output file
            if (uFlag) {
                writer.write(formattedName.toUpperCase() + " " + dob + "\n");
            } else if (hFlag) {
                writer.write("<p>" + formattedName + " " + dob + "</p>\n");
            } else {
                writer.write(formattedName + " " + dob + "\n");
            }
        }

        // create HTML footer if hFlag is true
        if (hFlag) {
            writer.write("</body>\n</html>");
        }

        // close scanner and writer
        scanner.close();
        writer.close();
    }
}
