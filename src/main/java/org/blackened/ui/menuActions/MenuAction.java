package org.blackened.ui.menuActions;

import org.blackened.db.account.factory.AccountFactory;
import org.blackened.game.Displayable;
import org.blackened.service.GameSession;
import org.blackened.ui.ActionResult;
import org.blackened.ui.ConsoleInput;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

public abstract class MenuAction extends ConsoleInput implements Displayable {

    private final GameSession session;
    private final String title;

    public MenuAction(String title, View view, GameSession session) {
        super(view);
        this.title = title;
        this.session = session;
    }

    public abstract ActionResult execute();

    @Override
    public String getDisplayName() {
        return title;
    }

    protected GameSession getSession() {
        return session;
    }

    protected void printExitText() {
        getView().render(GameMessages.BACK_TEXT);
        getView().render(GameMessages.GO_BACK);
    }

    protected void invokeAccountFactory(String login, String password) {
        try {
            new AccountFactory(session)
                    .create(login, password);
            session.saveAccount();
        } catch (Exception e) {
            System.err.println("LogIn is already exist!!!\nPlease chose another name:\n" + e.getMessage());
        }
    }

}
