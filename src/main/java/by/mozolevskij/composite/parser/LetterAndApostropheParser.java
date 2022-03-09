package by.mozolevskij.composite.parser;

import by.mozolevskij.composite.entity.TextComponent;
import by.mozolevskij.composite.entity.TextComponentType;
import by.mozolevskij.composite.entity.TextLeaf;
import by.mozolevskij.composite.exception.CustomException;

public class LetterAndApostropheParser extends AbstractParser {

    @Override
    public void parse(String string, TextComponent component) throws CustomException {
        char[] characters = string.toCharArray();
        for (char character : characters) {
            if (character == '\'') {
                component.addComponent(new TextLeaf(character, TextComponentType.PUNCTUATION));
            }
            else component.addComponent(new TextLeaf(character, TextComponentType.LETTER));
        }
    }
}
