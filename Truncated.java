/**
 * An implementation to truncate an input block
 * within a specified width.
 * @author Jonathan Wang
 * September 2023
 */
public class Truncated implements TextBlock {
    private TextBlock contents;
    private int maxWidth;
  
    public Truncated(TextBlock contents, int maxWidth) {
      this.contents = contents;
      this.maxWidth = maxWidth;
    }
  
    // Methods (required by TextBlock interface)
    public String row(int i) throws Exception {
      if (contents.width() == 0) { // If width is 0
        return "";
      }

      String originalRow = contents.row(i);
  
      int padding = (maxWidth - originalRow.length()); // Set space between the TextLine and the rest of the width
      String leftJustified = String.format("%" + (originalRow.length()) + "s", originalRow); // Format right side of the Textline
      leftJustified = String.format("%-" + (padding + leftJustified.length()) + "s", leftJustified); // Format left side of the Textline
  
      // Truncate text if the TextLine length is less than the overall width
      if (originalRow.length() > maxWidth) {
        return originalRow.substring(0, maxWidth); // Truncate string
      } else {
        return leftJustified; // Return whitespace to the right of the textline
      }
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
