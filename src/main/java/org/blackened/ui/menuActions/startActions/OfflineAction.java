package org.blackened.ui.menuActions.startActions;

import org.blackened.service.StorageType;
import org.blackened.ui.ActionResult;
import org.blackened.ui.menuActions.MenuAction;
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
    public ActionResult execute() {

        ActionResult result;

        getSession().initStorage(StorageType.OFFLINE);

        if (isLocalProfileExist()) {
            /// ТУТ ТОЖЕ ПРИДЁТСЯ ВВОДИТЬ ДАННЫЕ!!!
            getSession().loadAccount();

        } else {
            getView().render(GameMessages.ACC_CREATION);
            printExitText();

            String login = getValidLineForLogIn();

            if (isLineForExit(login)) {
                return ActionResult.BACK;
            }

            getView().render(GameMessages.ACC_CREATION_PASSWORD_PHASE, login);

            String password = getValidLineForLogIn();

            if (isLineForExit(password)) {
                return ActionResult.BACK;
            }

            invokeAccountFactory(login, password);

        }
        result = ActionResult.SUCCESS;
        return result;
    }

    private boolean isLocalProfileExist() {
        Path acc = Paths.get(JsonReader.PATH);

        return Files.exists(acc);
    }
}
