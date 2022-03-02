package by.mozolevskij.composite.parser;

import by.mozolevskij.composite.entity.impl.Paragraph;
import by.mozolevskij.composite.entity.impl.TextClass;

import java.util.ArrayList;
import java.util.List;

public class ParseParagraph extends AbstractParser {

    private static final String PARAGRAPH_PARSE_REGEX = "(^|\\n)(\\t|\\s{4})";
    TextClass textClass = new TextClass();


    private ParseParagraph() {
        this.nextParser = new SentenceParser();
    }

    @Override
    public void parse(String string) {
        
        /*String[] paragraphs = string.split(PARAGRAPH_PARSE_REGEX);
        for (int i = 0; i < paragraphs.length; i++) {
            if(!paragraphs[i].isEmpty()) {
                textClass.addParagraph(paragraphs[i]);
            }
        }*/
    }
}
