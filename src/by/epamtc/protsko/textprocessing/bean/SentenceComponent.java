package by.epamtc.protsko.textprocessing.bean;

public abstract class SentenceComponent {
    protected int sentenceComponentOrder;

    public int getSentenceComponentOrder() {
        return sentenceComponentOrder;
    }

    public abstract TextComponentTypes getType();
}
