/**
 * An implementation to right-justify an input block
 * within a specified width, truncating if necessary.
 * 
 * author Jonathan Wang
 * September 2023
 */
public class RightJustified implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The original text block.
   */
  private TextBlock contents;

  /**
   * The maximum width for truncation.
   */
  private int maxWidth;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new right-justified block.
   */
  public RightJustified(TextBlock contents, int width) {
      this.contents = contents;
      this.maxWidth = width;
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * 
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {
      String unjRow = contents.row(i);

      // Truncate content if it's smaller than maxWidth
      if (unjRow.length() > maxWidth) {
          unjRow = unjRow.substring(0, maxWidth);
      }

      int padding = maxWidth - unjRow.length();

      // Add space to the left of the TextLine
      String rightJustified = String.format("%" + (padding + unjRow.length()) + "s", unjRow); 

      return rightJustified;
  }

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
      return contents.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
      return maxWidth;
  } // width()
}
