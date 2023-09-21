public class RightJustified implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The original text block.
   */
   TextBlock contents;

  /**
   * The maximum width for truncation.
   */
   int maxWidth;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new truncated block.
   */
  public RightJustified(TextBlock contents, int maxWidth) {
    this.contents = contents;
    this.maxWidth = maxWidth;
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
    String originalRow;
    try {
        originalRow = contents.row(i);
    } catch (Exception e) {
        throw new Exception("Invalid row " + i);
    }

    int padding = (maxWidth - originalRow.length());

    String rightJustified = String.format("%" + (padding + originalRow.length()) + "s", originalRow);
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
