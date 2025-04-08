import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0 || args[0].equals("--help")) {
            showHelp();
            return;
        }

        String cardsFile = args[0];
        String order = "random";  // Default order
        int repetitions = 1;  // Default repetitions
        boolean invertCards = false;

        // Parse options
        for (int i = 1; i < args.length; i++) {
            switch (args[i]) {
                case "--order":
                    order = args[++i];
                    break;
                case "--repetitions":
                    repetitions = Integer.parseInt(args[++i]);
                    break;
                case "--invertCards":
                    invertCards = true;
                    break;
            }
        }

        // Load and display cards
        List<Card> cards = loadCards(cardsFile);
        CardOrganizer organizer = new RecentMistakesFirstSorter();
        organizer.organizeCards(cards);

        // Process the cards (Dummy implementation)
        processCards(cards, repetitions, invertCards);
    }

    private static void showHelp() {
        System.out.println("Usage: flashcard <cards-file> [options]");
        System.out.println("Options:");
        System.out.println("--help              Show help");
        System.out.println("--order <order>     Order type (random, worst-first, recent-mistakes-first)");
        System.out.println("--repetitions <num> Number of repetitions");
        System.out.println("--invertCards       Invert question and answer");
    }

    private static List<Card> loadCards(String cardsFile) {
        // Dummy code to load cards
        return Arrays.asList(
            new Card("What is Java?", "A programming language"),
            new Card("What is 2 + 2?", "4")
        );
    }

    private static void processCards(List<Card> cards, int repetitions, boolean invertCards) {
        for (Card card : cards) {
            // Dummy logic to simulate card processing
            System.out.println("Question: " + card.getQuestion());
            System.out.println("Answer: " + card.getAnswer());
        }
    }
}
