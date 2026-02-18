package org.blackened.ui.menuActions.startActions;


import org.blackened.service.SessionService;
import org.blackened.service.StorageType;
import org.blackened.ui.ActionResult;
import org.blackened.ui.ConsoleInput;
import org.blackened.ui.menuActions.MenuAction;
import org.blackened.view.View;

public class OnlineAction extends MenuAction {

    public OnlineAction(String title, View view, ConsoleInput consoleInput, SessionService sessionService) {
        super(title, view, consoleInput, sessionService);
    }

    @Override
    public ActionResult execute() {
        getRegistrationSession().initStorage(StorageType.ONLINE);
        return ActionResult.SUCCESS;
    }
}
