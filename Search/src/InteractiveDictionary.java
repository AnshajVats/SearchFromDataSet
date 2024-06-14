import java.sql.SQLOutput;
import java.util.*;

public class InteractiveDictionary {
    private final Map<String, List<Entry>> dictionary;

    public InteractiveDictionary() {
        dictionary = new HashMap<>();
        loadDictionary();
    }

    private void loadDictionary() {
        System.out.println("! Loading data...");
        for (Entry entry : Entry.values()) {
            dictionary.computeIfAbsent(entry.getWord().toLowerCase(), k -> new ArrayList<>()).add(entry);
        }
        for (List<Entry> entries : dictionary.values()) {
            Collections.sort(entries);
        }
        System.out.println("! Loading completed...");
        System.out.println("===== DICTIONARY 340 JAVA ===== \n----- Keywords: 19\n" +
                "----- Definitions: 61");
    }

    public void search(String keyword) {
        List<Entry> entries = dictionary.get(keyword.toLowerCase());
        if (entries != null && !entries.isEmpty()) {
            for (Entry entry : entries) {
                System.out.println("    " +entry );
            }
        } else {
            System.out.println("Word not found in the dictionary.");
        }
    }

    public static void main(String[] args) {
        InteractiveDictionary dictionary = new InteractiveDictionary();
        StringBuilder StoredInput = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        String inputFromUser = "";
        int i = 1;
        while (true) {
            System.out.print("Search [" + i + "]: ");
            inputFromUser = scanner.nextLine();
            if (inputFromUser.equals("!q")) {
                System.out.println("\n-----THANK YOU-----");
                break;
            }
            if (inputFromUser.equals("!help")) {
                System.out.println(" |");
                System.out.println("  1. A search key -then 2. An optional part of speech -then\n" +
                        "  3. An optional 'distinct' -then 4. An optional 'reverse'");
                System.out.println(" |");
                continue;
            }

            System.out.println("  |");
            dictionary.search(inputFromUser);
            i++;
            System.out.println("  |");

        }
    }
}
