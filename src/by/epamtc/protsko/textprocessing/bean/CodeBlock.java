package by.epamtc.protsko.textprocessing.bean;

public class CodeBlock implements DataComponent {

    private String codeBlock;

    public CodeBlock(String codeBlock) {
        this.codeBlock = codeBlock;
    }

    public String getCodeBlock() {
        return codeBlock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CodeBlock)) return false;

        CodeBlock codeBlock1 = (CodeBlock) o;

        return codeBlock != null ? codeBlock.equals(codeBlock1.codeBlock) : codeBlock1.codeBlock == null;
    }

    @Override
    public int hashCode() {
        return codeBlock != null ? codeBlock.hashCode() : 0;
    }

    @Override
    public String toString() {
        return  "codeBlock: " + codeBlock;
    }
}
