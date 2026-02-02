package org.blackened.game.ui.menuActions.startActions;

import org.blackened.game.ui.menuActions.MenuAction;
import org.blackened.service.GameSession;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

public class IntoAccountAction extends MenuAction {

    public IntoAccountAction(String title, View view, GameSession session) {
        super(title, view, session);
    }

    @Override
    public void execute() {
        getView().render(GameMessages.REQUEST_TO_ENTER_LOGIN);

        String login = enterLogin();

        getView().render(GameMessages.REQUEST_TO_ENTER_PASSWORD);

        String password = enterPassword();
        /// TODO НАДО ЧТОБЫ МЕТОД ПРИНИМАЛ ЛОГИН И ПАРОЛЬ! ДАЛЕЕ СТОРЕЙДЖ ОТПРАВЛЯЕТ ЗАПРОС НА СЕРВЕР!
        getSession().loadAccount();

        setSuccess(true);

    }

}
