public class Main {
    public static void main(String[] args) {
        ScrabbleGame game = new ScrabbleGame();
        game.loadWords("CollinsScrabbleWords_2019.txt"); // Make sure the text file is in the same directory
        game.startGame();
    }
}