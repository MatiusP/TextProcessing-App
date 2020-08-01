package by.epamtc.protsko.textprocessing.bean;

import java.util.ArrayList;
import java.util.List;

public class TextBlock implements DataComponent {

    private String textBlock;
    private List<Sentence> sentences;

    public TextBlock(String textBlock) {
        this.textBlock = textBlock;
        sentences = new ArrayList<>();
    }

    public String getTextBlock() {
        return textBlock;
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

        if (textBlock != null ? !textBlock.equals(textBlock1.textBlock) : textBlock1.textBlock != null) return false;
        return sentences != null ? sentences.equals(textBlock1.sentences) : textBlock1.sentences == null;
    }

    @Override
    public int hashCode() {
        int result = textBlock != null ? textBlock.hashCode() : 0;
        result = 31 * result + (sentences != null ? sentences.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TextBlock: " + textBlock + ", sentences=" + sentences;
    }
}
