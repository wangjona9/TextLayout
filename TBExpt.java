import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    // Truncated class
    TextBlock truncatedText = new TextLine("Truncated");
    BoxedBlock truncatedBox = new BoxedBlock(truncatedText);
    TextBlock truncated = new Truncated(truncatedBox, 5);
    TBUtils.print(pen, truncated);

    Truncated truncated2 = new Truncated(truncatedText, 20);
    BoxedBlock truncatedbox2 = new BoxedBlock(truncated2);
    TBUtils.print(pen, truncatedbox2);


    // Centered class
    TextBlock centeredText = new TextLine("Centered");
    BoxedBlock centeredBox = new BoxedBlock(centeredText);
    TextBlock centeredBlock = new Centered(centeredBox, 20);
    TBUtils.print(pen, centeredBlock);

    Centered centered2 = new Centered(centeredText, 20);
    BoxedBlock centeredBox2 = new BoxedBlock(centered2);
    TBUtils.print(pen, centeredBox2);


    // RightJustified class
    TextBlock rightJustifiedText = new TextLine("Right Justified");
    BoxedBlock rightJustifiedBox = new BoxedBlock(rightJustifiedText);
    TextBlock rightJustifedBlock = new Centered(rightJustifiedBox, 20);
    TBUtils.print(pen, rightJustifedBlock);

    RightJustified rightJustified2 = new RightJustified(rightJustifiedText, 20);
    BoxedBlock rightJustifiedBox2 = new BoxedBlock(rightJustified2);
    TBUtils.print(pen, rightJustifiedBox2);


    // Textline for HorizontallyFlipped, VerticallyFlipped, & HorizontalSeparator classes
    TextBlock hello = new TextLine("Hello");
    TextBlock goodbye = new TextLine("Goodbye");


    // Vcomposition to create BoxedBlock
    VComposition helloGoodbye = new VComposition(hello, goodbye);
    BoxedBlock helloGoodbyeBox = new BoxedBlock(helloGoodbye);
    TBUtils.print(pen, helloGoodbyeBox);


    // HorizontallyFlipped class
    HorizontallyFlipped horizontallyFlippedBlock = new HorizontallyFlipped(helloGoodbyeBox);
    TBUtils.print(pen, horizontallyFlippedBlock);


    // VerticallyFlipped class
    VerticallyFlipped verticallyFlippedBox = new VerticallyFlipped(helloGoodbyeBox);
    TBUtils.print(pen, verticallyFlippedBox);

    
    // HorizontalSeparator class
    HorizontalSeparator separatedText = new HorizontalSeparator('#', 20);
    BoxedBlock separatedTextBlock = new BoxedBlock(separatedText);
    TBUtils.print(pen, separatedTextBlock);

    pen.close();
  } // main(String[])

} // class TBExpt
