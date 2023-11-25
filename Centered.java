/**
 * An implementation to center an input block
 * within a specified width, truncating if necessary.
 * 
 * @author: Jonathan Wang
 * September 2023
 */
public class Centered implements TextBlock {
  // Fields

  /**
   * The original text block.
   */
  private TextBlock contents;

  /**
   * The maximum width for truncation.
   */
  private int maxWidth;

  // Constructors

  /**
   * Constructs a new centered block.
   *
   * @param contents The TextBlock to be centered.
   * @param maxWidth The maximum width for truncation.
   */
  public Centered(TextBlock contents, int maxWidth) {
    this.contents = contents;
    this.maxWidth = maxWidth;
  }

  // Methods

  /**
   * Get one row from the block, centered within the specified width.
   *
   * @param i The index of the row.
   * @return The centered row.
   * @throws IllegalArgumentException if the index is out of bounds.
   */
  public String row(int i) throws IllegalArgumentException {
    String unjustifiedRow = contents.row(i);

    // Truncate content if it's larger than maxWidth
    if (unjustifiedRow.length() > maxWidth) {
      unjustifiedRow = unjustifiedRow.substring(0, maxWidth);
    }

    int padding = (maxWidth - unjustifiedRow.length()) / 2;

    // Center the row within the maxWidth
    String centeredRow = String.format("%" + (padding + unjustifiedRow.length()) + "s", unjustifiedRow);
    centeredRow = String.format("%-" + (padding + centeredRow.length()) + "s", centeredRow);

    return centeredRow;
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
