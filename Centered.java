public class Centered implements TextBlock {
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
     * Build a new centered block.
     */
    public Centered(TextBlock contents, int width) {
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
        
        int padding = (maxWidth - unjRow.length()) / 2;
        String centered = String.format("%" + (padding + unjRow.length()) + "s", unjRow);

        return centered;
        }

        public int height() {
            return contents.height();
            
        }
    
        public int width() {
            return maxWidth;
        }
    }
