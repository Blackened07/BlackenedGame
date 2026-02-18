package org.blackened.ui;

import org.blackened.ui.menuActions.MenuAction;
import org.blackened.view.View;

import java.util.List;


public abstract class ConsoleUI {

    private final View view;
    private final ConsoleInput consoleInput;

    private final List<MenuAction> actions;
    private boolean isRunning;

    public ConsoleUI(View view, ConsoleInput consoleInput, List<MenuAction> actions) {
        this.view = view;
        this.consoleInput = consoleInput;
        this.actions = actions;
        this.isRunning = true;
    }

    public abstract UIResponse execute();

    protected abstract UIResponse resultHandler(ActionResult result, int index);

    protected View getView() {
        return view;
    }

    protected ConsoleInput getConsoleInput() {
        return consoleInput;
    }

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
