package org.blackened.db.account.factory;

import org.blackened.db.account.AccountStorage;
import org.blackened.db.account.LocalAccountsStorage;
import org.blackened.db.account.OnlineAccountStorage;
import org.blackened.service.StorageType;

import static org.blackened.service.StorageType.OFFLINE;
import static org.blackened.service.StorageType.ONLINE;

public class StorageFactory {

    public AccountStorage create(StorageType type) {
        if (type == OFFLINE) {
            return new LocalAccountsStorage();
        } else if (type == ONLINE) {
            return new OnlineAccountStorage();
        }
        return null;
    }
}
