package by.epamtc.protsko.textprocessing.bean;

import java.util.ArrayList;
import java.util.List;

public class Text implements DataComponent {

    private List<DataComponent> text;

    public Text() {
        text = new ArrayList<>();
    }

    public List<DataComponent> getText() {
        return text;
    }

    public void addDataComponent(DataComponent dataComponent) {
        text.add(dataComponent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Text)) return false;

        Text text1 = (Text) o;

        return text != null ? text.equals(text1.text) : text1.text == null;
    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }

    @Override
    public String toString() {
        return getClass().getName() + ": " + text + ';';
    }
}
