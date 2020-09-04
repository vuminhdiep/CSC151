package CSLib;

/**
 * <code>Timer</code> is a utility class for causing a program to
 * pause for a specified period of time.
 *
 * @author   M. Dennis Mickunas 
 */
public class Timer {

  /**
   * Pauses for a specific period of time.
   *
   * @see     java.lang.Thread#sleep(long)
   *
   * @param   msec  the specific number of milliseconds to pause.
   */
  public static void pause (long msec) {
    try {Thread.sleep(msec);}
    catch (InterruptedException e) {}
  }
}
