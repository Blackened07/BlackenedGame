package org.blackened.ui.menuActions.startActions;

import org.blackened.ui.ActionResult;
import org.blackened.ui.menuActions.MenuAction;
import org.blackened.service.GameSession;
import org.blackened.view.GameMessages;
import org.blackened.view.View;


public class CreateAccountAction extends MenuAction {

    public CreateAccountAction(String title, View view, GameSession session) {
        super(title, view, session);

    }

    @Override
    public ActionResult execute() {

        getView().render(GameMessages.ACC_CREATION);
        printExitText();

        String login = getValidLine();

        if (isInfoForExit(login)) {
            return ActionResult.BACK;
        }

        getView().render(GameMessages.ACC_CREATION_PASSWORD_PHASE, login);

        String password = getValidLine();

        if (isInfoForExit(login)) {
            return ActionResult.BACK;
        }

        invokeAccountFactory(login, password);

        return ActionResult.CONTINUE;
    }




}
