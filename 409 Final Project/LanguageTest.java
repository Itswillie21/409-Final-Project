public class LanguageTest {

    public static void main(String[] args) {
        String[] inputs = {
            "", "01", "0011", "000111", "00001111",
            "0", "1", "001", "011", "0101",
            "111000", "0001111", "aabb", " 01 ", "10"
        };

        boolean[] expected = {
            true, true, true, true, true,
            false, false, false, false, false,
            false, false, false, false, false
        };

        int passed = 0;

        for (int i = 0; i < inputs.length; i++) {
            boolean actual = Language.isMember(inputs[i]);
            boolean correct = actual == expected[i];

            if (correct) {
                passed++;
            }

            System.out.println("Input: \"" + inputs[i] + "\" | Expected: "
                + expected[i] + " | Actual: " + actual
                + " | " + (correct ? "PASS" : "FAIL"));
        }

        boolean nullPass = !Language.isMember(null);
        if (nullPass) {
            passed++;
        }
        System.out.println("Input: null | Expected: false | Actual: "
            + Language.isMember(null) + " | " + (nullPass ? "PASS" : "FAIL"));

        System.out.println("\nPassed " + passed + " out of 16 tests.");
    }
}
