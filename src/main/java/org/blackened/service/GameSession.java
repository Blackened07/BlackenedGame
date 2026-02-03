package org.blackened.service;

import org.blackened.db.account.AccountStorage;
import org.blackened.db.account.GameAccount;
import org.blackened.db.account.LocalAccountsStorage;
import org.blackened.db.account.OnlineAccountStorage;
import org.blackened.db.account.factory.StorageFactory;
import org.blackened.game.entity.hero.Hero;

import java.util.List;

import static org.blackened.service.StorageType.OFFLINE;
import static org.blackened.service.StorageType.ONLINE;

public class GameSession {

    private GameAccount account;

    private AccountStorage storage;

    public GameSession() {
    }

    public void initStorage(StorageType type) {
        if (storage == null) {
            new StorageFactory().create(type);
        }
    }

    public void setAccount(GameAccount account) {
        this.account = account;
    }
    //load acc from repo
    public void loadAccount() {
        this.account = storage.load();
    }

    public void saveAccount() {
        storage.save(account);
    }

    public GameAccount getAccount() {
        return account;
    }

    public void setHero(Hero hero) {
        account.setHeroes(hero);
    }

    public List<Hero> getPlayerHeroesList() {
        if (account.checkHeroesListIsNotEmpty()) {
            return account.getHeroesList();
        }
        return List.of();
    }

}
