package org.blackened.game.ui;

import org.blackened.game.ui.menuActions.MenuAction;
import org.blackened.view.View;

import java.util.List;

public abstract class ConsoleUI {
    private final View view;
    private final List<MenuAction> actions;
    private boolean isOn;

    public ConsoleUI(View view, List<MenuAction> actions) {
        this.view = view;
        this.actions = actions;
        this.isOn = true;
    }

    public abstract void execute();

    protected View getView() {
        return view;
    }

    protected List<MenuAction> getActions() {
        return actions;
    }

    protected boolean isOn() {
        return isOn;
    }

    protected void setOn(boolean on) {
        isOn = on;
    }
}
