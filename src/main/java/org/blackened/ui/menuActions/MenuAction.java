package org.blackened.ui.menuActions;

import org.blackened.db.account.factory.AccountFactory;
import org.blackened.game.Displayable;
import org.blackened.game.entity.hero.Hero;
import org.blackened.service.GameSession;
import org.blackened.ui.ActionResult;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

import java.util.List;
import java.util.regex.Pattern;

public abstract class MenuAction implements Displayable {
    private final GameSession session;
    private final String title;
    private final View view;
    private final Pattern ACCOUNT_NAME_PATTERN = Pattern.compile("^[A-Za-z0-9]{6,15}$");

    public MenuAction(String title, View view, GameSession session) {
        this.title = title;
        this.view = view;
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

    protected View getView() {
        return view;
    }

    protected String getLine() {
        return view.getLine();
    }

    protected boolean isInputValid(String accountName) {
        return ACCOUNT_NAME_PATTERN.matcher(accountName).matches();
    }

    protected void printExitText() {
        getView().render(GameMessages.BACK_TEXT);
        getView().render(GameMessages.GO_BACK);
    }

    protected boolean isInfoForExit(String login) {
        return login.equals("1");
    }

    protected String getValidLine() {
        String info = getLine();

        while (!isInputValid(info)) {
            getView().render(GameMessages.PLEASE_TRY_AGAIN);
            info = getLine();
        }
        return info;
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

    protected int choseYourHero(List<Hero> heroes) {
        String input = getLine();
        int inputNumeric = Integer.parseInt(input);
        //check that is number
        while (inputNumeric > heroes.size()) {
            getView().render(GameMessages.PLEASE_TRY_AGAIN);
            input = getLine();
        }
        return inputNumeric;
    }
}
