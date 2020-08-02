package by.epamtc.protsko.textprocessing.bean;

public class CodeBlock implements DataComponent {

    private String data;

    public CodeBlock(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CodeBlock)) return false;

        CodeBlock codeBlock1 = (CodeBlock) o;

        return data != null ? data.equals(codeBlock1.data) : codeBlock1.data == null;
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
