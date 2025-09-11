/**
 * File name: Driver00.java
 * Author: Kailyn Brown
 * Date: 9/11/2025
 * Purpose: Driver file for the Zipcode Lookup program for CS151
 */

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver00 {
    public static void main(String[] args) {
        if (args.length < 2) { // checks to make sure user input file name + # of entries 
            System.out.println("Usage: java Driver00 <fileName> <numEntries>"); // tells the user how to run the program
            return; // stops the program
        }

        String fileName = args[0]; // assigns the filename to the <fileName> part of the arg
        int numEntries = Integer.parseInt(args[1]); // assigns the # of entries to the <numEntries> part of the 

        Place[] places = null; // empty array of places

        try { // tries to create the array w the given file name + number of entries
            places = LookupZip.readZipCodes(fileName, numEntries);
        } catch (FileNotFoundException e) { // else tell the user the file doesnt exist
            System.out.println("File not found: " + fileName);
            return; // stops the program
        }

        Scanner input = new Scanner(System.in); // scanner to take in user input

        while (true) { // infinite loop
            System.out.print("zipcode: ");
            String zip = input.nextLine(); // reads the next line for user input

            if (zip.equals("00000")) {
                System.out.println("Good Bye!");
                break; // when user wants to quit - escape loop
            }

            Place result = LookupZip.lookupZip(places, zip); // looks up the zip 
            if (result != null) { // if the lookup returns w something
                System.out.println(result); // print the result
            } else { // if it doesn't show up
                System.out.println("No such zipcode");
            }
        }

        input.close(); // stops the scanner
    }
}