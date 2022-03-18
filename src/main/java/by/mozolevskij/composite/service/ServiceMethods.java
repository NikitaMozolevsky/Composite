package by.mozolevskij.composite.service;

import by.mozolevskij.composite.entity.TextComponent;
import by.mozolevskij.composite.exception.CustomException;

import java.util.List;
import java.util.Map;

public interface ServiceMethods {
    List<TextComponent> sortParagraphsByNumbersOfSentences(String text) throws CustomException;
    List<TextComponent> findSentencesWithTheLongestWord(String text) throws CustomException;
    void removeFromTheTextAllSentencesWithLessThanAGivenNumberOfWords(String text, Integer countOfWords) throws CustomException;
    Map<TextComponent, Integer> findAllTheSameWordsInTheTextAndCountTheirNumber(String text) throws CustomException;
    List<TextComponent> CountTheNumberOfVowelsAndConsonantsInASentence(String text) throws CustomException;
}
