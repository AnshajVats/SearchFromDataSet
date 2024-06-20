import java.util.Scanner;

public class InputProcessor {

    private final InteractiveDictionary dictionary;
    private  String[] parts;

    public InputProcessor(InteractiveDictionary dictionary) {
        this.dictionary = dictionary;
        parts = null;
    }

    private void invalidInput(String input, int index) {
        String[] validInputs = {"key", "part of speech", "distinct", "reverse" };
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
    public void takeUserInput(){
        for (int j = 1; j < parts.length; j++) {
            if (parts[j].trim().equalsIgnoreCase("distinct")) {
                dictionary.setDistinct(true);
            }
            else if (parts[j].trim().equalsIgnoreCase("reverse")) {
                dictionary.setReverse(true);
            }
            else if (dictionary.checkPartOfSpeech(parts[j])){
                dictionary.setPartOfSpeech(parts[j]);
            }
            else {
                invalidInput(parts[j], j);
            }
        }
    }
    public void wrongInput() {
        System.out.println(" |");
        System.out.println("  PARAMETER HOW-TO, please enter:");
        System.out.println("  1. A search key -then 2. An optional part of speech -then\n" +
                "  3. An optional 'distinct' -then 4. An optional 'reverse'");
        System.out.println(" |");
    }
    public void inputCheckCases() {
        Scanner scanner = new Scanner(System.in);
        String inputFromUser;
        int i = 1;
        while (true) {
            System.out.print("Search [" + i + "]: ");
            inputFromUser = scanner.nextLine();
            parts = inputFromUser.split(" ");
            if(parts.length >= 4) {
                wrongInput();
                continue;
            }
            switch (inputFromUser.toLowerCase()) {
                case "!q":
                    System.out.println("\n-----THANK YOU-----");
                    return; // Exit the program

                case "!help", " " :
                    wrongInput();
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



    public static void main(String[] args) {
        InteractiveDictionary dictionary = new InteractiveDictionary();
        InputProcessor inputProcessor = new InputProcessor(dictionary);
        inputProcessor.inputCheckCases();


    }
}
