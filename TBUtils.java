import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Utilities for TextBlocks.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2014
 */
public class TBUtils {
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as the program operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program operates.
   */
  static String lotsOfSpaces = "  ";

  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len) {
    // Note: This strategy probably represents an overkill in
    // attempts at efficiency.
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    } // while
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)

  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block) {
    for (int i = 0; i < block.height(); i++) {
      // Even though we only call block.row with a valid i,
      // we need to put the call in a try/catch block.
      try {
        pen.println(block.row(i));
      } catch (Exception e) {
        pen.println();
      } // catch (Exception)
    } // for
  } // print(PrintWriter, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  static String spaces(int len) {
    // As with dashes, this is probably overkill.
    // Make sure the collection of dashes is big enough
    while (lotsOfSpaces.length() < len) {
      lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
    } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)

  public static boolean eqv(TextBlock t1, TextBlock t2) {
    // Use and operand to test both t1 & t2
    return t1.getClass() == t2.getClass() && equal(t1, t2);
}

  public static boolean equal(TextBlock t1, TextBlock t2) {
    // check for height and width of t1 & t2
    if (t1.height() != t2.height() || t1.width() != t2.width()) {
      return false;
    }

    for (int i = 0; i < t1.height(); i++) { // loop through height
      try {
        if (!t1.row(i).equals(t2.row(i))) { // loop through each row
          return false;
        }
      } catch (Exception e) {
        e.getStackTrace();
        return false;
      }
    }
    return true;
  }

  public static boolean eq(TextBlock t1, TextBlock t2) { 
    return t1 == t2; // use the == operand to return a boolean
}

public static void print(PrintStream out, TextBlock boxedBlock) {
}


} // class TBUtils
