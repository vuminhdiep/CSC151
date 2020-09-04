package CSLib;

/**
 * <code>SFormat</code> is a utility class for formatting numbers as
 * strings.  It has methods for formatting <code>int</code>s and
 * <code>double</code>s, justified in various ways.
 *
 * @author   M. Dennis Mickunas
 */
public class SFormat {

  private static String s;  
  private static String BLANKS=
   "                                                                      ";

  /**
   * Stringifies an integer right-justified in a field of width <i>w</i>.
   *
   * @param   w     the field width.
   * @param   i     the <code>int</code> to stringify.
   *
   * @see     java.lang.Math#max(int,int)
   * @see     java.lang.String#substring(int)
   * @see     java.lang.String#length()
   */
  public static String sprintr (int w, int i) {
    if (w<=0) return "";
    s=BLANKS+i;
    return s.substring(Math.max(0, s.length()-w));
  }

  /**
   * Right-justifies a String in a field of width <i>w</i>.
   *  
   * @param   w    the field width.
   * @param   str  the <code>String</code> to justify.
   *
   * @see     java.lang.Math#max(int,int)
   * @see     java.lang.String#substring(int)
   * @see     java.lang.String#length()
   */
  public static String sprintr (int w, String str) {
    if (w<=0) return "";
    s=BLANKS+str;
    return s.substring(Math.max(0, s.length()-w));
  }

  /**
   * Stringifies a decimal with <i>r</i> decimal places to the right of 
   * the point, right-justified in a field of width <i>w</i>.
   *
   * @param   w     the field width.
   * @param   r     the number of places to the right of the decimal point.
   * @param   d     the <code>double</code> to stringify.
   *
   * @see     java.lang.Math#round(double)
   * @see     java.lang.Math#pow(double,double)
   * @see     java.lang.Math#floor(double)
   * @see     #sprintr(int,int)
   * @see     #sprintzr(int,int)
   */
  public static String sprintr (int w, int r, double d) {
    return sprintr(w-r-1, (int)d) + "." 
      + sprintzr(r, (int)Math.round(Math.pow(10.0, r)*(d-Math.floor(d))));
  } 

  /**
   * Stringifies a decimal with <i>r</i> decimal places to the right
   * of the point, in a field fitted to the number.
   *
   * @param   r     the number of places to the right of the decimal point.
   * @param   d     the <code>double</code> to stringify.
   *
   * @see     #sprintr(int,int,double)
   */
  public static String sprint (int r, double d) {
    return (int)d + sprintr(r+1, r, d);
  }

  /**
   * Stringifies a decimal with 2 decimal places to the right of
   * the point, in a field fitted to the number (as for currency).
   *
   * @param   d     the <code>double</code> to stringify.
   *
   * @see     #sprint(int,double)     
   */
  public static String sprint (double d) {
    return sprint(2, d);
  }

  /**
   * Stringifies an integer centered in a field of width <i>w</i>.
   *
   * @param   w     the field width.
   * @param   i     the <code>int</code> to stringify.
   *
   * @see     java.lang.String#length()
   * @see     java.lang.String#substring(int,int)
   */
  public static String sprintc (int w, int i) {
    String s=BLANKS+i+BLANKS;
    int start = (s.length() - w)/2;
    return s.substring(start, start+w);
  }

  /**
   * Stringifies a decimal with <i>r</i> decimal places to the right
   * of the point, centered in a field of width <i>w</i>.
   *
   * @param   w     the field width.
   * @param   r     the number of places to the right of the decimal point.
   * @param   d     the <code>double</code> to stringify.
   *
   * @see     #sprint(int,double)
   */
  public static String sprintc (int w, int r, double d) {
    return sprintc(w, sprint(r,d));
  }

  /**
   * Centers a string in a field of width <i>w</i>.
   *
   * @param   w     the field width.
   * @param   str   the <code>String</code> to center.
   *
   * @see     java.lang.String#length()
   * @see     java.lang.String#substring(int,int)
   */
  public static String sprintc (int w, String str) {
    String s=BLANKS+str+BLANKS;
    int start = (s.length() - w)/2;
    return s.substring(start, start+w);
  }

  private static String ZEROS = 
    "000000000000000000000000000000000000000000000000000000";

  /**
   * Stringifies an integer in a field of width <i>w</i>,
   * right-justified and zero-filled.
   *
   * @param   w     the field width.
   * @param   i     the <code>int</code> to stringify.
   *
   * @see     java.lang.Math#max(int,int)
   * @see     java.lang.String#length()
   * @see     java.lang.String#substring(int,int)
   */
  public static String sprintzr (int w, int i) {
    if (w<=0) return "";
    String s=ZEROS+i;
    return s.substring(Math.max(0, s.length()-w));
  }
}
