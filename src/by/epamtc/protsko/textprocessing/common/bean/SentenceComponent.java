package by.epamtc.protsko.textprocessing.common.bean;

import java.io.Serializable;

public abstract class SentenceComponent implements Serializable {
    protected int sentenceComponentOrder;

    public int getSentenceComponentOrder() {
        return sentenceComponentOrder;
    }

    public abstract TextComponentTypes getType();
}
