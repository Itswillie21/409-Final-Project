public class Language {

    // The language is L = {0^n 1^n | n >= 0}.
    public static String getDescription() {
        return "L = {0^n 1^n | n >= 0}: equal numbers of 0s and 1s, with all 0s first.";
    }

    // Returns true only when the input belongs to our language.
    public static boolean isMember(String input) {
        if (input == null) {
            return false;
        }

        int index = 0;
        int zeros = 0;
        int ones = 0;

        // Count the 0s at the beginning.
        while (index < input.length() && input.charAt(index) == '0') {
            zeros++;
            index++;
        }

        // Count the 1s that follow.
        while (index < input.length() && input.charAt(index) == '1') {
            ones++;
            index++;
        }

        // All characters must be used and the counts must match.
        return index == input.length() && zeros == ones;
    }

    public static void main(String[] args) {
        String[] examples = {"", "01", "0011", "000111", "001", "0101", "111000"};

        System.out.println(getDescription());
        for (String example : examples) {
            System.out.println("\"" + example + "\" -> " + isMember(example));
        }
    }
}
