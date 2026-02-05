package org.blackened.ui;

import org.blackened.ui.menuActions.MenuAction;
import org.blackened.view.View;

import java.util.List;


public abstract class ConsoleUI extends ConsoleInput {

    private final List<MenuAction> actions;
    private boolean isRunning;

    public ConsoleUI(View view, List<MenuAction> actions) {
        super(view);
        this.actions = actions;
        this.isRunning = true;
    }

    public abstract UIResponse execute();

    protected abstract UIResponse resultHandler(ActionResult result, int index);

    protected List<MenuAction> getActions() {
        return actions;
    }

    protected boolean isRunning() {
        return isRunning;
    }

    protected void setRunning(boolean running) {
        isRunning = running;
    }


}
