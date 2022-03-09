package by.mozolevskij.composite.parser;

import by.mozolevskij.composite.entity.TextComponent;
import by.mozolevskij.composite.exception.CustomException;

public abstract class AbstractParser {

    public AbstractParser nextParser;

    public abstract void parse(String string, TextComponent component) throws CustomException;
}
