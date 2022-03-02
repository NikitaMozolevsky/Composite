package by.mozolevskij.composite.parser;

public abstract class AbstractParser {

    public AbstractParser nextParser;

    public abstract void parse(String string);

}
