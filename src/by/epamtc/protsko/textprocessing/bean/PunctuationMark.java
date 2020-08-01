package by.epamtc.protsko.textprocessing.bean;

public class PunctuationMark extends SentenceComponent {

    private String punctuationMark;

    public PunctuationMark(String punctuationMark, int componentOrder) {
        this.punctuationMark = punctuationMark;
        this.sentenceComponentOrder = componentOrder;
    }

    public String getPunctuationMark() {
        return punctuationMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PunctuationMark)) return false;

        PunctuationMark that = (PunctuationMark) o;

        return punctuationMark != null ? punctuationMark.equals(that.punctuationMark) : that.punctuationMark == null;
    }

    @Override
    public int hashCode() {
        return punctuationMark != null ? punctuationMark.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Punctuations mark: " + punctuationMark;
    }
}
