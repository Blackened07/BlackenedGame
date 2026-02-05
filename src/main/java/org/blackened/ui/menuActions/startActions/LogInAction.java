package org.blackened.ui.menuActions.startActions;

import org.blackened.ui.ActionResult;
import org.blackened.ui.menuActions.MenuAction;
import org.blackened.service.GameSession;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

public class LogInAction extends MenuAction {

    public LogInAction(String title, View view, GameSession session) {
        super(title, view, session);
    }

    @Override
    public ActionResult execute() {

        printExitText();
        getView().render(GameMessages.REQUEST_TO_ENTER_LOGIN);

        String login = getValidLineForLogIn();

        if (isLineForExit(login)) {
            return ActionResult.CONTINUE;
        }

        getView().render(GameMessages.REQUEST_TO_ENTER_PASSWORD);

        String password = getValidLineForLogIn();

        if (isLineForExit(password)) {
            return ActionResult.CONTINUE;
        }
        /// TODO НАДО ЧТОБЫ МЕТОД ПРИНИМАЛ ЛОГИН И ПАРОЛЬ! ДАЛЕЕ СТОРЕЙДЖ ОТПРАВЛЯЕТ ЗАПРОС НА СЕРВЕР!
        getSession().loadAccount();

        return ActionResult.SUCCESS;

    }

}
