package by.epamtc.protsko.textprocessing.bean;

public class Word extends SentenceComponent {

    private String word;

    public Word(String word, int componentOrder) {
        this.word = word;
        this.sentenceComponentOrder = componentOrder;
    }

    public String getWord() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;

        Word word1 = (Word) o;

        return word != null ? word.equals(word1.word) : word1.word == null;
    }

    @Override
    public int hashCode() {
        return word != null ? word.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Word: " + word;
    }
}
