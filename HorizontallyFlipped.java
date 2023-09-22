/**
 * An implementation to horizontally flip
 * an input block's contents.
 * @author Jonathan Wang
 * September 2023
 */
public class HorizontallyFlipped implements TextBlock {
    private TextBlock contents;

    public HorizontallyFlipped(TextBlock unjBox) {
        this.contents = unjBox;
    }

    public String row(int i) throws Exception {
        StringBuilder rev = new StringBuilder(); 
        String originalRow = this.contents.row(i);
        char[] charArr = originalRow.toCharArray();

        // Loop through the contents within the originalRow and append each one to rev
        for (int j = 0; j < originalRow.length() / 2; j++) {
            char temp = charArr[j]; // Create a temporary variable
            charArr[j] = charArr[charArr.length - j - 1]; 
            charArr[charArr.length - j - 1] = temp; // Set stored value to temp
        }

        // Append to rev
        for (char chars : charArr) {
            rev.append(chars);
        }

        return rev.toString();
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
        return contents.width();
    } // width()
}
