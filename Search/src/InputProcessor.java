import java.util.List;
import java.util.Scanner;

public class InputProcessor {

    private final InteractiveDictionary dictionary;
    private String[] parts;

    /**
     * Constructor to initialize the InputProcessor with an InteractiveDictionary instance.
     * @param dictionary An instance of InteractiveDictionary.
     */
    public InputProcessor(InteractiveDictionary dictionary) {
        this.dictionary = dictionary;
        parts = null;
    }

    /**
     * Processes user input to set search parameters (distinct, reverse, part of speech).
     */
    public void takeUserInput() {
        for (int j = 1; j < parts.length; j++) {
            if (parts[j].trim().equalsIgnoreCase("distinct")) {
                dictionary.setDistinct(true);
            } else if (parts[j].trim().equalsIgnoreCase("reverse")) {
                dictionary.setReverse(true);
            } else if (dictionary.checkPartOfSpeech(parts[j])) {
                dictionary.setPartOfSpeech(parts[j]);
            } else {
                PrintOutput.printInvalidInput(parts[j], j);
            }
        }
    }

    /**
     * Continuously takes input from the user, validates it, and processes the search.
     */
    public void inputCheckCases() {
        Scanner scanner = new Scanner(System.in);
        String inputFromUser;
        int i = 1;
        while (true) {
            System.out.print("Search [" + i + "]: ");
            inputFromUser = scanner.nextLine();
            parts = inputFromUser.split(" ");
            if (parts.length > 4) {
                PrintOutput.wrongInput();
                continue;
            }
            switch (inputFromUser.toLowerCase()) {
                case "!q":
                    System.out.println("\n-----THANK YOU-----");
                    return; // Exit the program

                case "!help":
                case " ":
                    PrintOutput.wrongInput();
                    break;
                default:
                    takeUserInput();
                    System.out.println("  |");
                    dictionary.search(parts[0]);
                    System.out.println("  |");
            }
            i++;
        }
    }

    /**
     * Main method to run the InputProcessor.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        InteractiveDictionary dictionary = new InteractiveDictionary();
        InputProcessor inputProcessor = new InputProcessor(dictionary);
        inputProcessor.inputCheckCases();
    }
}
