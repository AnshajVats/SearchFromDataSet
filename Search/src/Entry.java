import java.util.Arrays;

    public enum Entry {
        // Arrow
        ARROW_NOUN("Arrow", "Noun", " Here is one arrow: <IMG> -=>> </IMG>"),

        // Book
        BOOK_NOUN1("Book", "noun", "A set of pages."),
        BOOK_NOUN2("Book", "noun", "A written work published in printed or electronic form."),
        BOOK_VERB1("Book", "verb", "To arrange for someone to have a seat on a plane."),
        BOOK_VERB2("Book", "verb", "To arrange for something on a particular date."),
        BOOKABLE_ADJECTIVE("Bookable", "adjective", "Can be ordered in advance."),

        // Distinct
        DISTINCT_ADJECTIVE1("Distinct", "adjective", "Familiar. Worked in Java."),
        DISTINCT_ADJECTIVE2("Distinct", "adjective", "Unique. No duplicates. Clearly different or of a different kind."),
        DISTINCT_ADVERB("Distinct", "adverb", "Uniquely. Written 'distinctly'."),
        DISTINCT_NOUN1("Distinct", "noun", "A keyword in this assignment."),
        DISTINCT_NOUN2("Distinct", "noun", "An advanced search option."),
        DISTINCT_NOUN3("Distinct", "noun", "Distinct is a parameter in this assignment."),
        DISTINCT_NOUN4("Distinct", "noun", "Distinct is a parameter in this assignment."),
        DISTINCT_NOUN5("Distinct", "noun", "Distinct is a parameter in this assignment."),

        // Placeholder
        PLACEHOLDER_ADJECTIVE1("Placeholder", "adjective", "To Be Updated..."),
        PLACEHOLDER_ADJECTIVE2("Placeholder", "adjective", "To Be Updated..."),
        PLACEHOLDER_ADJECTIVE3("Placeholder", "adverb", "To Be Updated..."),
        PLACEHOLDER_CONJUNCTION("Placeholder", "conjunction", "To Be Updated..."),
        PLACEHOLDER_INTERJECTION("Placeholder", "interjection", "To Be Updated..."),
        PLACEHOLDER_NOUN1("Placeholder", "noun", "To Be Updated..."),
        PLACEHOLDER_NOUN2("Placeholder", "noun", "To Be Updated..."),
        PLACEHOLDER_NOUN3("Placeholder", "noun", "To Be Updated..."),
        PLACEHOLDER_PREPOSITION("Placeholder", "preposition", "To Be Updated..."),
        PLACEHOLDER_PRONOUN("Placeholder", "pronoun", "To Be Updated..."),

        // Reverse
        REVERSE_ADJECTIVE1("Reverse", "adjective", "On back side."),
        REVERSE_ADJECTIVE2("Reverse", "adjective", "Opposite to usual or previous arrangement."),
        REVERSE_NOUN1("Reverse", "noun", "A dictionary program's parameter."),
        REVERSE_NOUN2("Reverse", "noun", "Change to opposite direction."),
        REVERSE_NOUN3("Reverse", "noun", "The opposite."),
        REVERSE_NOUN4("Reverse", "noun", "To be updated..."),
        REVERSE_NOUN5("Reverse", "noun", "To be updated..."),
        REVERSE_NOUN6("Reverse", "noun", "To be updated..."),
        REVERSE_NOUN7("Reverse", "noun", "To be updated..."),
        REVERSE_VERB1("Reverse", "verb", "Change something to opposite."),
        REVERSE_VERB2("Reverse", "verb", "Go back"),
        REVERSE_VERB3("Reverse", "verb", "Revoke ruling."),
        REVERSE_VERB4("Reverse", "verb", "To be updated..."),
        REVERSE_VERB5("Reverse", "verb", "Turn something inside out."),

        // Apple
        APPLE_NOUN("Apple", "Noun", "A round fruit with red, green, or yellow skin and firm white flesh."),

        // Bank
        BANK_NOUN("Bank", "Noun", "An institution for receiving, keeping, and lending money."),
        BANK_VERB("Bank", "Verb", "To deposit money into a bank account."),

        // Car
        CAR_NOUN("Car", "Noun", "A road vehicle, typically with four wheels, powered by an internal combustion engine or electric motor."),

        // Dance
        DANCE_NOUN("Dance", "Noun", "A series of movements that match the speed and rhythm of a piece of music."),
        DANCE_VERB("Dance", "Verb", "To move rhythmically to music, typically following a set sequence of steps."),

        // Elephant
        ELEPHANT_NOUN("Elephant", "Noun", "A large mammal with a trunk and tusks, native to Africa and Asia."),

        // Fish
        FISH_NOUN("Fish", "Noun", "A limbless cold-blooded vertebrate animal with gills and fins living wholly in water."),
        FISH_VERB("Fish", "Verb", "To catch or try to catch fish, typically by using a net or hook and line."),

        // Glass
        GLASS_NOUN("Glass", "Noun", "A hard, brittle substance, typically transparent or translucent, made by fusing sand with soda, lime, and sometimes other ingredients and cooling rapidly."),

        // House
        HOUSE_NOUN("House", "Noun", "A building for human habitation, especially one that is lived in by a family or small group of people."),

        // Internet
        INTERNET_NOUN("Internet", "Noun", "A global computer network providing a variety of information and communication facilities, consisting of interconnected networks using standardized communication protocols."),

        // Jump
        JUMP_NOUN("Jump", "Noun", "An act of propelling oneself off the ground."),
        JUMP_VERB("Jump", "Verb", "To push oneself off a surface and into the air by using the muscles in one's legs and feet."),

        // Kite
        KITE_NOUN("Kite", "Noun", "A toy consisting of a light frame with thin material stretched over it, flown in the wind at the end of a long string."),

        // Lion
        LION_NOUN("Lion", "Noun", "A large tawny-colored cat that lives in prides, found in Africa and northwestern India."),

        // Mountain
        MOUNTAIN_NOUN("Mountain", "Noun", "A large natural elevation of the earth's surface rising abruptly from the surrounding level; a large steep hill."),

        // Nest
        NEST_NOUN("Nest", "Noun", "A structure or place made or chosen by a bird for laying eggs and sheltering its young."),

        // Orange
        ORANGE_NOUN("Orange", "Noun", "A large round juicy citrus fruit with a tough bright reddish-yellow rind."),

        // Piano
        PIANO_NOUN("Piano", "Noun", "A large keyboard musical instrument with a wooden case enclosing a soundboard and metal strings."),

        // Queen
        QUEEN_NOUN("Queen", "Noun", "The female ruler of an independent state, especially one who inherits the position by right of birth."),

        // River
        RIVER_NOUN("River", "Noun", "A large natural stream of water flowing in a channel to the sea, a lake, or another such stream."),

        // Sun
        SUN_NOUN("Sun", "Noun", "The star around which the earth orbits."),

        // Tree
        TREE_NOUN("Tree", "Noun", "A woody perennial plant, typically having a single stem or trunk growing to a considerable height and bearing lateral branches at some distance from the ground."),

        // Umbrella
        UMBRELLA_NOUN("Umbrella", "Noun", "A device consisting of a circular canopy of cloth on a folding metal frame supported by a central rod, used as protection against rain or sometimes sun.");

        private final String word;
        private final String partOfSpeech;
        private final String definition;

        // Enum constructor
        private Entry(String word, String partOfSpeech, String definition) {
            this.word = word;
            this.partOfSpeech = partOfSpeech;
            this.definition = definition;
        }

        public String getWord() {
            return word;
        }

        public String getPartOfSpeech() {
            return partOfSpeech;
        }
        public int compareDefinition(Entry other) {
            return this.definition.compareToIgnoreCase(other.definition);
        }

        @Override
        public String toString() {
            return String.format("%s [%s] : %s", word, partOfSpeech, definition);
        }
        public static boolean isValidPartOfSpeech(String partOfSpeech) {
            for (Entry entry : Entry.values()) {
                if (entry.getPartOfSpeech().equalsIgnoreCase(partOfSpeech)) {
                    return true;
                }
            }
            return false;
        }
    }