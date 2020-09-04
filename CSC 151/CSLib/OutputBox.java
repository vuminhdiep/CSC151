package CSLib;

import java.awt.*;

/**
 * <code>OutputBox</code> is a closable frame that holds textual output.
 * It mimics Java's <code>java.lang.System.out</code>, which is 
 * a <code>java.io.PrintStream</code>.
 *
 * @see       java.io.PrintStream
 * @see       java.awt.TextArea
 *
 * @author    M. Dennis Mickunas
 */
public class OutputBox extends ClosableFrame {

  /**
   * the area where output is printed
   */
  private TextArea outputArea;
  private Font font;
  private static final int WIDTH = 550;
  private static final int HEIGHT = 380;

  /**
   * Constructs an OutputBox with a default title.
   */
  public OutputBox () {
    this("OutputBox");
  }

  /**
   * Constructs an OutputBox with a specific title.
   *
   * @param   title  the specific <code>String</code> to use as the title
   */
  public OutputBox (String title) {
    super(title);
    setResizable(true);
    outputArea = new TextArea();
    add(outputArea);
    setSize(WIDTH, HEIGHT);
    setVisible(true);
    validate();
    setFont(new Font("Courier", Font.PLAIN, 12));
  }

  /**
   * Erases the text in the OutputBox.
   */
  public void clear () { outputArea.setText(""); }

  /**
   * Changes the font for subsequent printing.
   * 
   * @param   font  the specific <code>Font</code> to change to.
   */
  public void setFont (Font font) {
      outputArea.setFont(font);
      this.font = font;
  }

  /**
   * Prints a string.  The string printed is just what would be
   * printed by <code>java.lang.System.out.print(String)</code>.
   *
   * @param   text   the <code>String</code> to be printed
   */
  public void print (String text) { outputArea.append(text); }

  /**
   * Prints an integer.  The string printed is just what would be
   * printed by <code>java.lang.System.out.print(int)</code>.
   *
   * @param   number   the <code>int</code> to be printed
   */
  public void print (int number) { print("" + number); }

  /**
   * Prints a floating-point number.  The string printed is just what would be
   * printed by <code>java.lang.System.out.print(float)</code>.
   *
   * @param   number   the <code>float</code> to be printed
   */
  public void print (float number) { print("" + number); }

  /**
   * Prints a double-precision floating-point number.  The string 
   * printed is just what would be printed by 
   * <code>java.lang.System.out.print(double)</code>.
   *
   * @param   number   the <code>double</code> to be printed
   */
  public void print (double number) { print("" + number); }

  /**
   * Prints a boolean value.  The string printed is just what would be
   * printed by <code>java.lang.System.out.print(boolean)</code>.
   *
   * @param   b   the <code>boolean</code> to be printed
   */
  public void print (boolean b) { print("" + b); }

  /**
   * Prints a character.  The string printed is just what would be
   * printed by <code>java.lang.System.out.print(char)</code>.
   *
   * @param   c   the <code>char</code> to be printed
   */
  public void print (char c) { print("" + c); }

  /**
   * Prints a long integer.  The string printed is just what would be
   * printed by <code>java.lang.System.out.print(long)</code>.
   *
   * @param   number    the <code>long</code> to be printed
   */
  public void print (long number) { print("" + number); }

  /**
   * Prints a string buffer.  The string printed is just what would be
   * printed by <code>java.lang.System.out.print(StringBuffer)</code>.
   *
   * @param   strBuf   the <code>StringBuffer</code> to be printed
   * @see     java.lang.StringBuffer#toString()
   */
  public void print (StringBuffer strBuf) { print(strBuf.toString()); }

  /**
   * Terminates the current line by writing a carriage return character
   * followed by a newline character.
   */
  public void println () { outputArea.append("\r\n"); }

  /**
   * Prints a String and then terminates the line.  This method 
   * invokes <code>print(String)</code> and then <code>println()</code>.
   *
   * @param   number  the <code>String</code> to be printed.
   */
  public void println (String text) { print(text); println(); }

  /**
   * Prints an integer and then terminates the line.  This method behaves as
   * though it invokes <code>print(int)</code> and then
   * <code>println()</code>.
   *
   * @param   number  the <code>int</code> to be printed.
   */
  public void println (int number) { println("" + number); }

  /**
   * Prints a float and then terminates the line.  This method behaves as
   * though it invokes <code>print(float)</code> and then
   * <code>println()</code>.
   *
   * @param   number  the <code>float</code> to be printed.
   */
  public void println (float number) { println("" + number); }

  /**
   * Prints a double and then terminates the line.  This method behaves as
   * though it invokes <code>print(double)</code> and then
   * <code>println()</code>.
   *
   * @param   number  the <code>double</code> to be printed.
   */
  public void println (double number) { println("" + number); }

  /**
   * Prints a boolean and then terminates the line.  This method behaves as
   * though it invokes <code>print(boolean)</code> and then
   * <code>println()</code>.
   *
   * @param   b  the <code>boolean</code> to be printed
   */
  public void println (boolean b) { println("" + b); }

  /**
   * Print a character and then terminate the line.  This method behaves as
   * though it invokes <code>print(char)</code> and then
   * <code>println()</code>.
   *
   * @param   c  the <code>char</code> to be printed.
   */
  public void println (char c) { println("" + c); }

  /**
   * Prints a long and then terminates the line.  This method behaves as
   * though it invokes <code>print(long)</code> and then
   * <code>println()</code>.
   *
   * @param   number  The <code>long</code> to be printed.
   */
  public void println (long number) { println("" + number); }

  /**
   * Prints a string buffer and then terminates the line.  This method behaves
   * as though it invokes <code>print(StringBuffer)</code> and then
   * <code>println()</code>.
   *
   * @param   strBuf   the <code>StringBuffer</code> to be printed
   */
  public void println (StringBuffer strBuf) { println(strBuf.toString()); }

}
