package org.blackened.service;

import org.blackened.db.account.AccountStorage;
import org.blackened.db.account.GameAccount;
import org.blackened.db.account.factory.StorageFactory;

public class RegistrationSession {

    private GameAccount account;
    private final StorageFactory storageFactory;
    private AccountStorage storage;

    public RegistrationSession(StorageFactory storageFactory) {
        this.storageFactory = storageFactory;
    }

    public void initStorage(StorageType type) {

        if (storage == null) {
            storage = storageFactory.create(type);
        }

        String storageClassName = storage.getClass().getSimpleName();

        if (type == StorageType.OFFLINE && storageClassName.equals("OnlineAccountStorage")) {
            storage = storageFactory.create(type);
        } else if (type == StorageType.ONLINE && storageClassName.equals("LocalAccountsStorage")) {
            storage = storageFactory.create(type);
        }
    }

    public void setAccount(GameAccount account) {

        this.account = account;
    }

    //load acc from repo
    public void loadAccount() {
        if (this.account == null) {
            this.account = storage.load();
        }
    }

    public void saveAccount(GameAccount account) {

        storage.save(account);
    }

    public GameAccount getAccount() {

        return account;
    }
}
