package by.epamtc.protsko.textprocessing.bean;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

    private String sentence;
    private List<SentenceComponent> sentenceComponents;

    public Sentence(String sentence) {
        this.sentence = sentence;
        sentenceComponents = new ArrayList<>();
    }

    public String getSentence() {
        return sentence;
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

        if (sentence != null ? !sentence.equals(sentence1.sentence) : sentence1.sentence != null) return false;
        return sentenceComponents != null ? sentenceComponents.equals(sentence1.sentenceComponents) : sentence1.sentenceComponents == null;
    }

    @Override
    public int hashCode() {
        int result = sentence != null ? sentence.hashCode() : 0;
        result = 31 * result + (sentenceComponents != null ? sentenceComponents.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Sentence: " + sentence + " sentenceComponents=" + sentenceComponents;
    }
}
