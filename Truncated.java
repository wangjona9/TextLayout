public class Truncated implements TextBlock {
    private TextBlock contents;
    private int maxWidth;

    public Truncated(TextBlock originalBlock, int maxWidth) {
        this.contents = originalBlock;
        this.maxWidth = maxWidth;
    }

    public String row(int i) throws Exception {
        String originalRow;
        try {
            originalRow = this.contents.row(i);
        } catch (Exception e) {
            throw new Exception("Invalid row " + i);
        }

        if (originalRow.length() <= maxWidth) {
            int padding = (maxWidth - originalRow.length()) / 2;
            String paddedContent = TBUtils.spaces(padding) + originalRow + TBUtils.spaces(padding);
            return paddedContent;
        } else if (originalRow.length() > maxWidth ) {
            return originalRow.substring(0, maxWidth);
        }

        return originalRow;  
    }

    public int height() {
        return contents.height();
    }

    public int width() {
        return Math.min(contents.width(), maxWidth);
    }
}

