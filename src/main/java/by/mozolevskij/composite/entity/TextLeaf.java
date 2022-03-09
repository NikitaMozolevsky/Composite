package by.mozolevskij.composite.entity;

import by.mozolevskij.composite.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextLeaf implements TextComponent {

    static final Logger logger = LogManager.getLogger();
    private char character;
    private TextComponentType textComponentType;

    public TextLeaf(char character, TextComponentType textComponentType) {
        this.character = character;
        this.textComponentType = textComponentType;
    }

    public char getCharacter() {
        return character;
    }

    public TextComponentType getTextComponentType() {
        return textComponentType;
    }

    @Override
    public void addComponent(TextComponent component) {
        logger.log(Level.ERROR, "UnsupportedOperationException");
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeComponent(TextComponent component) throws CustomException {
        logger.log(Level.ERROR, "UnsupportedOperationException");
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextLeaf textLeaf = (TextLeaf) o;

        if (character != textLeaf.character) return false;
        return textComponentType == textLeaf.textComponentType;
    }

    @Override
    public int hashCode() {
        int result = character;
        result = 31 * result + (textComponentType != null ? textComponentType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TextLeaf{");
        sb.append("character=").append(character);
        sb.append(", textComponentType=").append(textComponentType);
        sb.append('}');
        return sb.toString();
    }
}
