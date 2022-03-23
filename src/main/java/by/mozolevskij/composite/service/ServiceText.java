package by.mozolevskij.composite.service;

import by.mozolevskij.composite.entity.TextComponent;
import by.mozolevskij.composite.entity.TextComposite;
import by.mozolevskij.composite.exception.CustomException;

import java.util.List;
import java.util.Map;

public interface ServiceText {
    List<TextComponent> sortParagraphsByNumbersOfSentences(TextComposite textComposite) throws CustomException;
    List<TextComponent> findSentencesWithTheLongestWord(TextComposite textComposite) throws CustomException;
    void removeFromTheTextAllSentencesWithLessThanAGivenNumberOfWords(TextComposite textComposite, Integer countOfWords) throws CustomException;
    Map<TextComponent, Integer> findAllTheSameWordsInTheTextAndCountTheirNumber(TextComposite textComposite) throws CustomException;
    String CountTheNumberOfVowelsAndConsonantsInASentence(TextComposite textComposite) throws CustomException;
}
