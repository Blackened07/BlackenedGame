package org.blackened.game.ui.menuActions.startActions;

import org.blackened.game.ui.menuActions.MenuAction;
import org.blackened.service.GameSession;
import org.blackened.view.GameMessages;
import org.blackened.view.View;


public class CreateAccountAction extends MenuAction {

    public CreateAccountAction(String title, View view, GameSession session) {
        super(title, view, session);

    }

    @Override
    public void execute() {

        getView().render(GameMessages.ACC_CREATION);

        String login = enterLogin();

        getView().render(GameMessages.ACC_CREATION_PASSWORD_PHASE, login);

        String password = enterPassword();

        invokeAccountFactory(login, password);
    }


}
