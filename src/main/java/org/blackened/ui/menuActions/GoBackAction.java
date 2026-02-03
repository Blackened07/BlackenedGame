package org.blackened.ui.menuActions;

import org.blackened.service.GameSession;
import org.blackened.ui.ActionResult;
import org.blackened.view.View;

public class GoBackAction extends MenuAction {

    public GoBackAction(String title, View view, GameSession session) {
        super(title, view, session);
    }

    @Override
    public ActionResult execute() {
        return ActionResult.BACK;
    }
}
