package org.h3270.host;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;


public abstract class AbstractScreen implements Screen {

    protected final Logger logger = Logger.getLogger(AbstractScreen.class);

    protected char[][] buffer = null;

    protected int width = 0;
    protected int height = 0;
    protected int cursorX = 0;
    protected int cursorY = 0;

    protected boolean isFormatted = true;

    protected List<Field> fields = new ArrayList<Field>();

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char charAt(final int x, final int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IndexOutOfBoundsException("(" + x + ", " + y + ")" + ", should be in (0.." + width + ", 0.."
                    + height + ")");
        }
        final InputField f = getInputFieldAt(x, y);
        if (f != null) {
            final String value = f.getValue();
            return value.charAt(x - f.getStartX());
        } else {
            final char[] line = buffer[y];
            if (x >= line.length) {
                return ' ';
            } else {
                return line[x];
            }
        }
    }

    public String substring(final int startx, final int starty, final int endx, final int endy) {
        if (starty > endy) {
            return "";
        } else if (starty == endy) {
            if (startx > endx) {
                return "";
            } else {
                return this.substring(startx, endx, starty);
            }
        } else {
            final StringBuffer result = new StringBuffer();
            result.append(this.substring(startx, width - 1, starty));
            result.append('\n');
            for (int y = starty + 1; y < endy; y++) {
                result.append(this.substring(y));
                result.append('\n');
            }
            result.append(this.substring(0, endx, endy));
            return result.toString();
        }
    }

    public String substring(final int startx, final int endx, final int y) {

        String s = null;

        try {
            s = new String(buffer[y], startx, endx - startx + 1);
        } catch (final Exception e) {
            logger.error("Error parsing substring", e);
        }
        return s;
    }

    public String substring(final int y) {
        return new String(buffer[y]);
    }

    public List<Field> getFields() {
        return Collections.unmodifiableList(fields);
    }

    public InputField getInputFieldAt(final int x, final int y) {
        for (final Iterator<Field> i = fields.iterator(); i.hasNext();) {
            final Field f = i.next();
            if (f instanceof InputField && !f.isEmpty()) {
                final int startx = f.getStartX();
                final int starty = f.getStartY();
                final int endx = f.getEndX();
                final int endy = f.getEndY();

                if (y < starty) {
                    continue;
                }
                if (y == starty) {
                    if (x < startx) {
                        continue;
                    }
                    if (y == endy && x > endx) {
                        continue;
                    }
                    return (InputField) f;
                }
                if (y > endy) {
                    continue;
                }
                if (y == endy) {
                    if (x > endx) {
                        continue;
                    }
                    return (InputField) f;
                } else { // full row between start and end
                    return (InputField) f;
                }
            }
        }
        return null;
    }

    public boolean isInputField(final int x, final int y) {
        return getInputFieldAt(x, y) != null;
    }

    public InputField getFocusedField() {
        return this.getInputFieldAt(cursorX, cursorY);
    }

    public boolean isFormatted() {
        return isFormatted;
    }

}
