package org.blackened.ui.menuActions.startActions;

import org.blackened.service.RegistrationSession;
import org.blackened.service.SessionService;
import org.blackened.ui.ActionResult;
import org.blackened.ui.ConsoleInput;
import org.blackened.ui.menuActions.MenuAction;
import org.blackened.service.GameSession;
import org.blackened.view.GameMessages;
import org.blackened.view.View;


public class CreateAccountAction extends MenuAction {

    public CreateAccountAction(String title, View view, ConsoleInput consoleInput, SessionService sessionService) {
        super(title, view, consoleInput, sessionService);
    }

    @Override
    public ActionResult execute() {

        getView().render(GameMessages.ACC_CREATION);
        printExitText();

        String login = getConsoleInput().getValidLineForLogIn();

        if (getConsoleInput().isLineForExit(login)) {
            return ActionResult.CONTINUE;
        }

        getView().render(GameMessages.ACC_CREATION_PASSWORD_PHASE, login);

        String password = getConsoleInput().getValidLineForLogIn();

        if (getConsoleInput().isLineForExit(login)) {
            return ActionResult.CONTINUE;
        }

        createAccount(login, password);

        return ActionResult.CONTINUE;
    }

}
