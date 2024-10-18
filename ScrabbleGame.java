import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

// ScrabbleGame class managing the game logic
class ScrabbleGame {
    private ArrayList<Word> wordsList = new ArrayList<Word>();
    private Random random = new Random();

    // Read words from file and store them in a sorted list
    public void loadWords(String fileName) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                String word = scanner.nextLine().trim();
                wordsList.add(new Word(word));
            }
            Collections.sort(wordsList); // Sort the list alphabetically
                    System.out.println("Words loaded: " + wordsList.size()); // Debugging: check if words are loaded
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + fileName);
                }
            }
            

    // Generate 4 random letters for the user
    public char[] generateRandomLetters() {
        char[] randomLetters = new char[4];
        for (int i = 0; i < 4; i++) {
            randomLetters[i] = (char) (random.nextInt(26) + 'a'); // Generate a random letter
        }
        return randomLetters;
    }

    public boolean isValidWord(String userWord, char[] randomLetters) {
        userWord = userWord.trim().toLowerCase(); // Ensure input is lowercase and trimmed
         System.out.println("User word: " + userWord);
        // Check if the word can be formed using the random letters
        if (!canFormWord(userWord, randomLetters)) {
            return false; // Word cannot be formed using the letters
        }

    boolean found = Collections.binarySearch(wordsList, new Word(userWord)) >= 0;

        // Debugging: check if binary search found the word
        if (found) {
            System.out.println("Word found in dictionary.");
        } else {
            System.out.println("Word not found in dictionary.");
        }

        return found;
    }

    // Helper method to check if a word can be formed using the random letters
    private boolean canFormWord(String userWord, char[] randomLetters) {
        int[] letterCounts = new int[26]; // Array to store counts of each letter

        // Count occurrences of each letter in randomLetters
        for (char letter : randomLetters) {
            letterCounts[letter - 'a']++;
        }

        // Check if the userWord can be formed with the random letters
        for (char c : userWord.toCharArray()) {
            if (letterCounts[c - 'a'] > 0) {
                letterCounts[c - 'a']--; // Use the letter
            } else {
                return false; // Letter not available
            }
        }

        return true; // All letters are available to form the word
    }


           public void startGame() {
               System.out.println("Welcome to the Scrabble-like game!");

               // Generate 4 random letters and display them to the user
               char[] randomLetters = generateRandomLetters();
               System.out.print("Your letters: ");
               for (char letter : randomLetters) {
                   System.out.print(letter + " ");
               }
               System.out.println();

        // Ask user to enter a word
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word using these letters: ");
        String userWord = scanner.nextLine().trim();

        // Check if the user's word is valid
        if (isValidWord(userWord, randomLetters)) {
            System.out.println("Valid word! Well done!");
        } else {
            System.out.println("Invalid word. Try again.");
        }
    }
}
