package by.epamtc.protsko.textprocessing.bean;

public class PunctuationMark extends SentenceComponent {

    private String data;

    public PunctuationMark(String data, int componentOrder) {
        this.data = data;
        this.sentenceComponentOrder = componentOrder;
    }

    public String getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PunctuationMark)) return false;

        PunctuationMark that = (PunctuationMark) o;

        return data != null ? data.equals(that.data) : that.data == null;
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
