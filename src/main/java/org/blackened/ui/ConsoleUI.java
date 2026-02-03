package org.blackened.ui;

import org.blackened.ui.menuActions.MenuAction;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

import java.util.List;

public abstract class ConsoleUI {
    private final View view;
    private final List<MenuAction> actions;
    private boolean isRunning;

    public ConsoleUI(View view, List<MenuAction> actions) {
        this.view = view;
        this.actions = actions;
        this.isRunning = true;
    }
    //В ЭКШЕНАХ ВОЗВРАЩАТЬ  ЕНАМ
    public abstract UIResponse execute();

    protected abstract UIResponse resultHandler(ActionResult result, int index);

    protected View getView() {
        return view;
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

    protected int parser(String line) {
        int numeric = 0;
        try {
            numeric = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            view.render(GameMessages.HELL_ERROR);
        }
        return numeric;
    }



}
