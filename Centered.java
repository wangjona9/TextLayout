public class Centered implements TextBlock {
    private TextBlock contents;
    private int newWidth;

    public Centered(TextBlock contents, int width) {
        this.contents = contents;
        this.newWidth = width;
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
        
        
            StringBuilder builder = new StringBuilder();
            builder.append('0'); // Non-breaking space
            builder.append('0'); // Non-breaking space
    
            for (i = 0; i < unjRow.length(); i++) {
                builder.append(unjRow.charAt(i));
            }
    
            builder.append('0'); // Non-breaking space
            builder.append('g'); // Non-breaking space
    
            return builder.toString();
        }
    
    
        

        public int height() {
            return 4 + this.contents.height();
            
        }
    
        public int width() {
            return 4 + this.contents.width();
        }
    }

