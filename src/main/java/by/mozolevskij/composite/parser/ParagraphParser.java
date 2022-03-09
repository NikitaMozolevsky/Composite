package by.mozolevskij.composite.parser;

import by.mozolevskij.composite.entity.TextComponent;
import by.mozolevskij.composite.entity.TextComponentType;
import by.mozolevskij.composite.entity.TextComposite;
import by.mozolevskij.composite.exception.CustomException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {

    private static final String PARAGRAPH_PARSE_REGEX = "(^|\\n)(\\t|\\s{4})";

    ParagraphParser() {
        this.nextParser = new SentenceParser();
    }

    @Override
    public void parse(String string, TextComponent component) throws CustomException {
        Pattern pattern = Pattern.compile(PARAGRAPH_PARSE_REGEX);
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            String paragraph = matcher.group();
            if (!paragraph.isEmpty()) {
                TextComponent textComponent = new TextComposite(TextComponentType.PARAGRAPH);
                component.addComponent(textComponent);
                nextParser.parse(paragraph, textComponent);
            }
        }
    }
}
