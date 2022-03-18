package by.mozolevskij.composite.entity;

public enum TextComponentType {

    TEXT("", ""),
    PARAGRAPH("\t", "\n"),
    SENTENCE("", ""), //предложение
    LEXEME("", " "),
    WORD("", ""),
    LETTER("",""),
    PUNCTUATION("","");


    private final String prefix;
    private final String postfix;

    private TextComponentType(String prefix, String postfix) {
        this.prefix = prefix;
        this.postfix = postfix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getPostfix() {
        return postfix;
    }
}
