package by.epamtc.protsko.textprocessing.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Text implements Serializable {

    private List<DataComponent> data;

    public Text() {
        data = new ArrayList<>();
    }

    public List<DataComponent> getData() {
        return data;
    }

    public void addDataComponent(DataComponent dataComponent) {
        data.add(dataComponent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Text)) return false;

        Text text1 = (Text) o;

        return data != null ? data.equals(text1.data) : text1.data == null;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}
