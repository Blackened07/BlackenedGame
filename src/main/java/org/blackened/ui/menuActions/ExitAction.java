package org.blackened.ui.menuActions;

import org.blackened.ui.ActionResult;
import org.blackened.service.GameSession;
import org.blackened.view.View;

public class ExitAction extends MenuAction {

    public ExitAction(String title, View view, GameSession session) {
        super(title, view, session);
    }

    @Override
    public ActionResult execute() {
        System.exit(0);
    }
}
