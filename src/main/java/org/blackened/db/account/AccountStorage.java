package org.blackened.db.account;

public interface AccountStorage {

    GameAccount load();

    void save(GameAccount account);


}
