/**
 * An implementation to vertically flip
 * an input block's contents.
 * @author Jonathan Wang
 * September 2023
 */
public class VerticallyFlipped implements TextBlock {
    private TextBlock contents;

    public VerticallyFlipped(TextBlock unjBox) {
        this.contents = unjBox;
    }

    public String row(int i) throws Exception {
        return this.contents.row(this.contents.height() - i - 1); // Change the positioning of each row
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
