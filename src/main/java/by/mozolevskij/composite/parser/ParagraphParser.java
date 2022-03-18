package by.mozolevskij.composite.parser;

import by.mozolevskij.composite.entity.TextComponent;
import by.mozolevskij.composite.entity.TextComponentType;
import by.mozolevskij.composite.entity.TextComposite;
import by.mozolevskij.composite.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {

    public static final Logger logger = LogManager.getLogger();

    private static final String PARAGRAPH_PARSE_REGEX = "(^|\\n)(\\t|\\s{4})";

    public ParagraphParser() {
        this.nextParser = new SentenceParser();
    }

    private List<String> paragraphList = new ArrayList<>();

    @Override
    public void parse(String string, TextComponent component) throws CustomException {
        Pattern pattern = Pattern.compile(PARAGRAPH_PARSE_REGEX);
        /*Matcher matcher = pattern.matcher(string);*/
        paragraphList = List.of(pattern.split(string));
        for (String paragraph : paragraphList) {
            if (!paragraph.isEmpty()) {
                TextComponent textComponent = new TextComposite(TextComponentType.PARAGRAPH);
                component.addComponent(textComponent);
                nextParser.parse(paragraph, textComponent);
            }
        }
        logger.log(Level.INFO, paragraphList);


        /*while (matcher.find()) {
            String paragraph = matcher.group();
        }*/

        /*while (matcher.find()) {
            String paragraph = matcher.group();
            if (!paragraph.isEmpty()) {
                TextComponent textComponent = new TextComposite(TextComponentType.PARAGRAPH);
                component.addComponent(textComponent);
                nextParser.parse(paragraph, textComponent);
            }
        }*/

        /*paragraphList = string.split(matcher);*/
    }
}
