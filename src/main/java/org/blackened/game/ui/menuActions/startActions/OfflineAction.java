package org.blackened.game.ui.menuActions.startActions;

import org.blackened.game.ui.menuActions.MenuAction;
import org.blackened.service.GameSession;
import org.blackened.utils.JsonReader;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class OfflineAction extends MenuAction {

    public OfflineAction(String title, View view, GameSession session) {
        super(title, view, session);

    }

    @Override
    public void execute() {

        getSession().initLocalStorage();

        if (isLocalProfileExist()) {

            getSession().loadAccount();

        } else {
            getView().render(GameMessages.ACC_CREATION);

            String login = enterLogin();

            getView().render(GameMessages.ACC_CREATION_PASSWORD_PHASE, login);

            String password = enterPassword();

            invokeAccountFactory(login, password);
        }
        setSuccess(true);
    }

    private boolean isLocalProfileExist() {
        Path acc = Paths.get(JsonReader.PATH);

        return Files.exists(acc);
    }
}
