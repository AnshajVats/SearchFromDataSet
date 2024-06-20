import java.util.*;

public class InteractiveDictionary {
    private final Map<String, List<Entry>> dictionary;
    private List<Entry> resultEntries;
    private boolean distinct;
    private boolean reverse;
    private String partOfSpeech;


    public InteractiveDictionary() {
        dictionary = new HashMap<>();
        resultEntries = null;
        distinct = false;
        reverse = false;
        partOfSpeech = null;
        loadDictionary();
    }

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
    public void printNotFoundMessage() {
        System.out.println("   <NOT FOUND> To be considered for the next release. Thank you.");
        System.out.println("  |");
        System.out.println("  |");
        System.out.println("   PARAMETER HOW-TO, please enter:");
        System.out.println("   1. A search key -then 2. An optional part of speech -then\n" +
                "   3. An optional 'distinct' -then 4. An optional 'reverse'");
    }

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

            printEntries();
            if (resultEntries.isEmpty()) {
                printNotFoundMessage();
                return;
            }
            partOfSpeech = null;
        } else {
            printNotFoundMessage();

        }
    }


    public boolean checkPartOfSpeech(String partOfSpeech) {
        String[] partOfSpeeches = {"noun", "verb" ,"adjective", "adverb", "pronoun", "preposition", "conjunction", "interjection"};
        for (String pos : partOfSpeeches) {
            if (partOfSpeech.equalsIgnoreCase(pos)) {
                return true;
            }
        }
        return false;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }
    private List<Entry> reverseEntries() {
        List<Entry> reversedEntries = new ArrayList<>();
        for (int i = resultEntries.size() - 1; i >= 0; i--) {
            reversedEntries.add(resultEntries.get(i));
        }
        return reversedEntries;
    }

    private void printEntries() {
        for (Entry entry : resultEntries) {
            System.out.println("    " + entry);
        }
    }
    private List<Entry> getDistinctEntries() {
        Set<Entry> distinctSet = new TreeSet<>(Entry::compareDefinition);
        distinctSet.addAll(resultEntries);
        List <Entry> distinctEntries = new ArrayList<>(distinctSet);
        Collections.sort(distinctEntries);
        return distinctEntries;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

}
