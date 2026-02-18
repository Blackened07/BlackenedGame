package org.blackened.ui.menuActions.startActions;

import org.blackened.service.RegistrationSession;
import org.blackened.service.SessionService;
import org.blackened.ui.ActionResult;
import org.blackened.ui.ConsoleInput;
import org.blackened.ui.menuActions.MenuAction;
import org.blackened.service.GameSession;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

public class LogInAction extends MenuAction {

    public LogInAction(String title, View view, ConsoleInput consoleInput, SessionService sessionService) {
        super(title, view, consoleInput, sessionService);
    }

    @Override
    public ActionResult execute() {

        printExitText();
        getView().render(GameMessages.REQUEST_TO_ENTER_LOGIN);

        String login = getConsoleInput().getValidLineForLogIn();

        if (getConsoleInput().isLineForExit(login)) {
            return ActionResult.CONTINUE;
        }

        getView().render(GameMessages.REQUEST_TO_ENTER_PASSWORD);

        String password = getConsoleInput().getValidLineForLogIn();

        if (getConsoleInput().isLineForExit(password)) {
            return ActionResult.CONTINUE;
        }
        /// TODO НАДО ЧТОБЫ МЕТОД ПРИНИМАЛ ЛОГИН И ПАРОЛЬ! ДАЛЕЕ СТОРЕЙДЖ ОТПРАВЛЯЕТ ЗАПРОС НА СЕРВЕР!
        getRegistrationSession().loadAccount();

        return ActionResult.SUCCESS;

    }

}
