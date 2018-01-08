package org.h3270.host;

import java.util.List;


public interface Screen {

    /**
     * Returns the width (number of columns) of this screen.
     */
    int getWidth();

    /**
     * Returns the height (number of rows) of this screen.
     */
    int getHeight();

    /**
     * Returns the character at the given position. x and y start in the upper left hand corner, which is position
     * (0,0). Control characters are returned as blanks.
     */
    char charAt(int x, int y);

    /**
     * Returns the contents of a region on this screen.
     * 
     * @param startx
     *            x coordinate of the starting point (inclusive)
     * @param starty
     *            y coordinate of the starting point
     * @param endx
     *            x coordinate of the end point (inclusive)
     * @param endy
     *            y coordinate of the end point
     * @return the region as a String, with line breaks (newline characters) inserted
     */
    String substring(int startx, int starty, int endx, int endy);

    /**
     * Returns a part of a row on this screen, as a string.
     * 
     * @param startx
     *            x coordinate of the starting point (inclusive)
     * @param endx
     *            x coordinate of the end point (inclusive)
     * @param y
     *            number of the row
     */
    String substring(int startx, int endx, int y);

    /**
     * Returns a single row of this screen.
     * 
     * @param y
     *            the row number
     * @return the row as a String, without a terminating newline
     */
    String substring(int y);

    /**
     * Returns a list of all Fields on this screen. If there are no fields, this method returns an empty list.
     */
    List<Field> getFields();

    /**
     * Returns a Field object representing the input field at position (x,y). If there is no input field at this
     * position, this method returns null. A field begins with the character <i>after</i> the first control character,
     * and ends with the character <i>before</i> the terminating control character. Thus, for the positions of the
     * control characters themselves, this method always returns null.
     * 
     * x and y start in the upper left hand corner, which is position (0,0).
     */
    InputField getInputFieldAt(int x, int y);

    /**
     * Returns true if there is an input field at position (x, y) on this screen. Fields do not include the control
     * characters that delimit them, see {@link #getInputFieldAt getFieldAt()}.
     */
    boolean isInputField(int x, int y);

    /**
     * Gets the InputField in which the cursor is currently, or null if the cursor is not in an InputField.
     */
    InputField getFocusedField();

    /**
     * Returns true if this Screen is formatted.
     */
    boolean isFormatted();

}
