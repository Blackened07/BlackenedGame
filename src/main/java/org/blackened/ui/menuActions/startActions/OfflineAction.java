package org.blackened.ui.menuActions.startActions;


import org.blackened.service.SessionService;
import org.blackened.service.StorageType;
import org.blackened.ui.ActionResult;
import org.blackened.ui.ConsoleInput;
import org.blackened.ui.menuActions.MenuAction;
import org.blackened.utils.JsonReader;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class OfflineAction extends MenuAction {

    public OfflineAction(String title, View view, ConsoleInput consoleInput, SessionService sessionService) {
        super(title, view, consoleInput, sessionService);
    }

    @Override
    public ActionResult execute() {

        ActionResult result;

        getRegistrationSession().initStorage(StorageType.OFFLINE);

        if (isLocalProfileExist()) {
            /// ТУТ ТОЖЕ ПРИДЁТСЯ ВВОДИТЬ ДАННЫЕ!!!
            getRegistrationSession().loadAccount();

        } else {
            getView().render(GameMessages.ACC_CREATION);
            printExitText();

            String login = getConsoleInput().getValidLineForLogIn();

            if (getConsoleInput().isLineForExit(login)) {
                return ActionResult.BACK;
            }

            getView().render(GameMessages.ACC_CREATION_PASSWORD_PHASE, login);

            String password = getConsoleInput().getValidLineForLogIn();

            if (getConsoleInput().isLineForExit(password)) {
                return ActionResult.BACK;
            }

            createAccount(login, password);

        }
        result = ActionResult.SUCCESS;
        return result;
    }

    private boolean isLocalProfileExist() {
        Path acc = Paths.get(JsonReader.PATH);

        return Files.exists(acc);
    }
}
