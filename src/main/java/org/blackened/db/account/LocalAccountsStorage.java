package org.blackened.db.account;

import org.blackened.utils.JsonReader;
import org.blackened.utils.JsonWriter;


public class LocalAccountsStorage implements AccountStorage {

    @Override
    public GameAccount load() {
       return JsonReader.load();
    }

    @Override
    public void save(GameAccount account) {
        JsonWriter.write(account, account.getLogin());
    }


}
