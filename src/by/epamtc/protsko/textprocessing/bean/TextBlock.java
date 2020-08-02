package by.epamtc.protsko.textprocessing.bean;

import java.util.ArrayList;
import java.util.List;

public class TextBlock implements DataComponent {

    private String data;
    private List<Sentence> sentences;

    public TextBlock(String data) {
        this.data = data;
        sentences = new ArrayList<>();
    }

    public String getData() {
        return data;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    public void removeSentence(Sentence sentence) {
        sentences.remove(sentence);
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextBlock)) return false;

        TextBlock textBlock1 = (TextBlock) o;

        if (data != null ? !data.equals(textBlock1.data) : textBlock1.data != null) return false;
        return sentences != null ? sentences.equals(textBlock1.sentences) : textBlock1.sentences == null;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (sentences != null ? sentences.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + ": " + data + ", sentences=" + sentences;
    }
}
