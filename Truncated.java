public class Truncated implements TextBlock {
    // +--------+------------------------------------------------------------
    // | Fields |
    // +--------+
  
    /**
     * The original text block.
     */
    TextBlock originalBlock;
  
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
    public Truncated(TextBlock originalBlock, int maxWidth) {
      this.originalBlock = originalBlock;
      this.maxWidth = maxWidth;
    } // Truncated(TextBlock, int)
  
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
        originalRow = originalBlock.row(i);
      } catch (Exception e) {
        throw new Exception("Invalid row " + i);
      }
  
      if (originalRow.length() <= maxWidth) {
        int padding = (maxWidth - originalRow.length()) / 2;
        String paddedContent = TBUtils.spaces(padding) + originalRow + TBUtils.spaces(padding);
        return paddedContent;
      } else {
        return originalRow.substring(0, maxWidth);
      }
    } // row(int)
  
    /**
     * Determine how many rows are in the block.
     */
    public int height() {
      return originalBlock.height();
    } // height()
  
    /**
     * Determine how many columns are in the block.
     */
    public int width() {
      return Math.min(originalBlock.width(), maxWidth);
    } // width()
}
