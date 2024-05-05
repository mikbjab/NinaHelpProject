package TextConvert;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class ParagraphsTest {

    @Test
    public void test_getParagraph_validIndex() {
        Paragraphs paragraphs1=new Paragraphs();
        paragraphs1.setParagraphs(List.of("qwerty","asd"));
        Assert.assertEquals("qwerty",paragraphs1.getParagraph(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_getParagraph_invalidIndex() {
        Paragraphs paragraphs1=new Paragraphs();
        paragraphs1.setParagraphs(List.of("qwerty","asd"));
        paragraphs1.getParagraph(3);
    }

    @Test
    public void testEquals_DifferentParagraphsObjects() {
        Paragraphs paragraphs1=new Paragraphs();
        paragraphs1.setParagraphs(List.of("qwerty","asd"));
        Paragraphs paragraphs2=new Paragraphs();
        paragraphs2.setParagraphs(List.of("asdfg","zxcvb"));
        Assert.assertNotEquals(paragraphs1,paragraphs2);
    }
    @Test
    public void testEquals_Paragraphs_sameLists() {
        Paragraphs paragraphs1=new Paragraphs();
        paragraphs1.setParagraphs(List.of("qwerty","asd"));
        Paragraphs paragraphs2=new Paragraphs();
        paragraphs2.setParagraphs(List.of("qwerty","asd"));
        Assert.assertEquals(paragraphs1,paragraphs2);
    }

    @Test
    public void testEquals_Paragraphs_sameObject() {
        Paragraphs paragraphs1=new Paragraphs();
        paragraphs1.setParagraphs(List.of("qwerty","asd"));
        Assert.assertEquals(paragraphs1,paragraphs1);
    }



    @Test
    public void testHashCode_sameLists() {
        Paragraphs paragraphs1=new Paragraphs();
        paragraphs1.setParagraphs(List.of("qwerty","asd"));
        Paragraphs paragraphs2=new Paragraphs();
        paragraphs2.setParagraphs(List.of("qwerty","asd"));
        Assert.assertEquals(paragraphs1.hashCode(),paragraphs2.hashCode());
    }

    @Test
    public void testHashCode_differentObjects() {
        Paragraphs paragraphs1=new Paragraphs();
        paragraphs1.setParagraphs(List.of("qwerty","asd"));
        Paragraphs paragraphs2=new Paragraphs();
        paragraphs2.setParagraphs(List.of("asdfg","zxcvb"));
        Assert.assertNotEquals(paragraphs1.hashCode(),paragraphs2.hashCode());
    }
}