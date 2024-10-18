class Word implements Comparable<Word> {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    // Compare words alphabetically for sorting
    public int compareTo(Word other) {
        return this.word.compareTo(other.word);
    }
}