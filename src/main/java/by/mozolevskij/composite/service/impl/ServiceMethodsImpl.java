package by.mozolevskij.composite.service.impl;

import by.mozolevskij.composite.entity.TextComponent;
import by.mozolevskij.composite.entity.TextComponentType;
import by.mozolevskij.composite.entity.TextComposite;
import by.mozolevskij.composite.exception.CustomException;
import by.mozolevskij.composite.parser.LexemeParser;
import by.mozolevskij.composite.parser.ParagraphParser;
import by.mozolevskij.composite.parser.WordAndPunctuationParser;
import by.mozolevskij.composite.service.ServiceMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class ServiceMethodsImpl implements ServiceMethods {

    public static final Logger logger = LogManager.getLogger();
    static ServiceMethodsImpl serviceMethods = new ServiceMethodsImpl();

    private ServiceMethodsImpl() {
    }

    public static ServiceMethodsImpl getInstance() {
        return serviceMethods;
    }

    @Override
    public List<TextComponent> sortParagraphsByNumbersOfSentences(String text) throws CustomException {
        ParagraphParser parser = new ParagraphParser();
        TextComposite composite = new TextComposite(TextComponentType.PARAGRAPH);
        parser.parse(text, composite);
        List<TextComponent> paragraphs = composite.getChildComponentsList();
        /*TextComposite longestParagraph = composite.getChildComponentsList().get(0);
        Map<TextComposite, Integer> compositeIntegerMap = new HashMap<>();
        for (TextComposite paragraph : paragraphs) {
            compositeIntegerMap.put(paragraph, paragraph.getChildComponentsList().size());

            *//*if (paragraph.getChildComponentsList().size()>longestParagraph.getChildComponentsList().size()) {
                newParagraphs.add(0, longestParagraph);
                longestParagraph = paragraph;
            }*//*
        }
        Comparator<TextComposite> textCompositeComparator = new Comparator<TextComposite>() {
            @Override
            public int compare(TextComposite o1, TextComposite o2) {
                return compositeIntegerMap.get(o1).compareTo(compositeIntegerMap.get(o2));
            }
            Map<TextComposite, Integer> compositeIntegerMapNew = new TreeMap<>();

        };*/

        return paragraphs.stream()
                .sorted(Comparator.comparingInt(p -> p.getChildComponentsList()
                        .size())).collect(Collectors.toList());
    }

    @Override
    public List<TextComponent> findSentencesWithTheLongestWord(String text) throws CustomException {
        String longestWord = "";
        List<TextComponent> words = new ArrayList<>();
        ParagraphParser parser = new ParagraphParser();
        TextComposite composite = new TextComposite(TextComponentType.PARAGRAPH);
        parser.parse(text, composite);
        for (TextComponent paragraph : composite.getChildComponentsList()) {
            for (TextComponent sentence : paragraph.getChildComponentsList()) {
                for (TextComponent word : sentence.getChildComponentsList()) {
                    if (word.getChildComponentsList().size() > longestWord.toCharArray().length && !(word.getChildComponentsList().toString() == "")) {
                        longestWord = word.toString();
                        words = new ArrayList<>();
                        words.add(word);
                    } else if (word.getChildComponentsList().size() == longestWord.toCharArray().length) {
                        words.add(word);
                    }
                }
            }
            System.out.println(words); // TODO: 15.03.2022
        }

        return words;
    }

    @Override
    public void removeFromTheTextAllSentencesWithLessThanAGivenNumberOfWords
            (String text, Integer countOfWords) throws CustomException {
        ParagraphParser parser = new ParagraphParser();
        TextComposite composite = new TextComposite(TextComponentType.PARAGRAPH);
        parser.parse(text, composite);
        for (TextComponent paragraph : composite.getChildComponentsList()) {
            for (TextComponent sentence : paragraph.getChildComponentsList()) {
                if (sentence.getChildComponentsList().size()<countOfWords) {
                    paragraph.removeComponent(sentence);
                }
            }
        }
    }

    @Override
    public Map<TextComponent, Integer> findAllTheSameWordsInTheTextAndCountTheirNumber(String text) throws CustomException {
        Map<TextComponent, Integer> sameWords = new HashMap<>();
        ParagraphParser parser = new ParagraphParser();
        TextComposite composite = new TextComposite(TextComponentType.PARAGRAPH);
        parser.parse(text, composite);
        for (TextComponent paragraph : composite.getChildComponentsList()) {
            for (TextComponent sentence : paragraph.getChildComponentsList()) {
                for (TextComponent word : sentence.getChildComponentsList()) {
                    for ()
                }
            }
        }
        return new HashMap<>();
    }

    @Override
    public List<TextComponent> CountTheNumberOfVowelsAndConsonantsInASentence(String text) {
        return null;
    }
}
