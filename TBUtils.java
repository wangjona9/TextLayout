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
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextBlock block = new TextLine("Hello");
    TextBlock block2 = new TextLine("GoodBye");
    TextBlock contentBlock = new TextLine("HelloHello");
    TextBlock centerBlock = new TextLine("Centered");

    BoxedBlock box = new BoxedBlock(block);
    BoxedBlock box2 = new BoxedBlock(box);
    BoxedBlock box3 = new BoxedBlock(block2);
    BoxedBlock truncatedBox = new BoxedBlock(contentBlock);
    BoxedBlock centeredBox = new BoxedBlock(centerBlock);
    BoxedBlock justifiedBox = new BoxedBlock(contentBlock);
    BoxedBlock HFlipBox = new BoxedBlock(contentBlock);


    box.row(1);
    box2.row(0);
    box3.row(1);
    // Print out the block
    TBUtils.print(pen, block);
    TBUtils.print(pen, box);
    TBUtils.print(pen, box2);
    TBUtils.print(pen, box3); 

    VComposition Vbox = new VComposition(block, block2);
    BoxedBlock Vbox1 = new BoxedBlock(Vbox);
    Vbox.row(1);
    TBUtils.print(pen, Vbox1);
    pen.println("---");


    


    VComposition HelloGoodbye = new VComposition(box, box3);
    TBUtils.print(pen, HelloGoodbye);

    HComposition right = new HComposition(box, block2);
    TBUtils.print(pen, right);

    HComposition left = new HComposition(block2, box);
    TBUtils.print(pen, left);

    TextBlock truncatedBlock = new Truncated(truncatedBox, 5); 
    TBUtils.print(pen, truncatedBlock);

    TextBlock centeredBlock = new Centered(centeredBox, 20);
    TBUtils.print(pen, centeredBlock);

    TextBlock rightJustifiedBlock = new RightJustified(justifiedBox, 20);
    TBUtils.print(pen, rightJustifiedBlock);

    TextBlock HorizontallyFlippledBlock = new HorizontallyFlipped(HFlipBox);
    TBUtils.print(pen, HorizontallyFlippledBlock);
    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
