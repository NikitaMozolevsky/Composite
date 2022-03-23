package by.mozolevskij.composite.service.impl;

import by.mozolevskij.composite.entity.TextComponent;
import by.mozolevskij.composite.entity.TextComponentType;
import by.mozolevskij.composite.entity.TextComposite;
import by.mozolevskij.composite.exception.CustomException;
import by.mozolevskij.composite.parser.ParagraphParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ServiceMethodsImplTest {


    public final String text1 = "It has survived - not only (five) centuries, but also the leap into 13<<2 electronic typesetting, remaining 3>>5 essentially ~6&9|(3&4) unchanged. It was popularised in the 5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n"
            + "\tIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English.\n"
            + "\tBye.\n"
            + "\tIt is a (7^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a page when looking at its layout.\n";
    public final String text2 = "It has survived - not only (five) centuries, but also the leap into 13<<2 electronic typesetting, remaining 3>>5 essentially ~6&9|(3&4) unchanged. It was popularised in the 5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n"
            + "\tIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English.\n"
            + "\tIt is a (7^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a page when looking at its layout.\n"
            + "\tBye.\n";
    public final String text3 = "\tHello my dear friend!\n"
            + "\tThis sentence contains the longest word in this text.\n"
            + "\tThis text for check. Bye.\n";
    ServiceTextImpl serviceMethods = ServiceTextImpl.getInstance();
    ParagraphParser parser = new ParagraphParser();
    TextComposite composite = new TextComposite(TextComponentType.PARAGRAPH);


    @BeforeTest
    public void beforeTest() {
        System.out.println("Test was start");
    }

    @Test
    public void testSortParagraphsByNumbersOfSentences() throws CustomException {
        parser.parse(text1, composite);
        List<TextComponent> sorted = serviceMethods.sortParagraphsByNumbersOfSentences(composite);
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent component : sorted) {
            stringBuilder.append(component.toString());
        }
        Assertions.assertEquals(stringBuilder, text1);
    }

    @Test
    public void testFindSentencesWithTheLongestWord() throws CustomException {
        List<TextComponent> compositeList = serviceMethods.findSentencesWithTheLongestWord(composite);
        String actual = compositeList.get(0).toString();
        System.out.println(actual);
        String expected = "Sorting an array is a common task when writing Java applications. The Arrays.sort() method allows you to sort the elements of an array in ascending order:\n";
        Assertions.assertEquals(actual, expected);
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Test was end");
    }
}