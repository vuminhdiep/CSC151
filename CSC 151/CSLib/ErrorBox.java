package CSLib;

import java.awt.*;
import java.awt.event.*;

/**
 * <code>ErrorBox</code> is a dialog box used for presenting error 
 * messages.   It remains visible until the user dismisses it by 
 * clicking the "Dismiss" button.
 *
 * @author    M. Dennis Mickunas
 */

public class ErrorBox extends ClosableDialog implements ActionListener {

  /**
   * For displaying the text of the error message
   */
  private Label errorMessage;
  private Button dismissButton;
  private Font font = new Font("Helvetica", Font.PLAIN, 12);
  private static final int MIN_HEIGHT = 100;
  private static final int MIN_WIDTH = 200;
  
  /**
   * Constructs a modal error box with a generic error message.
   */
  public ErrorBox () {
    this("Error");
  }

  /**
   * Constructs a modal error box with a specific error message.
   *
   * @param   errorText  the string to be used as the error message   
   */
  public ErrorBox (String errorText) {
    super("Error", true);
    setResizable(false);
    setForeground(Color.black);
    setBackground(Color.white);
    setLayout(new GridLayout(2, 1));
  
    // Places the error message
    errorMessage = new Label(" "+errorText+" ", Label.CENTER);
    errorMessage.setFont(font);
    add(errorMessage);
  
    // Places the dismiss busson
    dismissButton = new Button("Dismiss");
    dismissButton.addActionListener(this);
    Panel p = new Panel();
    p.add(dismissButton);
    add(p);
  
    // Adjusts the box size if necessary to look decent.
    int width = getSize().width;
    int height = getSize().height;
    if (width < MIN_WIDTH) width = MIN_WIDTH;
    if (height < MIN_HEIGHT) height = MIN_HEIGHT;
    setSize(width, height);
   
    setVisible(true);
  }
  
  /**
   * Listens for the button press.  The action is to dispose of this
   * error box, thereby returning control to the program that created
   * this error box.
   *
   * @param   e  the ActionEvent that occurred
   */
  public void actionPerformed (ActionEvent e) {
     dispose();
  }
}
