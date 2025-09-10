/** Creates a Place with the given zip, town name, and
* state
* @param zip The 5-digit zip code
* @param town The town name
* @param state The state abbreviation
*/

String z;
String t;
String s;

public Place(String zip, String town, String state) {
    z = zip;
    t = town;
    s = state;
}

public String toString() {
    return t + ", " + s;
}

public String getZip() {
    return z;
}

public String getTown() {
    return t;
}

public String getState() {
    return s;
}
