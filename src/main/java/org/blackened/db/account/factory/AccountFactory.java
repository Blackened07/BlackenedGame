package org.blackened.db.account.factory;

import org.blackened.db.account.GameAccount;

public class AccountFactory {

    public GameAccount create(String login, String password) {
        return new GameAccount(login, password);
    }

}
