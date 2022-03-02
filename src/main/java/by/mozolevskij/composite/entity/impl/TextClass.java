package by.mozolevskij.composite.entity.impl;

import java.util.ArrayList;
import java.util.List;

public class TextClass {

    private List<Paragraph> paragraphs = new ArrayList<>();
    private String text;

    public void addParagraph(Paragraph paragraph) {
        paragraphs.add(paragraph);
    }

    public Paragraph getParagraph(int i) {
        return paragraphs.get(i);
    }

    public List<Sentence> getAllSentences() {
        List<Sentence> sentences = new ArrayList<>();
        for (Paragraph paragraph : paragraphs) {
            for (Sentence sentence : paragraph) {
                sentences.add(sentence);
            }
        }
        return sentences;
    }

    public List<Word> getAllWords() {
        List<Word> words = new ArrayList<>();
        for (Paragraph paragraph : paragraphs) {
            for (Sentence sentence : paragraph) {
                for (SimplePart sp : sentence) {
                    words.add((Word) sp);
                }
            }
        }
        return words;
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }
}
