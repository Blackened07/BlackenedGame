package org.blackened.service;

import org.blackened.db.account.AccountStorage;
import org.blackened.db.account.GameAccount;
import org.blackened.db.account.factory.StorageFactory;
import org.blackened.game.entity.hero.Hero;

import java.util.List;

public class GameSession {

    private GameAccount account;
    private final StorageFactory storageFactory;
    private AccountStorage storage;
    private Hero currentHero;

    public GameSession(StorageFactory storageFactory) {
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

    public void saveAccount() {
        storage.save(account);
    }

    public GameAccount getAccount() {
        return account;
    }

    public void setHeroToAccountList(Hero hero) {
        account.setHeroes(hero);
        saveAccount();
    }

    public void saveHero(int index) {
        this.currentHero = account.getHero(index);
    }

    public Hero getCurrentHero() {
        return currentHero;
    }

    public List<Hero> getHeroesList() {
        if (account.checkHeroesListIsNotEmpty()) {
            return account.getHeroesList();
        }
        return List.of();
    }

    public int getHeroesListSize() {
        return account.getHeroesList().size();
    }

}
