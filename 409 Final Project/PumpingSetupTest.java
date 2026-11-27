// Tests for Role 2
public class PumpingSetupTest {

    private static int passed = 0;
    private static int total = 0;

    private static void check(String name, boolean condition) {
        total++;
        if (condition) {
            passed++;
        }
        System.out.println((condition ? "PASS " : "FAIL ") + name);
    }

    private static boolean rejects(int p) {
        try {
            PumpingSetup.chosenString(p);
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    public static void main(String[] args) {
        check("chosenString(1) is 01", PumpingSetup.chosenString(1).equals("01"));
        check("chosenString(3) is 000111", PumpingSetup.chosenString(3).equals("000111"));

        for (int p : new int[] {1, 2, 7, 100}) {
            String w = PumpingSetup.chosenString(p);
            check("chosenString is valid for p = " + p, PumpingSetup.isValidChosenString(w, p));
            check("first p symbols are 0s for p = " + p,
                w.substring(0, p).equals("0".repeat(p)));
        }

        check("rejects a string not in L", !PumpingSetup.isValidChosenString("0001", 3));
        check("rejects a string shorter than p", !PumpingSetup.isValidChosenString("01", 3));
        check("rejects null", !PumpingSetup.isValidChosenString(null, 3));
        check("chosenString(0) is rejected", rejects(0));
        check("chosenString(-1) is rejected", rejects(-1));

        System.out.println("\nPassed " + passed + " out of " + total + " tests.");
    }
}
