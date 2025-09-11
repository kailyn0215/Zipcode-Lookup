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
        String[] parts = line.split(",");
        String zip = parts[0];
        String town = parts[1];
        String state = parts[2];
        return new Place(zip, town, state);
    }

    /**
     * Reads a zipcodes file, parsing every line
     * @param filename The name of the zipcodes file
     * @param numEntries the number of places in the csv file
     * @return The array of Places representing all the
     * data in the file.
     */
    public static Place[] readZipCodes(String filename, int numEntries) throws FileNotFoundException {
        Place[] places = new Place[numEntries];
        Scanner sc = new Scanner(new File(filename));
        
        // Skip the header line
        if (sc.hasNextLine()) {
            sc.nextLine();
        }

        int i = 0;
        while (sc.hasNextLine() && i < numEntries) {
            String line = sc.nextLine();
            places[i] = parseLine(line);
            i++;
        }
        sc.close();
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
        for (Place p : places) {
            if (p != null && p.getZip().equals(zip)) {
                return p;
            }
        }
        return null;
    }
}
