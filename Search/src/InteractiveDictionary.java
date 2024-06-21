import java.util.*;

public class InteractiveDictionary {
    private final Map<String, List<Entry>> dictionary;
    private List<Entry> resultEntries;
    private boolean distinct;
    private boolean reverse;
    private String partOfSpeech;

    /**
     * Constructor to initialize the InteractiveDictionary and load the dictionary entries.
     */
    public InteractiveDictionary() {
        dictionary = new HashMap<>();
        resultEntries = null;
        distinct = false;
        reverse = false;
        partOfSpeech = null;
        loadDictionary();
    }

    /**
     * Loads predefined dictionary entries into the dictionary.
     */
    private void loadDictionary() {
        int totalDefinitions = 0;
        Collection<List<Entry>> allEntryLists = dictionary.values();


        System.out.println("! Loading data...");
        for (Entry entry : Entry.values()) {
            dictionary.computeIfAbsent(entry.getWord().toLowerCase(), k -> new ArrayList<>()).add(entry);
        }
        for (List<Entry> entries : dictionary.values()) {
            Collections.sort(entries);
        }
        System.out.println("! Loading completed...");
        System.out.println("===== DICTIONARY 340 JAVA ===== ");
        System.out.println("----- Keywords: " + dictionary.size());

        for (List<Entry> entryList : allEntryLists) {
            totalDefinitions += entryList.size();
        }
        System.out.println("----- Definitions: " + totalDefinitions);
    }

    /**
     * Searches the dictionary for the given word and applies the specified filters.
     * @param searchWord The word to search for in the dictionary.
     */
    public void search(String searchWord) {
        List<Entry> entries = dictionary.get(searchWord.toLowerCase());
        if (entries != null && !entries.isEmpty()) {
            resultEntries = new ArrayList<>(entries);
            if (partOfSpeech != null) {
                resultEntries.removeIf(entry -> !entry.getPartOfSpeech().equalsIgnoreCase(partOfSpeech));
                Collections.sort(resultEntries);
            }
            if (distinct) {
                resultEntries = getDistinctEntries();
                distinct = false;
            }

            if (reverse) {
                resultEntries = reverseEntries();
                reverse = false;
            }
            if (resultEntries.isEmpty()) {
                PrintOutput.printNotFoundMessage();
                return;
            }
            PrintOutput.printEntriesOutput(resultEntries);
            partOfSpeech = null;
        } else {
            PrintOutput.printNotFoundMessage();

        }
    }


    /**
     * Checks if the given part of speech is valid.
     * @param partOfSpeech The part of speech to check.
     * @return True if the part of speech is valid, false otherwise.
     */
    public boolean checkPartOfSpeech(String partOfSpeech) {
        return Entry.isValidPartOfSpeech(partOfSpeech);
    }


    /**
     * Sets the part of speech filter for the search.
     * @param partOfSpeech The part of speech to set.
     */
    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }


    /**
     * Reverses the order of the result entries.
     * @return A list of entries in reverse order.
     */
    private List<Entry> reverseEntries() {
        List<Entry> reversedEntries = new ArrayList<>();
        for (int i = resultEntries.size() - 1; i >= 0; i--) {
            reversedEntries.add(resultEntries.get(i));
        }
        return reversedEntries;
    }


    /**
     * Returns a list of distinct entries from the result entries.
     * @return A list of distinct entries.
     */
    private List<Entry> getDistinctEntries() {
        Set<Entry> distinctSet = new TreeSet<>(Entry::compareDefinition);
        distinctSet.addAll(resultEntries);
        List <Entry> distinctEntries = new ArrayList<>(distinctSet);
        Collections.sort(distinctEntries);
        return distinctEntries;
    }


    /**
     * Sets the distinct filter for the search.
     * @param distinct The distinct flag to set.
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * Sets the reverse filter for the search.
     * @param reverse The reverse flag to set.
     */
    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }
}
