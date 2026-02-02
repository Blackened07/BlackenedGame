package org.blackened.view;

import org.blackened.game.Displayable;

import java.util.List;

public interface View {

    void render(GameMessages message);

    void render(GameMessages message, Object... args);

    void renderMenu(List<? extends Displayable> collection, GameMessages messages);

    String getLine();
}
