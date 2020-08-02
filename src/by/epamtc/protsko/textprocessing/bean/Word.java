package by.epamtc.protsko.textprocessing.bean;

public class Word extends SentenceComponent {

    private static final TextComponentTypes type = TextComponentTypes.WORD;
    private String data;

    public Word(String data, int componentOrder) {
        this.data = data;
        this.sentenceComponentOrder = componentOrder;
    }

    public String getData() {
        return data;
    }

    public TextComponentTypes getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;

        Word word1 = (Word) o;

        return data != null ? data.equals(word1.data) : word1.data == null;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public String toString() {
        return getClass().getName() + ": " + data;
    }
}
