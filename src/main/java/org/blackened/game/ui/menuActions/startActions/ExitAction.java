package org.blackened.game.ui.menuActions.startActions;

import org.blackened.game.ui.menuActions.MenuAction;
import org.blackened.service.GameSession;
import org.blackened.view.View;

public class ExitAction extends MenuAction {

    public ExitAction(String title, View view, GameSession session) {
        super(title, view, session);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
