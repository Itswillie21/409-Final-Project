// Role 2: Pumping Setup and Witness Selection
public class PumpingSetup {

    // Returns the chosenString w = 0^p 1^p for pumping length p (p >= 1).
    public static String chosenString(int p) {
        if (p < 1) {
            throw new IllegalArgumentException("pumping length p must be at least 1");
        }
        return "0".repeat(p) + "1".repeat(p);
    }

    // true only if w is in L and |w| >= p
    public static boolean isValidChosenString(String w, int p) {
        return Language.isMember(w) && w.length() >= p;
    }

    // Prints the opening of the proof.
    public static void printSetup(int p) {
        String w = chosenString(p);
        System.out.println("Assume for contradiction that L is regular.");
        System.out.println("Then L has a pumping length p. Example value: p = " + p);
        System.out.println("Chosen string (witness): w = 0^p 1^p = \"" + w + "\", |w| = " + w.length());
        System.out.println("w in L and |w| >= p: " + isValidChosenString(w, p));
        System.out.println("Why this w: its first p = " + p + " symbols are all 0s (\""
            + w.substring(0, p) + "\").");
        System.out.println("Since |xy| <= p, x and y lie inside those symbols, "
            + "so every legal y contains only 0s.");
    }

    public static void main(String[] args) {
        for (int p : new int[] {1, 3, 7}) {
            printSetup(p);
            System.out.println();
        }
        
    }
}
