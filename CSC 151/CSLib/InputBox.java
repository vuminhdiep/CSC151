package CSLib;

import java.awt.*;
import java.awt.event.*;

/**
 * <code>InputBox</code> is a closable dialog box that can receive and
 * translate textual keyword input into various Java types.  It can read
 * and convert integers, doubles, strings, and characters. 
 * <p>
 * The user must enter characters into a TextField, and then click on
 * the "Ok" button.  If the characters are inappropriate for the 
 * particular <code>read</code> that has been requested (for example,
 * if a letter is entered during a call to <code>readInt</code>),
 * then an <code>ErrorBox</code> is raised.
 * <p>
 * End-of-input is indicated by the user entering nothing into the
 * TextField, and then clicking on the "Ok" button.
 *
 * @author     M. Dennis Mickunas
 */

public class InputBox extends ClosableDialog implements ActionListener {

  private TextField inputLine;
  private Label prompt;
  private Button okButton;
  private Font font = new Font("Helvetica",Font.PLAIN, 12);
  /**
   * set to true when end-of-input has been indicated (by the user entering
   * an empty field).
   */
  private boolean eoi = false;
  
  private static final int MIN_WIDTH = 200;
  private static final int MIN_HEIGHT = 150;
  
  /**
   * Constructs an InputBox with a default title.
   */ 
  public InputBox () {
    this("InputBox");
  }
  
  /**
   * Constructs an InputBox with a specific title.
   *
   * @param    title  the <code>String</code> to use as the title
   */
  public InputBox (String title) {
    // Creates a modal ClosableDialog with the specified title.
    super(title, true);
    
    setResizable(false);
    setForeground(Color.black);
    setBackground(Color.white);
    setLayout(new GridLayout(3,1));
  
    prompt = new Label("Enter Data:", Label.CENTER);
    prompt.setFont(font);
    add(prompt);
  
    inputLine = new TextField(15);
    inputLine.setFont(font);
    Panel p = new Panel();
    p.add(inputLine);
    add(p);
  
    okButton = new Button("OK");
    okButton.addActionListener(this);
    p = new Panel();
    p.add(okButton);
    add(p);
  }
  
  /**
   * Sets the prompt to a particular string.
   *
   * @param    text  the specific <code>String</code> to use for the new prompt
   */
  public void setPrompt(String text) {
    prompt.setText(text);
  }
  
  /**
   * Makes the InputBox visible so that the user can enter input.
   * The size is adjusted to accommodate the prompt, if necessary.
   */
  private void display() {
    hide();
    inputLine.setText("");
    FontMetrics fm = Toolkit.getDefaultToolkit().getFontMetrics(font);
    int promptWidth = fm.stringWidth(prompt.getText());
    int inputLineWidth = inputLine.getPreferredSize().width;
    int windowWidth = Math.max(promptWidth, inputLineWidth) + 70;
    int width = Math.max(windowWidth, MIN_WIDTH);
    setSize(width, MIN_HEIGHT);
    show();
  }

  /**
   * Catches the clicking of the OK button (presumably after text has
   * been entered in the textfield.
   *
   * @param    e  the specific <code>ActionEvent</code> that occurred.
   */
  public void actionPerformed(ActionEvent e) {
      hide();
  }
  
  /** 
   * Gets the character string that the user types.  If end-of-input 
   * had been previously satisfied, then further input is ignored.
   *
   * @see      #eoi
   * @return   the <code>String</code> that was typed.
   */
  private String getInputLine() {
    if (eoi) return "";
    String s =  inputLine.getText();
    eoi = s.length() == 0;
    return s;
  }
  
  /**
   * Reads an Ascii string.  
   * End-of-input is indicated by clicking OK without entering anything.
   *
   * @return   the <code>String</code> value read.
   */
  public String readString() {
    display();
    return getInputLine();
  }
  
  /**
   * Reads an Ascii character, and converts it to an <code>char</code>.
   * End-of-input is indicated by clicking OK without entering anything.
   *
   * @see      #eoi
   * @return   the <code>char</code> value read.
   */
  public char readChar() {
    display();
    String s = getInputLine();
    if (eoi) return 0;
    return s.charAt(0);
  }
  
  /**
   * Reads an Ascii integer, and converts it to an <code>int</code>.
   * Raise an ErrorBox if a non-integer is entered.
   * End-of-input is indicated by clicking OK without entering anything.
   *
   * @see      #eoi
   * @return   the <code>int</code> value read.
   */
  public int readInt () {
    display();
    while (true) {
        String s = getInputLine();
        if (eoi) return 0;
        try {
          return Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
          error("Integer required ");
        }
    }
  }
  
  /**
   * Reads an Ascii real number, and converts it to a <code>double</code>.
   * Raise an ErrorBox if a non-real number is entered.
   * End-of-input is indicated by clicking OK without entering anything.
   *
   * @see      #eoi
   * @return   the <code>double</code> value read.
   */
  public double readDouble() {
    display();
    while (true) {
        String s = getInputLine();
        if (eoi) return 0.0;
        try {
          return Double.parseDouble(s);
        }
        catch (NumberFormatException e) {
           error ("Double required ");
        }
    }
  }
  
  /**
   * Returns the end-of-input status
   *
   * @return   <code>true</code> if end-of-input is true
   *
   * @see #eoi
   */
  public boolean eoi() {
    return eoi;
  }
  
  /**
   * Raises an ErrorBox when the user types something inappropriate.
   *
   * @param   errMsg  the message presented by the ErrorBox
   */
  private void error (String errMsg) {
    ErrorBox err = new ErrorBox(errMsg);
    display();
  }
}
