package by.mozolevskij.composite.parser;

import by.mozolevskij.composite.entity.TextComponent;
import by.mozolevskij.composite.entity.TextComponentType;
import by.mozolevskij.composite.entity.TextComposite;
import by.mozolevskij.composite.exception.CustomException;

public class LexemeParser extends AbstractParser {

    private static final String LEXEME_SPLITTER_REGEX = "\\s";

    public LexemeParser() {
        this.nextParser = new WordAndPunctuationParser();
    }


    @Override
    public void parse(String string, TextComponent component) throws CustomException {
        String[] lexemes = string.split(LEXEME_SPLITTER_REGEX);
        for (int i = 0; i < lexemes.length; i++) {
            TextComponent lexeme = new TextComposite(TextComponentType.LEXEME);
            component.addComponent(lexeme);
            nextParser.parse(lexemes[i], component);
        }
    }
}
