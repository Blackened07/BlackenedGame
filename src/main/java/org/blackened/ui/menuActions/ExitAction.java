package org.blackened.ui.menuActions;

import org.blackened.service.RegistrationSession;
import org.blackened.service.SessionService;
import org.blackened.ui.ActionResult;
import org.blackened.service.GameSession;
import org.blackened.ui.ConsoleInput;
import org.blackened.view.View;

public class ExitAction extends MenuAction {

    public ExitAction(String title, View view, ConsoleInput consoleInput, SessionService sessionService) {
        super(title, view, consoleInput, sessionService);
    }

    @Override
    public ActionResult execute() {
        return ActionResult.EXIT;
    }
}
