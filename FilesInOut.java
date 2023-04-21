import java.io.*;
import java.util.*;

public class FilesInOut {

    public static void main(String[] args) {
        String inputFileName, outputFileName;
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = null;
        BufferedWriter writer = null;
        
        // Ask the user for the input file name and keep asking until a valid file is given
        while (true) {
            System.out.print("Enter the input file name: ");
            inputFileName = scanner.nextLine();
            try {
                reader = new BufferedReader(new FileReader(inputFileName));
                break;
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Try again.");
            }
        }

        // Ask the user for the output file name and keep asking until a valid file is given
        while (true) {
            System.out.print("Enter the output file name: ");
            outputFileName = scanner.nextLine();
            try {
                writer = new BufferedWriter(new FileWriter(outputFileName));
                break;
            } catch (IOException e) {
                System.out.println("Could not open file. Try again.");
            }
        }

        // Set up a new Scanner to read the input file.
        // Processing line by line would be sensible here.
        // Initially, echo the text to System.out to check you are reading correctly.
        // Then add code to modify the text to the output format.
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                StringBuilder nameBuilder = new StringBuilder();
                for (int i = 0; i < tokens.length - 1; i++) {
                    String token = tokens[i];
                    nameBuilder.append(token.substring(0, 1).toUpperCase());
                    nameBuilder.append(token.substring(1));
                    if (i < tokens.length - 2) {
                        nameBuilder.append(" ");
                    }
                }
                String name = nameBuilder.toString();
                String dob = tokens[tokens.length - 1];
                String formattedDob = dob.substring(0, 2) + "/" + dob.substring(2, 4) + "/" + dob.substring(4);
                if (args.length > 0 && args[0].equals("-u")) {
                    name = name.toUpperCase();
                }
                writer.write(name + " " + formattedDob + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading or writing file.");
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }
        scanner.close();
    }
}
