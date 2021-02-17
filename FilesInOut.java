import java.io.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FilesInOut {

    public static void main(String[] args) {
        // Replace this with statements to set the file name (input) and file name (output).
        // Initially it will be easier to hardcode suitable file names.

        // Set up a new Scanner to read the input file.
        // Processing line by line would be sensible here.
        // Initially, echo the text to System.out to check you are reading correctly.
        // Then add code to modify the text to the output format.

        // Set up a new PrintWriter to write the output file.
        // Add suitable code into the above processing (because you need to do this line by line also.
        // That is, read a line, write a line, loop.

        // Finally, add code to read the filenames as arguments from the command line.
        FilesInOut f = new FilesInOut();
        boolean toUpper = false;
        if (args.length == 3){
            toUpper = true;
            f.readFile(args[1], args[2], toUpper);
        } else{
            f.readFile(args[0], args[1], toUpper);
        }
    } // main

    public void readFile(String input, String output, boolean option){
        try {
            File myObj = new File(input);
            if (myObj.exists()) {
                if (myObj.canRead()){
                    Scanner myReader = new Scanner(myObj);
                    int SIZE;
                    if (option) {
                        SIZE = 14;
                    } else {
                        SIZE = 15;
                    }
                    String[] arr = new String[SIZE];
                    int i = 0;
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        //System.out.println(data);
                        String[] result = data.split("\\s+");

                        if (result.length <=3){
                            String fName = result[0];
                            String lName = result[1];
                            if (option){
                                fName = fName.toUpperCase();
                                lName = lName.toUpperCase();
                            } else {
                                fName = fName.substring(0, 1).toUpperCase() + fName.substring(1);
                                lName = lName.substring(0, 1).toUpperCase() + lName.substring(1);
                            }

                            String day = result[2].substring(0,2);
                            String month = result[2].substring(2,4);
                            String year = result[2].substring(4,8);

                            String date = day + "/" + month + "/" + year;

                            String msg = fName + " " + lName + " " + date;

                            arr[i] = msg;
                        } else if (result.length > 3){
                            String fName = result[0];
                            String mName = result[1];
                            String lName = result[2];
                            if (option){
                                fName = fName.toUpperCase();
                                mName = mName.toUpperCase();
                                lName = lName.toUpperCase();
                            } else {
                                fName = fName.substring(0, 1).toUpperCase() + fName.substring(1);
                                mName = mName.toUpperCase();
                                lName = lName.substring(0, 1).toUpperCase() + lName.substring(1);
                            }

                            String day = result[3].substring(0,2);
                            String month = result[3].substring(2,4);
                            String year = result[3].substring(4,8);

                            String date = day + "/" + month + "/" + year;

                            String msg = fName + " " + mName + " " + lName + " " + date;

                            arr[i] = msg;
                        }
                        i++;
                    }
                    createFile(arr, output);
                    myReader.close();
                } else {
                    System.out.println("The input file you have entered is not readable!\nPlease enter a readable input file!");
                }
            } else {
                System.out.println("Your input file doesnt exist!\nPlease enter a valid input file that exists!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            System.out.println("\n" + e);
        }
    }

    private void createFile (String[] arr, String output){
        try {
            File myObj = new File(output);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                BufferedWriter outputWriter = null;
                outputWriter = new BufferedWriter(new FileWriter(output));
                for (int i = 0; i < arr.length; i++) {
                    outputWriter.write(arr[i]+"");
                    outputWriter.newLine();
                }
                outputWriter.flush();
                outputWriter.close();
                System.out.println("Successfully wrote to the file.");
            } else {
                System.out.println("File already exists.");
                System.out.println("Do You want to replace the current file called " + output + "?\n('y' for yes or 'n' for no)");
                Scanner s = new Scanner(System.in);
                String ans = s.nextLine();
                if (ans.equals("y") || ans.equals("Y")) {
                    if (myObj.delete()) {
                        System.out.println("Deleted the file: " + myObj.getName());
                        createFile(arr, output);
                    } else {
                        System.out.println("Failed to delete the file.");
                    }
                } else {
                    System.out.println("The file won't be replaced");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

} // FilesInOut
