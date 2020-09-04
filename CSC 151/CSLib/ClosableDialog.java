package CSLib;

import java.awt.*;
import java.awt.event.*;

/**
 * <code>ClosableDialog</code> is a base class that obeys the 
 * <code>windowClosing </code> event. It is extended by various
 * <code>CSLib</code> classes.  It uses an inner class, 
 * <code>DialogCloser</code> to implement the windowClosing listener, 
 * with <code>DialogCloser</code> extending the <code>WindowAdapter</code> 
 * class.  
 * <p>
 * <code>ClosableDialog</code> should be compared with 
 * <code>ClosableFrame</code>, which implements the 
 * <code>WindowListener</code> methods individually.
 *
 * @see     ClosableFrame
 * @see     java.awt.event.WindowAdapter
 * @see     java.awt.Dialog
 *
 * @author M. Dennis Mickunas
 */
public class ClosableDialog extends Dialog {

  /**
   * Constructs a non-modal dialog box in a new frame with a blank title; 
   * this dialog box can respond to the "window closing" event.
   */
  public ClosableDialog () {
    this (new Frame(), "", false);
  }

  /**
   * Constructs a dialog box in a new frame with a blank title and a 
   * specified modality; this dialog box can respond to the 
   * "window closing" event.
   *
   * @param modal the specified modality
   */
  public ClosableDialog (boolean modal) {
    this (new Frame(), "", modal);
  }

  /**
   * Constructs a non-modal dialog box in a new frame with a specified 
   * title; this dialog box can respond to the "window closing" event.
   *
   * @param title the string to use as this ClosableDialog title
   */
  public ClosableDialog (String title) {
    this (new Frame(), title, false);
  }

  /**
   * Constructs a dialog box in a new frame with a specified title and
   * modality; this dialog box can respond to the "window closing" event.
   *
   * @param    title     the string to use as this ClosableDialog title
   * @param    modal     the specified modality
   */
  public ClosableDialog (String title, boolean modal) {
    this (new Frame(), title, modal);
  }

  /**
   * Constructs a dialog box with a specified title and modality;
   * this dialog box can respond to the "window closing" event.
   *
   * @param    home      a Frame to parent this Dialog Box
   * @param    title     the string to use as this ClosableDialog title
   * @param    modal     the specified modality
   */
  public ClosableDialog (Frame home, String title, boolean modal) {
    super(home, title, modal);
    addWindowListener(new DialogCloser());
  }

  /**
   * <code>DialogCloser</code> is an inner class that implements the
   * windowClosing listener for <code>ClosableDialog</code>.  It does this 
   * by extending the Java convenience wrapper <code>WindowAdapter</code>.
   *
   * @see    java.awt.event.WindowAdapter
   */ 
  class DialogCloser extends WindowAdapter {
    /**
     * Cleans up the window, and terminates the program. 
     *
     * @param   e  The specific <code>WindowEvent</code> that occurred.
     */
    public void windowClosing (WindowEvent e) {
      dispose();
//      System.exit(0);
    }
  }
}
