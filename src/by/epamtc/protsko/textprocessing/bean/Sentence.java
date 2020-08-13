package by.epamtc.protsko.textprocessing.bean;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

    private String data;
    private List<SentenceComponent> sentenceComponents;

    public Sentence(String data) {
        this.data = data;
        sentenceComponents = new ArrayList<>();
    }

    public String getData() {
        return data;
    }

    public void setSentenceComponents(List<SentenceComponent> sentenceComponents) {
        this.sentenceComponents = sentenceComponents;
    }

    public List<SentenceComponent> getSentenceComponents() {
        return sentenceComponents;
    }

    public void addSentenceComponent(SentenceComponent component) {
        sentenceComponents.add(component);
    }

    public void removeSentenceComponent(SentenceComponent component) {
        sentenceComponents.remove(component);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;

        Sentence sentence1 = (Sentence) o;

        if (data != null ? !data.equals(sentence1.data) : sentence1.data != null) return false;
        return sentenceComponents != null ? sentenceComponents.equals(sentence1.sentenceComponents) : sentence1.sentenceComponents == null;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (sentenceComponents != null ? sentenceComponents.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Sentence: " + data + " sentenceComponents=" + sentenceComponents;
    }
}
