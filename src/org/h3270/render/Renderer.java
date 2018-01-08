package org.h3270.render;

import org.h3270.host.Screen;

public interface Renderer {

    boolean canRender(Screen s);

    boolean canRender(String screenText);

    String render(Screen s);

    String render(Screen s, String actionURL);

    String render(Screen s, String actionURL, String id);

}
