/**
 * An implementation to truncate an input block within a specified width.
 * 
 * @author: Jonathan Wang
 * September 2023
 */
public class Truncated implements TextBlock {
  private TextBlock contents;
  private int maxWidth;

  /**
   * Constructs a Truncated object with the given contents and maxWidth.
   *
   * @param contents The TextBlock to be truncated.
   * @param maxWidth The maximum width for truncation.
   */
  public Truncated(TextBlock contents, int maxWidth) {
    this.contents = contents;
    this.maxWidth = maxWidth;
  }

  /**
   * Get the truncated row at the specified index.
   *
   * @param i The index of the row.
   * @return The truncated row.
   * @throws Exception
   */
  public String row(int i) throws Exception {
    if (contents.width() == 0) {
      return "";
    }

    String originalRow = contents.row(i);

    int padding = maxWidth - originalRow.length();
    String paddedRow = String.format("%-" + (padding + originalRow.length()) + "s", originalRow);

    if (originalRow.length() > maxWidth) {
      return originalRow.substring(0, maxWidth); // Truncate string
    } else {
      return paddedRow; // Return padded row
    }
  }

  /**
   * Determine how many rows are in the block.
   *
   * @return The number of rows.
   */
  public int height() {
    return contents.height();
  }

  /**
   * Determine how many columns are in the block.
   *
   * @return The maximum width.
   */
  public int width() {
    return maxWidth;
  }
}
