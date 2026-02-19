package org.blackened.ui.menuActions;

import org.blackened.db.account.GameAccount;
import org.blackened.db.account.factory.AccountFactory;
import org.blackened.service.GameSession;
import org.blackened.service.RegistrationSession;
import org.blackened.service.SessionService;
import org.blackened.ui.ActionResult;
import org.blackened.ui.ConsoleInput;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

public abstract class MenuAction implements Displayable {
    private final View view;
    private final ConsoleInput consoleInput;
    private final SessionService sessionService;
    private final String title;

    public MenuAction(String title, View view, ConsoleInput consoleInput, SessionService sessionService) {
        this.view = view;
        this.title = title;
        this.consoleInput = consoleInput;
        this.sessionService = sessionService;
    }

    public abstract ActionResult execute();

    @Override
    public String getDisplayName() {
        return title;
    }

    protected View getView() {
        return view;
    }

    protected ConsoleInput getConsoleInput() {
        return consoleInput;
    }

    protected GameSession getGameSession() {
        return sessionService.getGameSession();
    }

    protected RegistrationSession getRegistrationSession() {
        return sessionService.getRegistrationSession();
    }

    protected void printExitText() {
        getView().render(GameMessages.BACK_TEXT);
        getView().render(GameMessages.GO_BACK);
    }
    /// Если ошибка - надо сообщить и вернуться в стартУИ
    protected void createAccount(String login, String password) {
        try {
            GameAccount account = new AccountFactory()
                    .create(login, password);
            getGameSession().setAccount(account);
            getRegistrationSession().saveAccount(account);
        } catch (Exception e) {
            System.err.println("LogIn is already exist!!!\nPlease chose another name:\n" + e.getMessage());
        }
    }

}
