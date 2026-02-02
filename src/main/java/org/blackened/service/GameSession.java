package org.blackened.service;

import org.blackened.db.account.AccountStorage;
import org.blackened.db.account.GameAccount;
import org.blackened.db.account.LocalAccountsStorage;
import org.blackened.db.account.OnlineAccountStorage;
import org.blackened.game.entity.hero.Hero;

import java.util.List;

public class GameSession {

    private GameAccount account;

    private AccountStorage storage;

    public GameSession() {
    }

    public void initLocalStorage() {
        this.storage = new LocalAccountsStorage();
    }

    public void initOnlineStorage() {
        this.storage = new OnlineAccountStorage();
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
