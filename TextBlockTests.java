import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

/**
 * A series of tests for each block.
 * 
 * @author Jonathan Wang
 * September 2023
 */
class TextBlockTests {

  // Truncated tests
  @Test
  void testTruncatedWithValidWidth() throws Exception {
    TextBlock originalBlock = new TextLine("Hello, World!");
    Truncated truncatedBlock = new Truncated(originalBlock, 5);
    assertEquals("Hello", truncatedBlock.row(0));
  }

  @Test
  void testTruncatedWithInvalidWidth() throws Exception {
    TextBlock originalBlock = new TextLine("Hello, World!");
    Truncated truncatedBlock = new Truncated(originalBlock, 13);
    assertEquals("Hello, World!", truncatedBlock.row(0));
  }

  // Centered tests
  @Test
  void testCenteredWithEqualWidth() throws Exception {
    TextBlock originalBlock = new TextLine("Hello, World!");
    Centered centeredBlock = new Centered(originalBlock, 13);
    assertEquals("Hello, World!", centeredBlock.row(0));
  }

  @Test
  void testCenteredWithGreaterWidth() throws Exception {
    TextBlock originalBlock = new TextLine("Hello, World!");
    Centered centeredBlock = new Centered(originalBlock, 20);
    assertEquals("   Hello, World!   ", centeredBlock.row(0));
  }

  // RightJustified tests
  @Test
  void testRightJustifiedWithEqualWidth() throws Exception {
    TextBlock originalBlock = new TextLine("Hello, World!");
    RightJustified rightJustifiedBlock = new RightJustified(originalBlock, 15);
    assertEquals("  Hello, World!", rightJustifiedBlock.row(0));
  }

  @Test
  void testRightJustifiedWithGreaterWidth() throws Exception {
    TextBlock originalBlock = new TextLine("Hello, World!");
    RightJustified rightJustifiedBlock = new RightJustified(originalBlock, 20);
    assertEquals("       Hello, World!", rightJustifiedBlock.row(0));
  }

  // HorizontallyFlipped tests
  @Test
  void testHorizontallyFlippedWithTwoLines() throws Exception {
    TextBlock hello = new TextLine("Hello");
    TextBlock world = new TextLine("World");

    VComposition helloWorld = new VComposition(hello, world);
    BoxedBlock helloWorldBox = new BoxedBlock(helloWorld);

    HorizontallyFlipped horizontallyFlippedBlock = new HorizontallyFlipped(helloWorldBox);

    // Ensure the flipped block has the expected content
    assertEquals("|olleH|", horizontallyFlippedBlock.row(1));
    assertEquals("|dlroW|", horizontallyFlippedBlock.row(2));
  }

  // VerticallyFlipped tests
  @Test
  void testVerticallyFlippedWithTwoLines() throws Exception {
    TextBlock hello = new TextLine("Hello");
    TextBlock world = new TextLine("World");

    VComposition helloWorld = new VComposition(hello, world);
    BoxedBlock helloWorldBox = new BoxedBlock(helloWorld);

    VerticallyFlipped verticallyFlippedBlock = new VerticallyFlipped(helloWorldBox);
    assertEquals("|World|", verticallyFlippedBlock.row(1));
    assertEquals("|Hello|", verticallyFlippedBlock.row(2));
  }

  // HorizontalSeparator tests
  @Test
  void testHorizontalSeparator() throws Exception {
    char separatorChar = '-';
    int width = 5;

    HorizontalSeparator separator = new HorizontalSeparator(separatorChar, width);

    // Test row content
    assertEquals("-----", separator.row(0));

    // Test height
    assertEquals(1, separator.height());

    // Test width
    assertEquals(width, separator.width());
  }

  // Additional equality tests
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

  // Test creating a TextLine with an empty string
  @Test
  void testTextLineWithEmptyString() throws Exception {
      TextBlock emptyTextLine = new TextLine("");
      assertEquals("", emptyTextLine.row(0));
      assertEquals(1, emptyTextLine.height());
      assertEquals(0, emptyTextLine.width());
  }

  // Test creating a Truncated block with an empty content block
  @Test
  void testTruncatedWithEmptyContent() throws Exception {
      TextBlock emptyContentBlock = new TextLine("");
      Truncated truncatedBlock = new Truncated(emptyContentBlock, 5);
      assertEquals("", truncatedBlock.row(0));
  }

  // Test creating an empty VComposition
  @Test
  void testEmptyVComposition() throws Exception {
      TextBlock empty1 = new TextLine("");
      TextBlock empty2 = new TextLine("");
      VComposition emptyVComposition = new VComposition(empty1, empty2);
      assertEquals(2, emptyVComposition.height());
      assertEquals(0, emptyVComposition.width());
  }

  // Test behavior when truncating, centering, or right-justifying an empty block
  @Test
  void testOperationsOnEmptyBlock() throws Exception {
      TextBlock emptyBlock = new TextLine("");

      // Truncated
      Truncated truncatedEmptyBlock = new Truncated(emptyBlock, 5);
      assertEquals("", truncatedEmptyBlock.row(0));

      // Centered
      Centered centeredEmptyBlock = new Centered(emptyBlock, 10);
      assertEquals("          ", centeredEmptyBlock.row(0));

      // RightJustified
      RightJustified rightJustifiedEmptyBlock = new RightJustified(emptyBlock, 8);
      assertEquals("        ", rightJustifiedEmptyBlock.row(0));
  }

  // Test the behavior of flipping operations on an empty block
  @Test
  void testFlippingOperationsOnEmptyBlock() throws Exception {
      TextBlock emptyBlock = new TextLine("");

      // HorizontallyFlipped
      HorizontallyFlipped horizontallyFlippedEmptyBlock = new HorizontallyFlipped(emptyBlock);
      assertEquals("", horizontallyFlippedEmptyBlock.row(0));

      // VerticallyFlipped
      VerticallyFlipped verticallyFlippedEmptyBlock = new VerticallyFlipped(emptyBlock);
      assertEquals("", verticallyFlippedEmptyBlock.row(0));
  }
}
