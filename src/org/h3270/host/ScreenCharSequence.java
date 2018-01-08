package org.h3270.host;

import org.h3270.render.TextRenderer;

public class ScreenCharSequence {

    private Screen screen = null;
    private String text = null;
    private int width = 0;
    // private int height = 0;

    private TextRenderer renderer = new TextRenderer();

    public ScreenCharSequence(final Screen s) {
        screen = s;
        width = screen.getWidth();
        // height = screen.getHeight();
        text = renderer.render(s);
    }

    public int length() {
        return text.length();
    }

    public char charAt(final int index) {
        return text.charAt(index);
    }

    public String subSequence(final int start, final int end) {
        return text.substring(start, end);
    }

    public String toString() {
        return text;
    }

    public Field getFieldAt(final int index) {
        if (index < 0 || index >= length()) {
            throw new IndexOutOfBoundsException();
        }
        final int y = index / (width + 1);
        final int x = index % (width + 1);
        if (x == width) {
            return null;
        } else {
            return screen.getInputFieldAt(x, y);
        }
    }

}
