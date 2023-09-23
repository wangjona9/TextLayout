import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

class TextBlockTests {

    @Test
    void testEqual() {
        TextBlock textBlock1 = new TextLine("Hello");
        TextBlock textBlock2 = new TextLine("Hello");
        assertTrue(TBUtils.equal(textBlock1, textBlock2));

        TextBlock textBlock3 = new TextLine("Hello");
        TextBlock textBlock4 = new TextLine("World");
        assertFalse(TBUtils.equal(textBlock3, textBlock4));
    }

    @Test
    void testEqv() {
        TextBlock textBlock1 = new TextLine("Hello");
        TextBlock textBlock2 = new TextLine("Hello");
        assertTrue(TBUtils.eqv(textBlock1, textBlock2));

        TextBlock textBlock3 = new BoxedBlock(new TextLine("Hello"));
        TextBlock textBlock4 = new TextLine("Hello");
        assertFalse(TBUtils.eqv(textBlock3, textBlock4));
    }

    @Test
    void testEq() {
        TextBlock textBlock1 = new TextLine("Hello");
        TextBlock textBlock2 = textBlock1;
        assertTrue(TBUtils.eq(textBlock1, textBlock2));

        TextBlock textBlock3 = new TextLine("Hello");
        TextBlock textBlock4 = new TextLine("Hello");
        assertFalse(TBUtils.eq(textBlock3, textBlock4));
    }

    @Test
    void testSpaces() {
        assertEquals("  ", TBUtils.spaces(2));
        assertEquals("      ", TBUtils.spaces(6));
    }

    @Test
    void testDashes() {
        assertEquals("--", TBUtils.dashes(2));
        assertEquals("------", TBUtils.dashes(6));
    }
}
