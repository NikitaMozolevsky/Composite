package by.mozolevskij.composite.parser;

import by.mozolevskij.composite.entity.TextComponent;
import by.mozolevskij.composite.entity.TextComponentType;
import by.mozolevskij.composite.entity.TextComposite;
import by.mozolevskij.composite.entity.TextLeaf;
import by.mozolevskij.composite.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordAndPunctuationParser extends AbstractParser {

    static final Logger logger = LogManager.getLogger();
    private static final String WORD_PUNCTUATION_REGEX = "[\\wа-яА-ЯёЁ']+|[\\p{Punct}\\u2026]";
    private static final String WORD_REGEX = "[\\wа-яА-ЯёЁ']+";
    private static final String PUNCTUATION_REGEX = "[\\p{Punct}|\\u2026]";

    public WordAndPunctuationParser() {
        nextParser = new LetterAndApostropheParser();
    }

    @Override
    public void parse(String data, TextComponent component) throws CustomException {
        Pattern pattern = Pattern.compile(WORD_PUNCTUATION_REGEX);
        Matcher matcher = pattern.matcher(data);
            for (int i = 0; i <= matcher.groupCount(); i++) {
                if (matcher.group(i).matches(WORD_REGEX)) {
                    TextComponent wordComponent = new TextComposite(TextComponentType.WORD);
                    component.addComponent(wordComponent);
                    nextParser.parse(matcher.group(i), component);
                    logger.log(Level.INFO, "word - {}", matcher.group(i));
                }
                else if (matcher.group(i).matches(PUNCTUATION_REGEX)) {
                    TextLeaf punctuationLeaf = new TextLeaf(matcher.group(i).charAt(i), TextComponentType.PUNCTUATION);
                    component.addComponent(punctuationLeaf);
                    logger.log(Level.INFO, "punctuation - {}", matcher.group(i).charAt(i));
                }
        }
    }
}
