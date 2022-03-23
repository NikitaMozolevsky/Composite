package by.mozolevskij.composite.service.impl;

import by.mozolevskij.composite.entity.TextComponent;
import by.mozolevskij.composite.entity.TextComponentType;
import by.mozolevskij.composite.entity.TextComposite;
import by.mozolevskij.composite.exception.CustomException;
import by.mozolevskij.composite.parser.ParagraphParser;
import by.mozolevskij.composite.service.ServiceText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class ServiceTextImpl implements ServiceText {

    public static final Logger logger = LogManager.getLogger();
    static ServiceTextImpl serviceMethods = new ServiceTextImpl();
    private static final String vowelsRegex = "^(?ui:[аеёиоуыэюя]).*";

    private ServiceTextImpl() {
    }

    public static ServiceTextImpl getInstance() {
        return serviceMethods;
    }

    @Override
    public List<TextComponent> sortParagraphsByNumbersOfSentences(TextComposite textComposite) throws CustomException {
        List<TextComponent> paragraphs = textComposite.getChildComponentsList();

        return paragraphs.stream()
                .sorted(Comparator.comparingInt(p -> p.getChildComponentsList()
                        .size())).collect(Collectors.toList());
    }

    @Override
    public List<TextComponent> findSentencesWithTheLongestWord(TextComposite textComposite) throws CustomException {
        List<TextComponent> paragraphs = textComposite.getChildComponentsList();
        int sizeOfLongestWord = paragraphWords(textComposite).stream().mapToInt(String::length).max().getAsInt();
        return paragraphs.stream().flatMap(paragraph -> paragraph.getChildComponentsList().stream()).filter(sentence -> sentence
                        .getChildComponentsList().stream().anyMatch(lexeme -> lexeme
                                .getChildComponentsList().stream().filter(word -> word
                                        .getTextComponentType().equals(TextComponentType.WORD))
                                .anyMatch(simple -> simple.getChildComponentsList().size() == sizeOfLongestWord)))
                .collect(Collectors.toList());

    }

    @Override
    public void removeFromTheTextAllSentencesWithLessThanAGivenNumberOfWords
            (TextComposite textComposite, Integer countOfWords) throws CustomException {
        List<TextComponent> paragraphs = textComposite.getChildComponentsList();
        /*paragraphs.stream().flatMap(paragraph -> paragraph.getChildComponentsList()
                .stream().filter(sentence -> sentence.getChildComponentsList()
                        .stream().anyMatch(lexeme -> lexeme.getChildComponentsList().size()<countOfWords : ;)))*/
        for (TextComponent paragraph : paragraphs) {
            for (TextComponent sentence : paragraph.getChildComponentsList()) {
                for (TextComponent lexeme : sentence.getChildComponentsList()) {
                    if (lexeme.getTextComponentType().equals(TextComponentType.WORD)) {
                        if (sentence.getChildComponentsList().size() < countOfWords) {
                            textComposite.removeComponent(sentence);
                        }
                    }
                }
            }
        }
    }

    @Override
    public Map<TextComponent, Integer> findAllTheSameWordsInTheTextAndCountTheirNumber(TextComposite textComposite) throws CustomException {
        Map<TextComponent, Integer> sameWords = new HashMap<>();
        int count = 1;
        for (TextComponent paragraph : textComposite.getChildComponentsList()) {
            for (TextComponent sentence : paragraph.getChildComponentsList()) {
                for (TextComponent lexeme : sentence.getChildComponentsList()) {
                    for (TextComponent word : lexeme.getChildComponentsList()) {
                        if (sameWords.containsKey(word)) {
                            sameWords.put(word, sameWords.get(word) + 1);
                        }
                        else {
                            sameWords.put(word, count);
                        }
                    }
                }
            }
        }
        return new HashMap<>();
    }

    @Override
    public String CountTheNumberOfVowelsAndConsonantsInASentence(TextComposite textComposite) {
        int vowels = 0;
        int consonants = 0;
        for (TextComponent paragraph : textComposite.getChildComponentsList()) {
            for (TextComponent sentence : paragraph.getChildComponentsList()) {
                for (TextComponent lexeme : sentence.getChildComponentsList()) {
                    for (TextComponent word : lexeme.getChildComponentsList()) {
                        if (word.getTextComponentType().equals(TextComponentType.WORD)) {
                            for (TextComponent simplePart : word.getChildComponentsList()) {
                                if (simplePart.toString().matches(vowelsRegex)) {
                                    vowels++;
                                }
                                else {
                                    consonants++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return vowels + ", " + consonants;
    }

    public ArrayList<String> paragraphWords(TextComposite composite) throws CustomException {
        ArrayList<String> words = new ArrayList<>();

        for (TextComponent paragraph : composite.getChildComponentsList()) {
            for (TextComponent sentence : paragraph.getChildComponentsList()) {
                for (TextComponent lexeme : sentence.getChildComponentsList()) {
                    for (TextComponent word : lexeme.getChildComponentsList()) {
                        if (word.getTextComponentType().equals(TextComponentType.PARAGRAPH)) {
                            words.add(word.toString());
                        }
                    }
                }
            }
        }
        return words;
    }
}
