/**
 * File name: LookupZip.java
 * Author: Kailyn Brown
 * Date: 9/11/2025
 * Purpose: Provides methods to read data from files, creates Place objects, stores them in arrays, and performs lookups
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LookupZip {
    /**
     * Parses one line of input by creating a Place that
     * denotes the information in the given line
     * @param line One line from the zipcodes file
     * @return A Place that contains the relevant information
     * (zip code, town, state) from that line
     */
    public static Place parseLine(String line) {
        String[] parts = line.split(","); // splits the line at commas
        String zip = parts[0];
        String town = parts[1];
        String state = parts[2];
        return new Place(zip, town, state); // ignores other info on line and returns new Place object with new info
    }

    /**
     * Reads a zipcodes file, parsing every line
     * @param filename The name of the zipcodes file
     * @param numEntries the number of places in the csv file
     * @return The array of Places representing all the
     * data in the file.
     */
    public static Place[] readZipCodes(String filename, int numEntries) throws FileNotFoundException {
        Place[] places = new Place[numEntries]; // makes new array using users given length
        Scanner sc = new Scanner(new File(filename)); // scans the users given file
        
        // skips the header line
        if (sc.hasNextLine()) {
            sc.nextLine();
        }

        int i = 0;
        while (sc.hasNextLine() && i < numEntries) { // while there is more of the file to read and more space in the array
            String line = sc.nextLine();
            places[i] = parseLine(line); // parses the line and adds it to the array
            i++;
        }
        sc.close(); // closes the scanner
        return places;
    }

    /**
     * Find a Place with a given zip code
     * @param places The array of Place objects to search through
     * @param zip The zip code (as a String) to look up
     * @return A place that matches the given zip code,
     * or null if no such place exists.
     */
    public static Place lookupZip(Place[] places, String zip) {
        for (Place p : places) { // i love for each loops :)
            if (p != null && p.getZip().equals(zip)) { // if p equals the users input
                return p; // return that info
            }
        }
        return null; // else return nothing
    }
}
