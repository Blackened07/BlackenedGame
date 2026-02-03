package org.blackened.ui.menuActions.startActions;

import org.blackened.service.StorageType;
import org.blackened.ui.ActionResult;
import org.blackened.ui.ConsoleUI;
import org.blackened.ui.menuActions.MenuAction;
import org.blackened.service.GameSession;
import org.blackened.view.View;

public class OnlineAction extends MenuAction {

    public OnlineAction(String title, View view, GameSession session) {
        super(title, view, session);
    }

    @Override
    public ActionResult execute() {
        getSession().initStorage(StorageType.ONLINE);
        return ActionResult.SUCCESS;
    }
}
