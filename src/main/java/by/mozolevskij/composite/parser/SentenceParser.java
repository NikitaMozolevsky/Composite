package by.mozolevskij.composite.parser;

import by.mozolevskij.composite.entity.TextComponent;
import by.mozolevskij.composite.entity.TextComponentType;
import by.mozolevskij.composite.entity.TextComposite;
import by.mozolevskij.composite.exception.CustomException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {

    private static final String SENTENCE_REGEX = "([A-Z]|[А-ЯЁ]).+?(\\.|\\!|\\?|\\u2026)";

    public SentenceParser() {
        this.nextParser = new LexemeParser();
    }

    @Override
    public void parse(String string, TextComponent component) throws CustomException {
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            String sentence = matcher.group();
            TextComponent textComponent = new TextComposite(TextComponentType.SENTENCE);
            component.addComponent(textComponent);
            nextParser.parse(sentence, textComponent);
        }
    }
}
