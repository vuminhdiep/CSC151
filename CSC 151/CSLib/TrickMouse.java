package CSLib;
import java.awt.*;
import java.awt.event.*;

/**
 * <code>TrickMouse</code> is a special class used as an example in the text.
 * It should really be in a package of its own, separate from <code>CSLib</code>.
 *
 * @author   M. Dennis Mickunas
 */
public class TrickMouse extends Frame {
  private Image[] img = new Image[2];
  private String message;
  private int which;

  /**
   * Constructs a TrickMouse
   */
  public TrickMouse () {
    super("Trick Mouse");

    // the "hit wall" image
    img[0] = Toolkit.getDefaultToolkit().getImage("C:/BlueJ/CSLib/t4.gif");
    // the "speaking" image
    img[1] = Toolkit.getDefaultToolkit().getImage("C:/BlueJ/CSLib/t1.gif");

    setSize(200, 200);
    setVisible(true);

    // Use an anonymous inner class to implement the two WindowAdapter
    // methods of interest.
    addWindowListener(new WindowAdapter() {
      public void windowClosing (WindowEvent e) {
        System.exit(0);
      }
      public void windowActivated (WindowEvent e) {
        repaint();
      }
    });
  }
  
  /**
   * Sets the title of the Trick Mouse
   *
   * @param  title     the <code>String</code> to set the title to.
   */
  public void setTitle (String title) {
    super.setTitle(title);
  }

  /**
   * Causes the Trick Mouse to display the "hit wall" image.
   */ 
  public void hitWall () {
    which = 0;
    repaint();
  }

  /**
   * Causes the Trick Mouse to display the "speak" image.
   *
   * @param  msg     the <code>String</code> that is "spoken."
   */ 
  public void speak (String msg) {
    message = msg;
    which = 1;
    repaint();
  }

  /**
   * Redraws the screen.  The appropriate image is drawn using 
   * <code>Graphics.drawImage(Image,...)</code>.  If this is the "speak"
   * image, then the "spoken message" is printed using 
   * <code>Graphics.drawString(String,...)</code>.
   *
   * @see    java.awt.Graphics#drawImage
   * @see    java.awt.Graphics#drawString
   */
   
  public void paint (Graphics g) {
    g.drawImage(img[which], 0, 100, this);
    if (which==1) g.drawString(message, 70, 130);
  } 
}
