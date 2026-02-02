package org.blackened.game.ui.menuActions;

import org.blackened.db.account.GameAccount;
import org.blackened.db.account.factory.AccountFactory;
import org.blackened.game.Displayable;
import org.blackened.game.entity.hero.Hero;
import org.blackened.service.GameSession;
import org.blackened.view.GameMessages;
import org.blackened.view.View;

import java.util.List;
import java.util.regex.Pattern;

public class MenuAction implements Displayable {
    private final GameSession session;
    private final String title;
    private final View view;
    private boolean isSuccess;
    private final Pattern ACCOUNT_NAME_PATTERN = Pattern.compile("^[A-Za-z0-9]{6,15}$");

    public MenuAction(String title, View view, GameSession session) {
        this.title = title;
        this.view = view;
        this.session = session;
    }

    public void execute(){};

    public Hero executeHero(){
        return new Hero("");
    }

    public boolean isOperationSuccess() {
        return isSuccess;
    }



    protected GameSession getSession() {
        return session;
    }

    protected void setSuccess(boolean success) {
        isSuccess = success;
    }

    protected View getView() {
        return view;
    }

    protected String getLine() {
        return view.getLine();
    }

    @Override
    public String getDisplayName() {
        return title;
    }

    protected boolean isInputValid(String accountName) {
        return ACCOUNT_NAME_PATTERN.matcher(accountName).matches();
    }

    protected String enterLogin() {
        String login = getLine();

        while (!isInputValid(login)) {
            getView().render(GameMessages.PLEASE_TRY_AGAIN);
            login = getLine();
        }
        return login;
    }

    protected String enterPassword() {
        String password = getLine();

        while (!isInputValid(password)) {
            getView().render(GameMessages.PLEASE_TRY_AGAIN);
            password = getLine();
        }
        return password;
    }

    protected void invokeAccountFactory(String login, String password) {
        try {
            new AccountFactory(session)
                    .create(login, password);
            session.saveAccount();
            setSuccess(true);
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
