import java.util.List;

public class PrintOutput {
    /**
     * Prints a message indicating incorrect input format and provides guidance on the expected parameters.
     */
    public static void wrongInput() {
        System.out.println(" |");
        System.out.println("  PARAMETER HOW-TO, please enter:");
        System.out.println("  1. A search key -then 2. An optional part of speech -then\n" +
                "  3. An optional 'distinct' -then 4. An optional 'reverse'");
        System.out.println(" |");
    }

    /**
     * Prints the entries from the result list.
     * @param resultEntries List of Entry objects to be printed.
     */
    public static void printEntriesOutput(List<Entry> resultEntries) {
        for (Entry entry : resultEntries) {
            System.out.println("    " + entry);
        }
    }

    /**
     * Prints a message indicating that no results were found and provides guidance on the expected parameters.
     */
    public static void printNotFoundMessage() {
        System.out.println("   <NOT FOUND> To be considered for the next release. Thank you.");
        System.out.println("  |");
        System.out.println("  |");
        System.out.println("   PARAMETER HOW-TO, please enter:");
        System.out.println("   1. A search key -then 2. An optional part of speech -then\n" +
                "   3. An optional 'distinct' -then 4. An optional 'reverse'");
    }

    /**
     * Prints a message indicating that the input is invalid and provides guidance on the expected parameters.
     * @param input The invalid input entered by the user.
     * @param index The index of the invalid input in the list of parameters.
     */
    public static void printInvalidInput(String input, int index) {
        String[] validInputs = {"key", "part of speech", "distinct", "reverse"};
        System.out.println("  |");
        for (int i = index; i < validInputs.length; i++) {
            System.out.printf("   <The entered %drd parameter '%s' is NOT '%s'.>\n", (index + 1), input, validInputs[i]);
        }
        System.out.printf("   <The entered %drd parameter '%s' was disregarded.>\n", (index + 1), input);
        switch (index) {
            case 1:
                System.out.printf("   <The %dnd parameter should be a part of speech or 'distinct' or 'reverse'.>\n", (index + 1));
                break;
            case 2:
                System.out.printf("   <The %dnd parameter should be a 'distinct' or 'reverse'.>\n", (index + 1));
                break;
            case 3:
                System.out.printf("   <The %dnd parameter should be a 'reverse'.>\n", (index + 1));
                break;
        }
        System.out.println("  |");
    }
}

