package org.blackened.db.account.factory;

import org.blackened.db.account.GameAccount;
import org.blackened.service.GameSession;

public class AccountFactory {

    private final GameSession session;

    public AccountFactory(GameSession session) {

        this.session = session;
    }

    public void create(String login, String password) {
        GameAccount acc = new GameAccount(login, password);
        session.setAccount(acc);
    }

}
