package org.blackened.db.account;

public class OnlineAccountStorage implements AccountStorage {

    private GameAccount gameAccount;

    @Override
    public GameAccount load() {
        return null; //load from server
    }

    @Override
    public void save(GameAccount account) {
        //saveTo Server
    }
}
