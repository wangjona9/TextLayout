/**
 * An implementation to horizontally separate
 * an input block with a specified input char.
 * @author Jonathan Wang
 * September 2023
 */
public class HorizontalSeparator implements TextBlock {
    // The character used for the separator.
    char separatorChar;
    int width;

    public HorizontalSeparator(char separatorChar, int maxWidth) {
        this.separatorChar = separatorChar;
        this.width = maxWidth;
    } // HorizontalSeparator(char, int)

    /**
     * Get one row from the block.
     *
     * @pre 0 <= i < this.height()
     * @exception Exception if the precondition is not met
     */
    public String row(int i) throws Exception {
        if (i < 0 || i >= this.height()) {
            throw new Exception("Invalid row " + i);
        }
        return String.valueOf(separatorChar).repeat(width); // Separate the entire box with the input char
    } // row(int)

    /**
     * Determine how many rows are in the block.
     */
    public int height() {
        return 1; // The separator is only one row tall
    } // height()

    /**
     * Determine how many columns are in the block.
     */
    public int width() {
        return width;
    } // width()
}
